package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import controller.CandidatoController;
import controller.CandidatoxPesquisaController;
import controller.PesquisaController;
import model.Candidato;
import model.CandidatoxPesquisa;
import model.Pesquisa;
import view.tables.CandidatoxPesquisaTableModel;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class ResultadoCandidatoxPesquisaUI extends JInternalFrame {
	private JTextField txtVotos;
	private JTable jtCandidatoxPesquisa;

	
	JComboBox<Pesquisa> cbPesquisa = new JComboBox<Pesquisa>();
	JComboBox<Candidato> cbCandidato = new JComboBox<Candidato> ();

	List<CandidatoxPesquisa> candidatoxPesquisaVotos = new ArrayList<CandidatoxPesquisa>();
	
	
	  

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResultadoCandidatoxPesquisaUI frame = new ResultadoCandidatoxPesquisaUI();
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
	public ResultadoCandidatoxPesquisaUI() {
		setClosable(true);
		setTitle("Resultado Candidato X Pesquisa");
		setBounds(100, 100, 907, 466);
		
		DefaultComboBoxModel<Candidato> modelCandidato = new DefaultComboBoxModel<Candidato>();
		for(Candidato candidato : new CandidatoController().listar()) {
			modelCandidato.addElement(candidato);
		}
		cbCandidato.setModel(modelCandidato);
		
		DefaultComboBoxModel<Pesquisa> modelPesquisa = new DefaultComboBoxModel<Pesquisa>();
		for(Pesquisa pesquisa : new PesquisaController().listar()) {
			modelPesquisa.addElement(pesquisa);
		}
		cbPesquisa.setModel(modelPesquisa);

		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Candidato candidato = (Candidato) cbCandidato.getSelectedItem();
				try {
					CandidatoxPesquisa candidatoxPesquisa = new CandidatoxPesquisa();
					candidatoxPesquisa.setCandidato(candidato);
					//candidatoxPesquisa.setPesquisa(pesquisa); não entendi porque apresenta erro
					//candidatoxPesquisa.setVotos(votos);
					
					new CandidatoxPesquisaController().registrarVotos(candidatoxPesquisa);
					JOptionPane.showMessageDialog(null, "Votos registrados com sucesso.");
					dispose();
				}catch (ParseException e1){
					JOptionPane.showMessageDialog(null, "Erro ao registrar votos.");

			}
			}
		});
		
		JLabel lblCandidato = new JLabel("Candidato");
		
		JLabel lblPesquisa = new JLabel("Pesquisa");
		
		JLabel lblVotos = new JLabel("Votos");
		
		txtVotos = new JTextField();
		txtVotos.setColumns(10);
		
		JComboBox cbCandidato = new JComboBox();
		
		JComboBox cbPesquisa = new JComboBox();
		
		jtCandidatoxPesquisa = new JTable();
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Candidato candidato = (Candidato) cbCandidato.getSelectedItem();
				int votos = Integer.parseInt(txtVotos.getText());
				CandidatoxPesquisa candidatoxPesquisa = new CandidatoxPesquisa();
				candidatoxPesquisa.setCandidato(candidato);
				candidatoxPesquisa.setVotos(votos);
				candidatoxPesquisa.calcularValorTotal();
				candidatoxPesquisa.add(candidatoxPesquisa);
				jtCandidatoxPesquisa.setModel(new CandidatoxPesquisaTableModel(candidatoxPesquisaVotos)); 
				
			}
			
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addComponent(jtCandidatoxPesquisa, GroupLayout.DEFAULT_SIZE, 857, Short.MAX_VALUE))
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblPesquisa, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(cbPesquisa, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblCandidato, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(cbCandidato, GroupLayout.PREFERRED_SIZE, 303, GroupLayout.PREFERRED_SIZE)))
								.addContainerGap(517, Short.MAX_VALUE))
							.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
								.addComponent(lblVotos, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(txtVotos, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 426, Short.MAX_VALUE)
								.addComponent(btnAdicionar)
								.addGap(20)))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(btnSalvar)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnCancelar)
							.addGap(20))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGap(29)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCandidato)
								.addComponent(cbCandidato, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(26)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPesquisa)
								.addComponent(cbPesquisa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(txtVotos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblVotos)))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnAdicionar)))
					.addGap(27)
					.addComponent(jtCandidatoxPesquisa, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSalvar)
						.addComponent(btnCancelar))
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);

	}
}
