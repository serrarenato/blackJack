/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import entity.Mensagem;
import entity.Numero;
import transmissor.ClienteSocket;

/**
 * Tela de Partida, principal do jogo.
 *
 * @author melin
 */
public class TelaPartida extends javax.swing.JFrame {

	/**
	 * Creates new form TelaPrePartida
	 * 
	 * @param nomes
	 * @param money
	 */
	Thread thread;
	List<Numero> numerosCartas = new ArrayList<>();
	boolean continuar = true;

	public TelaPartida(Double money, String[] nomes) {
		initComponents();
		lblQtdMoedas.setText(money.toString());
		int x = 0;
		for (String string : nomes) {
			lblListJogador[x].setText(nomes[x]);
			x++;
		}
		listCartas.add("Faça sua aposta.");
	}

	public TelaPartida() {
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {
		btnParar = new javax.swing.JButton();
		btnComprarCarta = new javax.swing.JButton();
		lblListJogador[3] = new javax.swing.JLabel();
		lblApostaJogador[7] = new javax.swing.JLabel();
		lblListJogador[4] = new javax.swing.JLabel();
		lblApostaJogador[1] = new javax.swing.JLabel();
		lblListJogador[5] = new javax.swing.JLabel();
		lblJogador = new javax.swing.JLabel();
		lblListJogador[6] = new javax.swing.JLabel();
		jLabel18 = new javax.swing.JLabel();
		lblListJogador[7] = new javax.swing.JLabel();
		lblListJogador[7].setName("");
		lblApostaJogador[0] = new javax.swing.JLabel();
		lblApostaJogador[2] = new javax.swing.JLabel();
		lblListJogador[0] = new javax.swing.JLabel();
		lblListJogador[0] = new javax.swing.JLabel();
		lblApostaJogador[3] = new javax.swing.JLabel();
		lblApostaJogador[4] = new javax.swing.JLabel();
		lblListJogador[1] = new javax.swing.JLabel();
		lblApostaJogador[5] = new javax.swing.JLabel();
		lblListJogador[2] = new javax.swing.JLabel();
		lblApostaJogador[6] = new javax.swing.JLabel();
		lblCartasNoBaralho = new javax.swing.JLabel();
		btnSair = new javax.swing.JButton();
		lblMoedas = new javax.swing.JLabel();
		txtValorApostar = new javax.swing.JTextField();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		btnParar.setText("Parar");

		btnComprarCarta.setText("Comprar Carta!");

		lblListJogador[3].setText("Vazio");

		lblApostaJogador[7].setText("000");

		lblListJogador[4].setText("Vazio");

		lblApostaJogador[1].setText("000");

		lblListJogador[5].setText("Vazio");

		lblJogador.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
		lblJogador.setText("Jogador");

		lblListJogador[6].setText("Vazio");

		jLabel18.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
		jLabel18.setText("Aposta");

		lblListJogador[7].setText("Vazio");

		lblApostaJogador[0].setText("000");

		lblApostaJogador[2].setText("000");

		lblListJogador[0].setText("Vazio");

		lblApostaJogador[3].setText("000");

		lblApostaJogador[4].setText("000");

		lblListJogador[1].setText("Vazio");
		lblListJogador[0].setText("Vazio");

		lblApostaJogador[5].setText("000");

		lblListJogador[2].setText("Vazio");

		lblApostaJogador[6].setText("000");

		lblCartasNoBaralho.setText("Cartas no Baralho");

		btnSair.setText("Sair");

		lblMoedas.setText("Suas Moedas:");

		txtValorApostar.setText("0");

		btnApostar = new JButton();
		btnApostar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aposta();
			}

		});
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sair();
			}

		});
		btnParar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parar();
			}

		});
		btnComprarCarta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				comprarCarta();
				
			}
		});
		
		btnApostar.setText("Apostar");

		lblQtdMoedas = new JLabel("teste");

		JLabel lblQtdCartasBaralho = new JLabel("Cartas");

		lbTotalCartas = new JLabel("cartas");

		lblSomatorioDasCartas = new JLabel("Somatorio das Cartas");

		listCartas = new java.awt.List();

		lblCartas = new JLabel("Cartas");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup()
				.addContainerGap()
				.addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(lblCartasNoBaralho).addGroup(layout
						.createSequentialGroup()
						.addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup()
								.addGroup(layout.createParallelGroup(Alignment.LEADING)
										.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
												.addComponent(lblListJogador[1], GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(lblListJogador[0], GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(lblListJogador[2], GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(lblListJogador[3], GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(lblListJogador[4], GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(lblListJogador[5], GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(lblListJogador[6], GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(lblListJogador[7], GroupLayout.PREFERRED_SIZE, 75,
														GroupLayout.PREFERRED_SIZE))
										.addComponent(lblJogador))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout
										.createParallelGroup(Alignment.LEADING, false)
										.addComponent(lblApostaJogador[1], GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblApostaJogador[0], GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblApostaJogador[2], GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblApostaJogador[3], GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblApostaJogador[4], GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblApostaJogador[5], GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblApostaJogador[6], GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblApostaJogador[7], GroupLayout.PREFERRED_SIZE, 75,
												GroupLayout.PREFERRED_SIZE))
										.addComponent(jLabel18)))
								.addComponent(btnSair))
						.addGap(23)
						.addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup()
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(layout.createParallelGroup(Alignment.LEADING)
										.addGroup(layout.createSequentialGroup().addGap(83).addGroup(layout
												.createParallelGroup(Alignment.TRAILING)
												.addGroup(layout.createSequentialGroup().addGap(51)
														.addComponent(btnComprarCarta, GroupLayout.PREFERRED_SIZE, 193,
																GroupLayout.PREFERRED_SIZE)
														.addGap(18)
														.addComponent(btnParar, GroupLayout.PREFERRED_SIZE, 124,
																GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addGroup(layout.createParallelGroup(Alignment.LEADING)
																.addGroup(layout.createSequentialGroup().addGap(61)
																		.addComponent(lblSomatorioDasCartas))
																.addGroup(layout.createSequentialGroup().addGap(119)
																		.addComponent(lbTotalCartas)))
														.addContainerGap(218, Short.MAX_VALUE))
												.addGroup(layout.createSequentialGroup().addGap(200)
														.addComponent(listCartas, GroupLayout.PREFERRED_SIZE, 222,
																GroupLayout.PREFERRED_SIZE)
														.addGroup(layout.createParallelGroup(Alignment.LEADING)
																.addGroup(layout.createSequentialGroup().addGap(133)
																		.addComponent(lblMoedas))
																.addGroup(layout.createSequentialGroup().addGap(166)
																		.addComponent(lblQtdMoedas)))
														.addGap(164))))
										.addGroup(layout.createSequentialGroup().addGap(229)
												.addComponent(btnApostar, GroupLayout.PREFERRED_SIZE, 121,
														GroupLayout.PREFERRED_SIZE)
												.addGap(65)
												.addComponent(txtValorApostar, GroupLayout.PREFERRED_SIZE, 66,
														GroupLayout.PREFERRED_SIZE)
												.addGap(271))))
								.addGroup(layout.createSequentialGroup().addGap(365).addComponent(lblCartas)
										.addContainerGap())))))
				.addGroup(layout.createSequentialGroup().addGap(42).addComponent(lblQtdCartasBaralho)
						.addContainerGap(981, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(layout.createSequentialGroup().addGap(23)
						.addGroup(
								layout.createParallelGroup(Alignment.TRAILING)
										.addGroup(layout.createSequentialGroup()
												.addGroup(layout.createParallelGroup(Alignment.BASELINE)
														.addComponent(lblJogador).addComponent(jLabel18))
												.addGap(14))
										.addGroup(layout
												.createSequentialGroup().addComponent(lblCartas)
												.addPreferredGap(ComponentPlacement.UNRELATED)))
						.addGroup(layout.createParallelGroup(Alignment.LEADING)
								.addGroup(layout.createSequentialGroup().addComponent(lblListJogador[0])
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblListJogador[1])
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblListJogador[2])
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblListJogador[3])
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblListJogador[4])
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblListJogador[5])
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblListJogador[6])
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblListJogador[7]))
								.addComponent(listCartas, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
								.addGroup(layout.createSequentialGroup().addGroup(layout
										.createSequentialGroup().addComponent(lblApostaJogador[0])
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblApostaJogador[1])
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblApostaJogador[2])
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblApostaJogador[3])
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblApostaJogador[4])
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblApostaJogador[5])
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblApostaJogador[6]))
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblApostaJogador[7])))
						.addGap(34).addComponent(lblCartasNoBaralho).addGap(18).addComponent(lblQtdCartasBaralho)
						.addGap(28)
						.addGroup(
								layout.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnParar, GroupLayout.PREFERRED_SIZE, 47,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(btnComprarCarta, GroupLayout.PREFERRED_SIZE, 49,
												GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(btnSair)
								.addComponent(btnApostar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(txtValorApostar, GroupLayout.PREFERRED_SIZE, 32,
										GroupLayout.PREFERRED_SIZE))
						.addContainerGap())
				.addGroup(layout.createSequentialGroup().addGap(85).addComponent(lblMoedas).addGap(18)
						.addComponent(lblQtdMoedas, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 206, Short.MAX_VALUE)
						.addComponent(lblSomatorioDasCartas).addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(lbTotalCartas).addGap(67)));
		getContentPane().setLayout(layout);
		btnParar.getAccessibleContext().setAccessibleName("btnPararJogada");
		btnParar.getAccessibleContext().setAccessibleDescription("");
		btnComprarCarta.getAccessibleContext().setAccessibleName("btnComprarCarta");
		lblListJogador[3].getAccessibleContext().setAccessibleName(" lblListJogador[3]");
		lblApostaJogador[7].getAccessibleContext().setAccessibleName("lblApostaJogador[7]");
		lblListJogador[4].getAccessibleContext().setAccessibleName(" lblListJogador[4]");
		lblApostaJogador[1].getAccessibleContext().setAccessibleName("lblApostaJogador[1]");
		lblListJogador[5].getAccessibleContext().setAccessibleName(" lblListJogador[5]");
		lblJogador.getAccessibleContext().setAccessibleName("lblJogadores");
		lblListJogador[6].getAccessibleContext().setAccessibleName(" lblListJogador[6]");
		jLabel18.getAccessibleContext().setAccessibleName("lblAposta");
		lblListJogador[7].getAccessibleContext().setAccessibleName(" lblListJogador[7]");
		lblApostaJogador[0].getAccessibleContext().setAccessibleName("lblApostaJogador[0]");
		lblApostaJogador[2].getAccessibleContext().setAccessibleName("lblApostaJogador[2]");
		lblListJogador[0].getAccessibleContext().setAccessibleName(" lblListJogador[0]");
		lblApostaJogador[3].getAccessibleContext().setAccessibleName("lblApostaJogador[3]");
		lblApostaJogador[4].getAccessibleContext().setAccessibleName("lblApostaJogador[4]");
		lblListJogador[1].getAccessibleContext().setAccessibleName(" lblListJogador[1]");
		lblApostaJogador[5].getAccessibleContext().setAccessibleName("lblApostaJogador[5]");
		lblListJogador[2].getAccessibleContext().setAccessibleName(" lblListJogador[2]");
		lblApostaJogador[6].getAccessibleContext().setAccessibleName("lblApostaJogador[6]");
		lblCartasNoBaralho.getAccessibleContext().setAccessibleName("lblCartasBaralho");
		btnSair.getAccessibleContext().setAccessibleName("btnSairPartida");

		pack();
	}// </editor-fold>//GEN-END:initComponents

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
		// (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the default
		 * look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(TelaPartida.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(TelaPartida.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(TelaPartida.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(TelaPartida.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}
		// </editor-fold>
		// </editor-fold>
		// </editor-fold>
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new TelaPartida().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton btnComprarCarta;
	private javax.swing.JButton btnParar;
	private javax.swing.JButton btnSair;
	private javax.swing.JLabel jLabel18;
	private javax.swing.JLabel lblApostaJogador[] = new JLabel[8];
	private javax.swing.JLabel lblCartasNoBaralho;
	private javax.swing.JLabel lblJogador;
	private javax.swing.JLabel lblQtdMoedas;
	private javax.swing.JLabel lblListJogador[] = new JLabel[8];
	private javax.swing.JLabel lblMoedas;
	private javax.swing.JTextField txtValorApostar;
	private JButton btnApostar;
	private JLabel lblSomatorioDasCartas;
	private java.awt.List listCartas;
	private JLabel lblCartas;
	private JLabel lbTotalCartas; 

	private void reininicar() {
		if (new Double (lblQtdMoedas.getText())>0) {
			btnApostar.setEnabled(true);
			btnComprarCarta.setEnabled(false);
			setMensagemListaELimpa("Faça sua aposta.");
			btnParar.setEnabled(true);			
			numerosCartas = new ArrayList<>();;
			//thread.interrupt();
			continuar = false;
			thread = null;
		}
		
	}
	private void aposta() {
		try {
			btnApostar.setEnabled(false);
			ClienteSocket clienteSocket = ClienteSocket.getClienteSocket();
			if (txtValorApostar.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Valor digitar um valor de aposta valido!");
			}
			Mensagem mensagem = new Mensagem("APO", txtValorApostar.getText());
			clienteSocket.enviaDados(mensagem);

			Mensagem retorno = clienteSocket.getInput();
			System.out.println(retorno);
			if (retorno.getProtocolo().equals("SUC")) {
				setMensagemListaELimpa("Aguarde os outros jogadores apostarem.");
				lblQtdMoedas.setText(retorno.getMensagem());
				continuar=true;
				lerParticipantes(thread);
				btnComprarCarta.setEnabled(true);
			} else {
				JOptionPane.showMessageDialog(null, "Valor invalido da aposta!");
				btnApostar.setEnabled(true);
			}

		} catch (Exception erro) {
			System.err.println(erro);
		}

	}

	private void lerParticipantes(Thread thread) {
		try {

			ClienteSocket clienteSocket = ClienteSocket.getClienteSocket();
			thread = new Thread() {
				@Override
				public void run() {				
					while (continuar) {
						Mensagem retorno = clienteSocket.getInput();
						System.out.println(retorno);
						if (retorno.getProtocolo().equals("APO")) {
							String[] strings = retorno.getMensagem().split(":");
							int y = 0;
							for (int x = 0; x < strings.length; x += 2) {
								lblListJogador[y].setText(strings[x]);
								lblApostaJogador[y].setText(strings[x + 1]);
								y++;
							}

						} else if (retorno.getProtocolo().equals("INI")) {
							// continuar = false;
							String[] strings = retorno.getMensagem().split(":");
							int y = 0;
							for (int x = 0; x < strings.length; x += 2) {
								lblListJogador[y].setText(strings[x]);
								lblApostaJogador[y].setText(strings[x + 1]);
								y++;
							}
							setMensagemListaELimpa("Partida iniciada. Boa Sorte!");
						} else if (retorno.getProtocolo().equals("CAR")) {
							setMensagemLista(retorno.getMensagem());
							String[] string = retorno.getMensagem().split(":");
							retorno=null;
							numerosCartas.add(Numero.valueOf(string[0]));
							exibeSoma();
						} else if (retorno.getProtocolo().equals("EOW")) {
							if (retorno.getMensagem()!=null && !retorno.getMensagem().isEmpty()) {
								lblQtdMoedas.setText(retorno.getMensagem());
								JOptionPane.showMessageDialog(null, "Todos Perderam suas fichas foram devolvidas");
								reininicar();
							}else	
								JOptionPane.showMessageDialog(null, "Voce Perdeu");
							setMensagemLista("Voce Perdeu!");
							reininicar();
						} else if (retorno.getProtocolo().equals("WIN")) {
							JOptionPane.showMessageDialog(null, "Voce Ganhou");
							setMensagemLista("Voce Ganhou!");
							lblQtdMoedas.setText(retorno.getMensagem());
							reininicar();
							
						} else {
							JOptionPane.showMessageDialog(null, "Erro");
						}
						try {
							Thread.sleep(800);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			};
			thread.start();

		} catch (Exception erro) {
			System.err.println(erro);
		}
	}

	private void setMensagemListaELimpa(String mensagem) {
		listCartas.clear();
		listCartas.add(mensagem);
	}

	private void setMensagemLista(String mensagem) {
		listCartas.add(mensagem);
	}

	private void exibeSoma() {
		Integer total = 0;
		boolean temCartaEspecial=false;
		
		for (Numero numero : numerosCartas) {	
			if (numero.equals(Numero.REI)||numero.equals(Numero.DAMA)||numero.equals(Numero.VALETE)) {
				total+=10;
				temCartaEspecial=true;
			} else  if (numero.equals(Numero.AS)) {
				if (temCartaEspecial)
					total+=11;
				else
					total+=1;
			} else {
				
				total+=numero.getValue();				
			}
			
		}
		lbTotalCartas.setText(total.toString());
		if (total>21) {
			btnComprarCarta.setEnabled(false);
			btnParar.setEnabled(false);
			setMensagemLista("Voce Estorou os Pontos Máximos");
		}
	}

	private void comprarCarta() {
		ClienteSocket clienteSocket = ClienteSocket.getClienteSocket();
		Mensagem mensagem = new Mensagem("COM", "");
		clienteSocket.enviaDados(mensagem);
	}
	private void parar() {
		ClienteSocket clienteSocket = ClienteSocket.getClienteSocket();
		Mensagem mensagem = new Mensagem("EOC", "");
		clienteSocket.enviaDados(mensagem);
		btnComprarCarta.setEnabled(false);
		btnParar.setEnabled(false);
	}
	private void sair() {
		ClienteSocket clienteSocket = ClienteSocket.getClienteSocket();
		Mensagem mensagem = new Mensagem("SAI", "");
		clienteSocket.enviaDados(mensagem);
	}
		
}
