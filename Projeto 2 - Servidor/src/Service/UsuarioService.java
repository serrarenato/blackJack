package Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bd.dbos.Usuario;
import entity.Carta;
import entity.Mensagem;
import entity.Partida;
import exception.PartidaException;

public class UsuarioService {

	private static final int NUMEROMAXIMOJOGADORPORBARALHO = 4;
	PartidaService partidaService;
	private final String DIVISOR = ":";
	private static Map<String, PartidaService> listaPartidas = new HashMap<>();

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

	public Mensagem entrarPartida(Usuario usuario, String partida) {
		String resposta;
		try {

			Map<String, Partida> partidas = PartidaService.listarPartidas();

			if (partidas.get(partida).getStatus() != "jogando") {
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

		} catch (PartidaException e) {
			e.printStackTrace();

		}
	}

	public Mensagem setAposta(Usuario usuario, String mensagem) {
		Double aposta = new Double(mensagem);
		if (usuario.getSaldo() >= aposta) {
			partidaService.setApostaNaPartida(usuario.getPartidaAtual(), usuario.getNome(), aposta);
			usuario.setSaldo(usuario.getSaldo() - aposta);
			return new Mensagem("SUC", usuario.getSaldo().toString());
		} else
			return new Mensagem("ERR", "Saldo Insuficiente");

	}

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

	public Mensagem comprarCarta(Usuario usuario,  Map<String, GerenciadorClientes> listUsuarioGerenciador) {
		Mensagem mensagem = new Mensagem();
		mensagem.setProtocolo("CAR");
		Carta carta = partidaService.getUmaCarta(usuario);
		verificaVencedor(usuario, listUsuarioGerenciador);
		mensagem.setMensagem(carta.getNumero() + DIVISOR + carta.getNaipe());
		
		return mensagem;
	}

	public Mensagem parar(Usuario usuario) {
		usuario.setParar(true);
		Mensagem mensagem = new Mensagem();
		mensagem.setProtocolo("SUC");
		return mensagem;
	}

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
				for (Usuario usuarioPartida : usuarios) {
					Mensagem mensagem = new Mensagem();
					if (usuarioPartida.getEstourou())
						mensagem.setProtocolo("EOW");
					else if (totalMaior == usuarioPartida.getTotal()) {
						mensagem.setProtocolo("WIN");
						Partida pp = partidas.get(partida);
						usuarioPartida.setSaldo(usuarioPartida.getSaldo() + pp.getJogada().getTotal());
						mensagem.setMensagem(usuarioPartida.getSaldo().toString());
						
					} else {
						mensagem.setProtocolo("EOW");
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
	public void reiniciarPartida(List<Usuario> usuarios, String partidaAtual ) {
		for (Usuario usuarioPartida : usuarios) {
			
			usuarioPartida.getCartasMao().clear();
			usuarioPartida.setEstourou(false);
			usuarioPartida.setParar(false);
			partidaService.inicioPartida(partidaAtual);
			
		}
	}

}
