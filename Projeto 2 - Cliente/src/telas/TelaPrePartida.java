/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import entity.Mensagem;
import transmissor.ClienteSocket;

/**
 *	Classe com todos os recursos necessários antes de iniciar a Partida
 *
 * @author melin
 */
public class TelaPrePartida extends javax.swing.JFrame {

	private static final int NUMERO_MINIMO_INICIAR_PARTIDA = 2;
	/**
	 * Creates new form TelaPartida
	 */
	private String saldo;
	Thread thread;
	JFrame prePartida;

	public TelaPrePartida(String saldo) {
		this.saldo = saldo;
		initComponents();
		lerParticipantes(thread);
		prePartida = this;
	}

	public TelaPrePartida() {
		initComponents();
		prePartida = this;
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

		jButton3 = new javax.swing.JButton();
		lblStatusjogador[0] = new javax.swing.JLabel();
		lblStatusjogador[1] = new javax.swing.JLabel();
		lblStatusjogador[2] = new javax.swing.JLabel();
		lblJogador[0] = new javax.swing.JLabel();
		lblStatusjogador[3] = new javax.swing.JLabel();
		lblStatusjogador[4] = new javax.swing.JLabel();
		lblJogador[1] = new javax.swing.JLabel();
		lblStatusjogador[5] = new javax.swing.JLabel();
		lblJogador[2] = new javax.swing.JLabel();
		lblStatusjogador[6] = new javax.swing.JLabel();
		lblJogador[3] = new javax.swing.JLabel();
		lblStatusjogador[7] = new javax.swing.JLabel();
		lblJogador[4] = new javax.swing.JLabel();

		lblJogador[5] = new javax.swing.JLabel();
		jLabel17 = new javax.swing.JLabel();
		lblJogador[6] = new javax.swing.JLabel();
		jLabel18 = new javax.swing.JLabel();
		lblJogador[7] = new javax.swing.JLabel();
		lblSaldo = new javax.swing.JLabel();
		lblDinheiro = new javax.swing.JLabel();

		btnIniciarPartida = new javax.swing.JButton();
		btnIniciarPartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iniciaPartida();
			}
		});

		jButton3.setText("jButton1");

		lblDinheiro.setText(this.saldo);

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		lblStatusjogador[0].setText("Offline");

		lblStatusjogador[2].setText("Offline");

		lblJogador[0].setText("Vazio");

		lblStatusjogador[3].setText("Offline");

		lblStatusjogador[4].setText("Offline");

		lblJogador[1].setText("Vazio");

		lblStatusjogador[5].setText("Offline");

		lblJogador[2].setText("Vazio");

		lblStatusjogador[6].setText("Offline");

		lblJogador[3].setText("Vazio");

		lblStatusjogador[7].setText("Offline");

		lblJogador[4].setText("Vazio");

		lblStatusjogador[1].setText("Offline");

		lblJogador[5].setText("Vazio");

		jLabel17.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
		jLabel17.setText("Jogadores");

		lblJogador[6].setText("Vazio");

		jLabel18.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
		jLabel18.setText("Status");

		lblJogador[7].setText("Vazio");

		btnIniciarPartida.setText("Iniciar Partida");
		btnIniciarPartida.setActionCommand("btnIniciaPartida");
		btnIniciarPartida.setName("btnIniciarPartida"); // NOI18N
		btnIniciarPartida.setEnabled(false);

		JLabel lblSaldo = new JLabel();
		lblSaldo.setText("Saldo");

		// JButton btnListarIntegrantes = new JButton();

		// btnListarIntegrantes.setText("Listar Integrantes");
		// btnListarIntegrantes.setName("btnListarIntegrantes");
		// btnListarIntegrantes.setActionCommand("btnIniciaPartida");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup()
				.addGap(120)
				.addGroup(layout.createParallelGroup(Alignment.TRAILING)
						.addGroup(layout.createParallelGroup(Alignment.LEADING)
								.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(lblJogador[1], GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(lblJogador[0], GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(lblJogador[2], GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(lblJogador[3], GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(lblJogador[4], GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(lblJogador[5], GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(lblJogador[6], GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(lblJogador[7], GroupLayout.PREFERRED_SIZE, 75,
												GroupLayout.PREFERRED_SIZE))
								.addComponent(jLabel17))
						.addComponent(btnIniciarPartida, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE))
				.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(layout.createParallelGroup(Alignment.LEADING)
										.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
												.addComponent(lblStatusjogador[1], GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(lblStatusjogador[0], GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(lblStatusjogador[2], GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(lblStatusjogador[3], GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(lblStatusjogador[4], GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(lblStatusjogador[5], GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(lblStatusjogador[6], GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(lblStatusjogador[7], GroupLayout.PREFERRED_SIZE, 75,
														GroupLayout.PREFERRED_SIZE))
										.addComponent(jLabel18))
								.addPreferredGap(ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
								.addGroup(layout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblSaldo, GroupLayout.PREFERRED_SIZE, 75,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblDinheiro, GroupLayout.PREFERRED_SIZE, 75,
												GroupLayout.PREFERRED_SIZE))
								.addGap(75)))));
		// .addGroup(layout
		// .createSequentialGroup().addGap(54).addComponent(btnListarIntegrantes,
		// GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
		// .addContainerGap()))));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup()
				.addContainerGap()
				.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(jLabel17).addComponent(jLabel18))
				.addGap(14)
				.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addComponent(lblJogador[0])
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblJogador[1])
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblJogador[2])
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblJogador[3])
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblJogador[4])
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblJogador[5])
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblJogador[6])
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblJogador[7]))
						.addGroup(layout.createSequentialGroup().addComponent(lblStatusjogador[0])
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblStatusjogador[1])
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblStatusjogador[2])
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(layout.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblStatusjogador[3]).addComponent(lblSaldo))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(layout.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblStatusjogador[4]).addComponent(lblDinheiro))
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblStatusjogador[5])
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblStatusjogador[6])
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblStatusjogador[7])))
				.addGap(36)
				.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(btnIniciarPartida,
						GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE))
				// .addComponent(btnListarIntegrantes, GroupLayout.PREFERRED_SIZE, 66,
				// GroupLayout.PREFERRED_SIZE))
				.addContainerGap(80, Short.MAX_VALUE)));
		getContentPane().setLayout(layout);

		lblStatusjogador[0].getAccessibleContext().setAccessibleName("lblJogador1Status");
		lblStatusjogador[2].getAccessibleContext().setAccessibleName("lblJogador3Status");
		lblJogador[0].getAccessibleContext().setAccessibleName("lblJogador1");
		lblStatusjogador[3].getAccessibleContext().setAccessibleName("lblJogador4Status");
		lblStatusjogador[4].getAccessibleContext().setAccessibleName("lblJogador5Status");
		lblJogador[1].getAccessibleContext().setAccessibleName("lblJogador2");
		lblStatusjogador[5].getAccessibleContext().setAccessibleName("lblJogador6Status");
		lblJogador[2].getAccessibleContext().setAccessibleName("lblJogador3");
		lblStatusjogador[6].getAccessibleContext().setAccessibleName("lblJogador5Status");
		lblJogador[3].getAccessibleContext().setAccessibleName("lblJogador4");
		lblStatusjogador[7].getAccessibleContext().setAccessibleName("lblJogador8Status");
		lblJogador[4].getAccessibleContext().setAccessibleName("lblJogador5");
		lblStatusjogador[1].getAccessibleContext().setAccessibleName("lblJogador2Status");
		lblStatusjogador[1].getAccessibleContext().setAccessibleDescription("");
		lblJogador[5].getAccessibleContext().setAccessibleName("lblJogador6");
		jLabel17.getAccessibleContext().setAccessibleName("lblJogadores");
		lblJogador[6].getAccessibleContext().setAccessibleName("lblJogador7");
		lblJogador[7].getAccessibleContext().setAccessibleName("lblJogador8");
		btnIniciarPartida.getAccessibleContext().setAccessibleName("btnIniciaPArtida");

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
			java.util.logging.Logger.getLogger(TelaPrePartida.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(TelaPrePartida.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(TelaPrePartida.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(TelaPrePartida.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}

		// </editor-fold>
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new TelaPrePartida().setVisible(true);
			}
		});

	}
/**
 * Inicia a partida
 */
	private void iniciaPartida() {

		ClienteSocket clienteSocket = ClienteSocket.getClienteSocket();
		Mensagem mensagem = new Mensagem("INI", " ");
		clienteSocket.enviaDados(mensagem);

	}
/**
 * Abre a tela de Partida 
 * 
 * @param mensagem
 */
	private void telarIniciarPartida(String mensagem) {
		btnIniciarPartida.setEnabled(false);
		//JOptionPane.showMessageDialog(null, "Partida Iniciada");
		String[] strings = mensagem.split(":");
		double money = new Double(strings[0]);
		String[] nomes = new String[strings.length - 1];

		for (int x = 1; x < strings.length; x++) {
			nomes[x - 1] = strings[x];			
		}
		JFrame newFrame = new TelaPartida(money, nomes);
		newFrame.setVisible(true);

		this.prePartida.dispose();
	}
/**
 *
 * Metodo responsavel por ler todas as mensagens recebidas pelo servidor e gerenciar com os protocolos o que deve ser realizado
 * 
 * @param thread
 */

	private void lerParticipantes(Thread thread) {
		try {

			ClienteSocket clienteSocket = ClienteSocket.getClienteSocket();
			Mensagem mensagem = new Mensagem("PAR", " ");
			clienteSocket.enviaDados(mensagem);
			thread = new Thread() {
				@Override
				public void run() {
					boolean continuar = true;
					while (continuar) {
						Mensagem retorno = clienteSocket.getInput();
						System.out.println(retorno);
						if (retorno.getProtocolo().equals("SUC")) {
							String[] strings = retorno.getMensagem().split(":");
							int x = 0;
							if (strings.length >= NUMERO_MINIMO_INICIAR_PARTIDA)
								btnIniciarPartida.setEnabled(true);
							for (String string : strings) {
								lblJogador[x].setText(string);
								lblStatusjogador[x].setText("Online");
								x++;
							}

						} else if (retorno.getProtocolo().equals("INI")) {
							continuar = false;
							telarIniciarPartida(retorno.getMensagem());
						} else {
							JOptionPane.showMessageDialog(null, "Erro nao foi listar jogadores na partida");
						}
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
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

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton btnIniciarPartida;
	private javax.swing.JButton jButton3;
	private javax.swing.JLabel jLabel17;
	private javax.swing.JLabel jLabel18;
	private javax.swing.JLabel lblJogador[] = new javax.swing.JLabel[10];
	private javax.swing.JLabel lblSaldo;
	private javax.swing.JLabel lblDinheiro;
	private javax.swing.JLabel lblStatusjogador[] = new javax.swing.JLabel[10];

}
