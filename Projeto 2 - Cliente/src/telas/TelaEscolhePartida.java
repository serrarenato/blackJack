/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

import bd.dbos.Usuario;
import entity.Mensagem;
import transmissor.ClienteSocket;
import transmissor.Solicitacao;

import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;

/**
 *
 * @author melin
 */
public class TelaEscolhePartida extends javax.swing.JPanel {

	// ATRIBUTOS DE JANELA CADASTRO
	private JFrame escolherPartida; // ou 'fecha'
	private String partidaSelecionada;

	// CONSTRUTOR
	public TelaEscolhePartida(JFrame escolherPartida) {
		this.escolherPartida = escolherPartida;
		initComponents();
	}

	/**
	 * Creates new form TelaEscolhePartida
	 */
	public TelaEscolhePartida() {
		bntListarPartida.setName("");
		bntListarPartida.setLabel("Listar Partidas");
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

		lblPartidasEmAndamento = new javax.swing.JLabel();
		lblSala = new javax.swing.JLabel();
		lblStatus = new javax.swing.JLabel();
		ListaSalas = new java.awt.List();
		btnEntrarPartida = new java.awt.Button();
		btnEntrarPartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnEntrarPartida(e);
			}
		});
		btnCriarPartida = new java.awt.Button();
		btnCriarPartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCriarPartida(e);
			}
		});
		bntListarPartida = new Button();
		bntListarPartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnListarPartidas(e);
			}
		});
		bntListarPartida.setLabel("Listar Partidas");

		lblPartidasEmAndamento.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
		lblPartidasEmAndamento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblPartidasEmAndamento.setText("Partidas em Andamento");

		lblSala.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		lblSala.setText("Sala");

		lblStatus.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
		lblStatus.setText("Status");

		btnEntrarPartida.setLabel("Entrar em Partida");
		btnEntrarPartida.setName(""); // NOI18N

		btnCriarPartida.setLabel("Criar Partida");

		txtPartida = new JTextField();
		txtPartida.setName("txtPartida");

		JLabel lblNomePartida = new JLabel("Nome Partida:");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.TRAILING).addGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup()
						.addGap(93)
						.addComponent(btnEntrarPartida, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(btnCriarPartida, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
						.addComponent(bntListarPartida, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, layout.createSequentialGroup().addGap(22)
								.addComponent(lblSala, GroupLayout.PREFERRED_SIZE, 347, GroupLayout.PREFERRED_SIZE)
								.addGap(18).addComponent(lblStatus, GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING,
								layout.createSequentialGroup().addContainerGap()
										.addGroup(layout.createParallelGroup(Alignment.LEADING)
												.addComponent(ListaSalas, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(lblPartidasEmAndamento, GroupLayout.DEFAULT_SIZE, 691,
														Short.MAX_VALUE))))
				.addContainerGap())
				.addGroup(layout.createSequentialGroup().addContainerGap(165, Short.MAX_VALUE)
						.addComponent(lblNomePartida).addGap(35)
						.addComponent(txtPartida, GroupLayout.PREFERRED_SIZE, 334, GroupLayout.PREFERRED_SIZE)
						.addGap(111)));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup()
				.addContainerGap()
				.addComponent(lblPartidasEmAndamento, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(lblSala).addComponent(lblStatus))
				.addGap(19).addComponent(ListaSalas, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(bntListarPartida, 0, 0, Short.MAX_VALUE)
						.addComponent(btnCriarPartida, 0, 0, Short.MAX_VALUE)
						.addComponent(btnEntrarPartida, GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE))
				.addGap(27)
				.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtPartida, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNomePartida))
				.addContainerGap(32, Short.MAX_VALUE)));
		this.setLayout(layout);

		lblPartidasEmAndamento.getAccessibleContext().setAccessibleName("lblPartidasemAndamento");
		lblSala.getAccessibleContext().setAccessibleName("lblSala");
		lblStatus.getAccessibleContext().setAccessibleName("lblStatusPartida");
		ListaSalas.getAccessibleContext().setAccessibleName("");
		btnEntrarPartida.getAccessibleContext().setAccessibleName("btnEntPartida");
		btnEntrarPartida.getAccessibleContext().setAccessibleDescription("");
		btnCriarPartida.getAccessibleContext().setAccessibleName("btnCriarPartida");

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
			java.util.logging.Logger.getLogger(TelaEscolhePartida.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(TelaEscolhePartida.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(TelaEscolhePartida.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(TelaEscolhePartida.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new TelaEscolhePartida().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private java.awt.List ListaSalas;
	private java.awt.Button btnCriarPartida;
	private java.awt.Button btnEntrarPartida;
	private javax.swing.JLabel lblPartidasEmAndamento;
	private javax.swing.JLabel lblSala;
	private javax.swing.JLabel lblStatus;
	private java.awt.Button bntListarPartida;
	private JTextField txtPartida;

	private void btnListarPartidas(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnOKActionPerformed
		// TODO add your handling code here:

		try {

			// verifica se o campo senha eh igual ao campo de confirmacao
			ClienteSocket clienteSocket = ClienteSocket.getClienteSocket();
			Mensagem mensagem = new Mensagem("LST", "");
			clienteSocket.enviaDados(mensagem);

			Mensagem retorno = clienteSocket.getInput();

			System.out.println(retorno);
			String[] retornos = retorno.getMensagem().split(":");
			ListaSalas.clear();
			if (!retorno.getProtocolo().equals("EOF")) {
				for (String string : retornos) {
					if (string.equals("PAR") || string.equals("EOF"))
						continue;
					ListaSalas.add(string);
					System.out.println(string);
				}

			} else {
				JOptionPane.showMessageDialog(null, "Não há partidas");
			}

		} catch (Exception erro) {
			System.err.println(erro);
		}
	}

	private void btnCriarPartida(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnOKActionPerformed
		// TODO add your handling code here:

		try {

			// verifica se o campo senha eh igual ao campo de confirmacao
			if (txtPartida.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Digite um nome para partida");
				return;
			}

			ClienteSocket clienteSocket = ClienteSocket.getClienteSocket();
			Mensagem mensagem = new Mensagem("CRI", txtPartida.getText());
			clienteSocket.enviaDados(mensagem);

			Mensagem retorno = clienteSocket.getInput();

			System.out.println(retorno);
			if (retorno.getProtocolo().equals("SUC")) {
				JOptionPane.showMessageDialog(null, "Partidas Criada");
			} else {
				JOptionPane.showMessageDialog(null, "Erro ao criar partida");
			}

		} catch (Exception erro) {
			System.err.println(erro);
		}
	}

	private void btnEntrarPartida(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnOKActionPerformed
		// TODO add your handling code here:

		try {

			// verifica se o campo senha eh igual ao campo de confirmacao
			try {
				if (ListaSalas.getSelectedItem().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Selecione uma partida");
					return;
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Selecione uma partida");
				return;
			}

			ClienteSocket clienteSocket = ClienteSocket.getClienteSocket();
			String[] nome = ListaSalas.getSelectedItem().split(" ");
			Mensagem mensagem = new Mensagem("ENT", nome[0]);
			clienteSocket.enviaDados(mensagem);

			Mensagem retorno = clienteSocket.getInput();

			System.out.println(retorno);
			if (retorno.getProtocolo().equals("SUC")) {
				/*
				 * JFrame janelaPrePartida = new JFrame("TelaPrePartida"); TelaPrePartida
				 * escolherPartida = new TelaPrePartida(janelaPrePartida);
				 * 
				 * janelaPrePartida.add(escolherPartida); janelaPrePartida.pack();
				 * janelaPrePartida.setLocationRelativeTo(escolherPartida);
				 * janelaPrePartida.setVisible(true); this.escolherPartida.dispose();
				 */
				JFrame newFrame = new TelaPrePartida(retorno.getMensagem());
				newFrame.setVisible(true);

				this.escolherPartida.dispose(); // Fechando a view antiga (janela de Login)

			} else {
				JOptionPane.showMessageDialog(null, "Erro nao foi possivel entrar na partida");
			}

		} catch (Exception erro) {
			System.err.println(erro);
		}
	}
}
