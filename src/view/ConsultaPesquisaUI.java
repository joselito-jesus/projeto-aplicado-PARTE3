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
import controller.PesquisaController;
import model.Candidato;
import model.Pesquisa;
import view.tables.CandidatoTableModel;
import view.tables.PesquisaTableModel;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultaPesquisaUI extends JInternalFrame {
	private JTable jtPesquisa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaPesquisaUI frame = new ConsultaPesquisaUI();
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
	public ConsultaPesquisaUI() {
		setClosable(true);
		setTitle("Consuta de Pesquisa");
		setBounds(100, 100, 926, 472);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
			
		});
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pesquisa pesquisa = new PesquisaTableModel(new PesquisaController().listar()).get(jtPesquisa.getSelectedRow());
				CadastroPesquisaUI cadPesquisaUI = new CadastroPesquisaUI();
				cadPesquisaUI.setPesquisaEdicao(pesquisa);
				cadPesquisaUI.setVisible(true);
				getParent().add(cadPesquisaUI, 0);
				
				
			}
		});
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Pesquisa pesquisa = new PesquisaTableModel(new PesquisaController().listar()).get(jtPesquisa.getSelectedRow());
				try{
					new PesquisaController().excluir(pesquisa.getId());
					jtPesquisa.setModel(new PesquisaTableModel(new PesquisaController().listar()));
				}catch (Exception e1){
					JOptionPane.showMessageDialog(null, "Erro ao excluir pesquisa. ");
				}
							
				
				
				
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PesquisaTableModel(new PesquisaController().listar());
				//jtPesquisa.setModel(new PesquisaTableModel(new PesquisaController().listar()).get(jtPesquisa.getSelectedRow()));
//mensagem de erro em setModel.
				
				
				
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(598, Short.MAX_VALUE)
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
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 894, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(12, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancelar)
						.addComponent(btnExcluir)
						.addComponent(btnEditar)
						.addComponent(btnAtualizar))
					.addContainerGap())
		);
		
		jtPesquisa = new JTable();
		jtPesquisa.setModel(new PesquisaTableModel(new PesquisaController().listar()));
		scrollPane.setViewportView(jtPesquisa);
		getContentPane().setLayout(groupLayout);

	}
}
