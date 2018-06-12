package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Service.GerenciadorClientes;
import Service.PartidaService;
import bd.dbos.Usuario;
import entity.Carta;
import entity.Mensagem;
import entity.Partida;
import exception.PartidaException;

/**
 * Classe utilizada para gerenciar todos os serviços que o Cliente precisa
 * quando chama via Socket
 * 
 * @author Felipe
 *
 */
public class UsuarioController {

	private static final int NUMEROMAXIMOJOGADORPORBARALHO = 4;
	PartidaService partidaService;
	private final String DIVISOR = ":";
	private static Map<String, PartidaService> listaPartidas = new HashMap<>();
	// private TEMPO_GANHAR_MAIS_CREDITO = 1200000; 20 min.
	private final int TEMPO_GANHAR_MAIS_CREDITO = 20000; // 20 segundos.

	/**
	 * Enviar Lista de Partidas
	 * 
	 * @return Mensagem
	 */
	public Mensagem enviaListaPartidas() {
		String resposta = new String();
		try {
			Map<String, Partida> partidas = partidaService.listarPartidas();
			for (String key : partidas.keySet()) {
				String x = "PAR:" + key + " " + partidas.get(key).getStatus() + ":";
				resposta += x;
			}
			resposta += "EOF";

		} catch (Exception e) {
			e.printStackTrace();
			return new Mensagem("ERR", "");
		}
		return new Mensagem("PAR", resposta);

	}

	/**
	 * Cria uma nova Partida
	 * 
	 * @param nome
	 * @return Mensagem
	 */
	public Mensagem criarPartida(String nome) {
		try {
			partidaService = new PartidaService();
			partidaService.novaPartida(nome);
			listaPartidas.put(nome, partidaService);
		} catch (Exception e) {
			return new Mensagem("ERR", "");
		}
		return new Mensagem("SUC", " ");

	}

	/**
	 * Entrar em uma partida
	 * 
	 * @param usuario
	 * @param partida
	 * @return Mensagem
	 */
	public Mensagem entrarPartida(Usuario usuario, String partida) {
		String resposta;
		try {

			Map<String, Partida> partidas = PartidaService.listarPartidas();

			if (partidas.get(partida).getStatus() != "jogando" || usuario.getSaldo() <= 0) {
				return new Mensagem("ERR", "");
			}
			PartidaService.setarUsuarioNaPartida(partida, usuario);
			partidaService = listaPartidas.get(partida);
			resposta = usuario.getSaldo().toString();

		} catch (Exception e) {
			e.printStackTrace();
			return new Mensagem("ERR", "");
		}
		return new Mensagem("SUC", resposta);
	}

	/**
	 * Listar usuarios na Partida
	 * 
	 * @param usuario
	 * @return Mensagem
	 */
	public Mensagem listarUsuarioNaPartida(Usuario usuario) {
		Mensagem mensagem;
		try {

			List<Usuario> usuarios = partidaService.getUsuariosNaPartida(usuario.getPartidaAtual());
			mensagem = new Mensagem();
			mensagem.setProtocolo("SUC");
			String msg = "";
			for (Usuario user : usuarios) {
				msg += user.getNome() + ":";
			}
			msg = msg.substring(0, msg.length() - 1);
			mensagem.setMensagem(msg);

		} catch (PartidaException e) {
			e.printStackTrace();
			return new Mensagem("ERR", "");
		}
		return mensagem;

	}

	/**
	 * Iniciar uma partida nova.
	 * 
	 * @param usuario
	 * @param listUsuarioGerenciador
	 */
	public void iniciarPartida(Usuario usuario, Map<String, GerenciadorClientes> listUsuarioGerenciador) {
		Mensagem mensagem = new Mensagem();
		try {

			String partida = usuario.getPartidaAtual();
			List<Usuario> usuarios = partidaService.getUsuariosNaPartida(partida);
			mensagem.setProtocolo("INI");
			String nomes = "";
			for (Usuario usuarioPartida : usuarios) {
				nomes += usuarioPartida.getNome() + DIVISOR;
				usuarioPartida.getCartasMao().clear();
				usuarioPartida.setEstourou(false);
				usuarioPartida.setParar(false);
			}
			nomes = nomes.substring(0, nomes.length() - 1);
			for (Usuario usuarioPartida : usuarios) {
				GerenciadorClientes gerenciadorClientes = listUsuarioGerenciador.get(usuarioPartida.getNome());
				gerenciadorClientes.pararThreadListarPartida();
				mensagem.setMensagem(usuarioPartida.getSaldo() + DIVISOR + nomes);
				gerenciadorClientes.enviaDados(mensagem);
			}

			Map<String, Partida> partidas = partidaService.listarPartidas();
			if (usuarios.size() > NUMEROMAXIMOJOGADORPORBARALHO)
				partidas.get(partida).setNumeroBaralhos(2);
			else
				partidas.get(partida).setNumeroBaralhos(1);
			partidas.get(partida).setStatus("iniciada");

		} catch (PartidaException e) {
			e.printStackTrace();

		}
	}

	/**
	 * Apostar em uma partida
	 * 
	 * @param usuario
	 * @param mensagem
	 * @return Mensagem
	 */
	public Mensagem setAposta(Usuario usuario, String mensagem) {
		Double aposta = new Double(mensagem);
		if (usuario.getSaldo() >= aposta) {
			partidaService.setApostaNaPartida(usuario.getPartidaAtual(), usuario.getNome(), aposta);
			new Thread() {
				@Override
				public void run() {
					usuario.setSaldo(usuario.getSaldo() - aposta);
				}
			}.start();
			return new Mensagem("SUC", usuario.getSaldo().toString());
		} else
			return new Mensagem("ERR", "Saldo Insuficiente");

	}

	/**
	 * Envia aos usuarios as apostas feitas na partida.
	 * 
	 * @param usuario
	 * @param listUsuarioGerenciador
	 */
	public void apostasNaPartida(Usuario usuario, Map<String, GerenciadorClientes> listUsuarioGerenciador) {
		Mensagem mensagem = new Mensagem();
		try {

			String partida = usuario.getPartidaAtual();
			List<Usuario> usuarios = partidaService.getUsuariosNaPartida(partida);
			mensagem.setProtocolo("APO");
			String nomes = "";
			boolean parar = true;
			// Montando dados de apostas dos usuarios
			for (Usuario usuarioPartida : usuarios) {
				nomes += usuarioPartida.getNome() + DIVISOR + usuarioPartida.getAposta() + DIVISOR;
				if (usuarioPartida.getAposta() == 0d) {
					parar = false;
				}
			}
			nomes = nomes.substring(0, nomes.length() - 1);
			// todos ja apostaram
			if (parar) {
				for (Usuario usuarioPartida : usuarios) {
					GerenciadorClientes gerenciadorClientes = listUsuarioGerenciador.get(usuarioPartida.getNome());
					gerenciadorClientes.pararThreadAposta();
					mensagem.setProtocolo("INI");

				}
			}
			for (Usuario usuarioPartida : usuarios) {
				GerenciadorClientes gerenciadorClientes = listUsuarioGerenciador.get(usuarioPartida.getNome());
				mensagem.setMensagem(nomes);
				if (usuarioPartida.getAposta() != 0d)
					gerenciadorClientes.enviaDados(mensagem);
			}
			if (parar)
				darCartasInciais(usuario, listUsuarioGerenciador);
		} catch (PartidaException e) {
			e.printStackTrace();

		}
	}

	/**
	 * Metodo Responsavel por distribuir as duas cartar iniciais para cada Jogador
	 * 
	 * @param listUsuarioGerenciador
	 */
	public void darCartasInciais(Usuario usuario, Map<String, GerenciadorClientes> listUsuarioGerenciador) {

		try {

			// inicia partida
			String partida = usuario.getPartidaAtual();
			List<Usuario> usuarios = partidaService.getUsuariosNaPartida(partida);
			Map<String, Partida> partidas = partidaService.listarPartidas();
			if (usuarios.size() > NUMEROMAXIMOJOGADORPORBARALHO)
				partidas.get(partida).setNumeroBaralhos(2);
			else
				partidas.get(partida).setNumeroBaralhos(1);

			partidaService.inicioPartida(partida);

			// dar duas cartas a todos os usuarios

			for (Usuario usuarioPartida : usuarios) {
				for (int x = 0; x < 2; x++) {
					Mensagem mensagem = new Mensagem();
					mensagem.setProtocolo("CAR");
					GerenciadorClientes gerenciadorClientes = listUsuarioGerenciador.get(usuarioPartida.getNome());
					Carta carta = partidaService.getUmaCarta(usuarioPartida);
					mensagem.setMensagem(carta.getNumero() + DIVISOR + carta.getNaipe());
					gerenciadorClientes.enviaDados(mensagem);
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		} catch (PartidaException e) {
			e.printStackTrace();

		}

	}

	/**
	 * Comprar uma carta do Baralho
	 * 
	 * @param usuario
	 * @param listUsuarioGerenciador
	 * @return Mensagem
	 */
	public Mensagem comprarCarta(Usuario usuario, Map<String, GerenciadorClientes> listUsuarioGerenciador) {
		Mensagem mensagem = new Mensagem();
		mensagem.setProtocolo("CAR");
		Carta carta = partidaService.getUmaCarta(usuario);
		mensagem.setMensagem(carta.getNumero() + DIVISOR + carta.getNaipe());
		return mensagem;
	}

	/**
	 * Parar de comprar cartas
	 * 
	 * @param usuario
	 * @return Mensagem
	 */
	public Mensagem parar(Usuario usuario) {
		usuario.setParar(true);
		Mensagem mensagem = new Mensagem();
		mensagem.setProtocolo("SUC");
		return mensagem;
	}

	/**
	 * Verificar Vencedor na partida
	 * 
	 * @param usuario
	 * @param listUsuarioGerenciador
	 */
	public void verificaVencedor(Usuario usuario, Map<String, GerenciadorClientes> listUsuarioGerenciador) {
		try {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// get dados partida
			String partida = usuario.getPartidaAtual();
			List<Usuario> usuarios = partidaService.getUsuariosNaPartida(partida);
			Map<String, Partida> partidas = partidaService.listarPartidas();

			////// verifica se partida(jogada) acabou
			boolean jogoAcabou = true;
			int totalMaior = 0;
			for (Usuario usuarioPartida : usuarios) {
				if (usuarioPartida.getEstourou() || usuarioPartida.getParar()) {
					System.out.println(usuarioPartida.getNome() + " parou de jogar ou estourou");
				} else
					jogoAcabou = false;
				if (usuarioPartida.getParar())
					totalMaior = usuarioPartida.getTotal() > totalMaior ? usuarioPartida.getTotal() : totalMaior;

			}

			////// verifica quem ganhou

			if (jogoAcabou) {

				// Verifica Empate
				int qtdUsuariosEmpataram = 0;
				for (Usuario usuarioPartida : usuarios) {

					if (usuarioPartida.getTotal() == totalMaior)
						qtdUsuariosEmpataram++;

				}
				Partida pp = partidas.get(partida);
				if (qtdUsuariosEmpataram > 1)
					pp.getJogada().setTotal(pp.getJogada().getTotal() / qtdUsuariosEmpataram);

				for (Usuario usuarioPartida : usuarios) {
					Mensagem mensagem = new Mensagem();
					if (usuarioPartida.getEstourou()) {
						mensagem.setProtocolo("EOW");
						// todos Perderam?
						if (totalMaior == 0) {
							usuarioPartida.setSaldo(usuarioPartida.getSaldo() + usuarioPartida.getAposta());
							mensagem.setMensagem(usuarioPartida.getSaldo().toString());
						}
						if (usuarioPartida.getSaldo() <= 0d)
							this.inserirCreditosUsuario(usuarioPartida);
					} else if (totalMaior == usuarioPartida.getTotal()) {
						mensagem.setProtocolo("WIN");
						usuarioPartida.setSaldo(usuarioPartida.getSaldo() + pp.getJogada().getTotal());
						mensagem.setMensagem(usuarioPartida.getSaldo().toString());

					} else {
						mensagem.setProtocolo("EOW");
						if (totalMaior == 0) {
							usuarioPartida.setSaldo(usuarioPartida.getSaldo() + usuarioPartida.getAposta());
							mensagem.setMensagem(usuarioPartida.getSaldo().toString());					
						}
						if (usuarioPartida.getSaldo() <= 0d)
							this.inserirCreditosUsuario(usuarioPartida);
					}
					GerenciadorClientes gerenciadorClientes = listUsuarioGerenciador.get(usuarioPartida.getNome());
					gerenciadorClientes.enviaDados(mensagem);
				}
			}
			if (jogoAcabou)
				reiniciarPartida(usuarios, partida);

		} catch (PartidaException e) {
			e.printStackTrace();

		}

	}

	/**
	 * Metodo para iniciar uma nova jogada na partida ja ativa
	 * 
	 * @param usuarios
	 * @param partidaAtual
	 */
	public void reiniciarPartida(List<Usuario> usuarios, String partidaAtual) {
		Partida pp = partidaService.listarPartidas().get(partidaAtual);
		for (Usuario usuarioPartida : usuarios) {
			usuarioPartida.setAposta(0d);
			usuarioPartida.getCartasMao().clear();
			usuarioPartida.setEstourou(false);
			usuarioPartida.setParar(false);
			pp.getJogada().setTotal(0d);
			partidaService.inicioPartida(partidaAtual);

		}
	}

	/**
	 * Remove o usuario da Partida
	 * 
	 * @param usuario
	 */
	public void removeUsuarioPartida(Usuario usuario) {
		try {

			// get dados partida
			String nomePartida = usuario.getPartidaAtual();
			List<Usuario> usuarios = partidaService.getUsuariosNaPartida(nomePartida);
			Map<String, Partida> partidas = partidaService.listarPartidas();
			Partida partida = partidas.get(nomePartida);
			partida.getListUsuarios().remove(usuario);

			// Envia mensagem aos outros usuarios informando que o usuario saiu.

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	/**
	 * Inseri os creditos quando o usuario chega a 0.
	 * 
	 * @param usuario
	 */
	private void inserirCreditosUsuario(Usuario usuario) {
		new Thread() {
			@Override
			public void run() {
				try {
					System.out.println("Inicio do contador");
					Thread.sleep(TEMPO_GANHAR_MAIS_CREDITO);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				System.out.println("Inserindo novo credito de 200 para o cliente: "
						+ usuario.getNome());
				usuario.setSaldo(200d);
			}
		}.start();
	}

}
