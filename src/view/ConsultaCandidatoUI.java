package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import controller.CandidatoController;
import model.Candidato;
import view.tables.CandidatoTableModel;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultaCandidatoUI extends JInternalFrame {
	private JTable jtCandidato;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaCandidatoUI frame = new ConsultaCandidatoUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ConsultaCandidatoUI() {
		setClosable(true);
		setResizable(true);
		setTitle("Consulta de Candidato");
		setBounds(100, 100, 866, 456);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
				
			}
		});
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Candidato candidato = new CandidatoTableModel(new CandidatoController().listar()).get(jtCandidato.getSelectedRow());
				try{
					new CandidatoController().excluir(candidato.getId());
					jtCandidato.setModel(new CandidatoTableModel(new CandidatoController().listar()));
				}catch (Exception e1){
					JOptionPane.showMessageDialog(null, "Erro ao excluir candidato. ");
				}
				
			}
		});
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Candidato candidato = new CandidatoTableModel(new CandidatoController().listar()).get(jtCandidato.getSelectedRow());
				CadastroCandidatoUI cadCandidatoUI = new CadastroCandidatoUI();
				cadCandidatoUI.setCandidatoEdicao(candidato);
				cadCandidatoUI.setVisible(true);
				getParent().add(cadCandidatoUI, 0);
				
				
				
				
				
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//jtCandidato.setModel(new CandidatoTableModel(new CandidatoController().listar()).get(jtCandidato.getSelectedRow()));
				//mensagem de erro em setModel.

				
				
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(538, Short.MAX_VALUE)
					.addComponent(btnAtualizar)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnEditar)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnExcluir)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnCancelar)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 823, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(23, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 282, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancelar)
						.addComponent(btnExcluir)
						.addComponent(btnEditar)
						.addComponent(btnAtualizar))
					.addContainerGap())
		);
		
		jtCandidato = new JTable();
		jtCandidato.setModel(new CandidatoTableModel(new CandidatoController().listar()));
		scrollPane.setViewportView(jtCandidato);
		getContentPane().setLayout(groupLayout);

	}
}
