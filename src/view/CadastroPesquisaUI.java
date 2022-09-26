package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import controller.CandidatoController;
import controller.PesquisaController;
import model.Candidato;
import model.Pesquisa;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroPesquisaUI extends JInternalFrame {
	private JTextField txtInstituto;
	private JTextField txtDataPesquisa;
	private JTextField txtUF;
	private JTextField txtTipoPesquisa;
	private JTextField txtFormato;
	private JTextField txtTipo;
	private JTextField txtMediaIdade;
	private Pesquisa pesquisa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroPesquisaUI frame = new CadastroPesquisaUI();
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
	public CadastroPesquisaUI() {
		
		
		setClosable(true);
		setTitle("Cadastro de Pesquisa");
		setBounds(100, 100, 899, 431);
		
		JPanel jpCadastroPesquisa = new JPanel();
		jpCadastroPesquisa.setBorder(new TitledBorder(null, "Pesquisa", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
			
		});
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					if (pesquisa != null&& pesquisa.getId() > 0) {
						pesquisa.setInstituto(txtInstituto.getText());
						pesquisa.setDataPesquisa(txtDataPesquisa.getText());
						pesquisa.setUf(txtUF.getText());
						pesquisa.setTipoPesquisa(txtTipoPesquisa.getText());
						pesquisa.setFormato(txtFormato.getText());
						pesquisa.setTipo(txtFormato.getText());
						pesquisa.setFormato(txtFormato.getText());
						pesquisa.setMediaIdade(Double.parseDouble(txtMediaIdade.getText()));
						new PesquisaController().atualizar(pesquisa);
						JOptionPane.showMessageDialog(null, "Produto atualizado com sucesso");

						
				}else {
				
					Pesquisa pesquisa = new Pesquisa();
					pesquisa.setInstituto(txtInstituto.getText());
					pesquisa.setDataPesquisa(txtDataPesquisa.getText());
					pesquisa.setUf(txtUF.getText());
					pesquisa.setTipoPesquisa(txtTipoPesquisa.getText());
					pesquisa.setFormato(txtFormato.getText());
					pesquisa.setTipo(txtFormato.getText());
					pesquisa.setFormato(txtFormato.getText());
					pesquisa.setMediaIdade(Double.parseDouble(txtMediaIdade.getText()));

			
					new PesquisaController().salvar(pesquisa);
					JOptionPane.showMessageDialog(null, "Produto salvo com sucesso");
					
				}
					dispose();
					
					}catch (Exception ex){
						JOptionPane.showMessageDialog(null, "Erro ao salvar produto");
					}
			
				
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnSalvar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnCancelar))
						.addComponent(jpCadastroPesquisa, GroupLayout.PREFERRED_SIZE, 849, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(32, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(jpCadastroPesquisa, GroupLayout.PREFERRED_SIZE, 348, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancelar)
						.addComponent(btnSalvar))
					.addContainerGap(36, Short.MAX_VALUE))
		);
		
		JLabel jlInstituto = new JLabel("Institudo de Pesquisa:");
		
		txtInstituto = new JTextField();
		txtInstituto.setColumns(10);
		
		JLabel jlDataPesquisa = new JLabel("Data da Pesquisa:");
		
		txtDataPesquisa = new JTextField();
		txtDataPesquisa.setColumns(10);
		
		JLabel jlUF = new JLabel("UF:");
		
		txtUF = new JTextField();
		txtUF.setColumns(10);
		
		JLabel jlTipoPesquisa = new JLabel("Tipo de Pesquisa:");
		
		txtTipoPesquisa = new JTextField();
		txtTipoPesquisa.setColumns(10);
		
		JLabel jlFormato = new JLabel("Formato:");
		
		txtFormato = new JTextField();
		txtFormato.setColumns(10);
		
		JLabel jlTipo = new JLabel("Tipo:");
		
		txtTipo = new JTextField();
		txtTipo.setColumns(10);
		
		JLabel jlMediaIdade = new JLabel("Média de Idade:");
		
		txtMediaIdade = new JTextField();
		txtMediaIdade.setColumns(10);
		GroupLayout gl_jpCadastroPesquisa = new GroupLayout(jpCadastroPesquisa);
		gl_jpCadastroPesquisa.setHorizontalGroup(
			gl_jpCadastroPesquisa.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpCadastroPesquisa.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_jpCadastroPesquisa.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_jpCadastroPesquisa.createSequentialGroup()
							.addComponent(jlMediaIdade)
							.addGap(18)
							.addComponent(txtMediaIdade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_jpCadastroPesquisa.createSequentialGroup()
							.addGroup(gl_jpCadastroPesquisa.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_jpCadastroPesquisa.createSequentialGroup()
									.addComponent(jlTipoPesquisa, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(txtTipoPesquisa, GroupLayout.PREFERRED_SIZE, 424, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_jpCadastroPesquisa.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_jpCadastroPesquisa.createSequentialGroup()
										.addComponent(jlInstituto, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(txtInstituto, GroupLayout.PREFERRED_SIZE, 591, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_jpCadastroPesquisa.createSequentialGroup()
										.addComponent(jlUF, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(txtUF, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_jpCadastroPesquisa.createSequentialGroup()
										.addComponent(jlDataPesquisa)
										.addGap(18)
										.addComponent(txtDataPesquisa, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_jpCadastroPesquisa.createParallelGroup(Alignment.TRAILING)
									.addGroup(Alignment.LEADING, gl_jpCadastroPesquisa.createSequentialGroup()
										.addComponent(jlTipo, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(txtTipo))
									.addGroup(Alignment.LEADING, gl_jpCadastroPesquisa.createSequentialGroup()
										.addComponent(jlFormato, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(txtFormato, GroupLayout.PREFERRED_SIZE, 333, GroupLayout.PREFERRED_SIZE))))
							.addContainerGap(107, Short.MAX_VALUE))))
		);
		gl_jpCadastroPesquisa.setVerticalGroup(
			gl_jpCadastroPesquisa.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpCadastroPesquisa.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_jpCadastroPesquisa.createParallelGroup(Alignment.BASELINE)
						.addComponent(jlInstituto)
						.addComponent(txtInstituto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_jpCadastroPesquisa.createParallelGroup(Alignment.BASELINE)
						.addComponent(jlDataPesquisa)
						.addComponent(txtDataPesquisa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_jpCadastroPesquisa.createParallelGroup(Alignment.BASELINE)
						.addComponent(jlUF)
						.addComponent(txtUF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_jpCadastroPesquisa.createParallelGroup(Alignment.BASELINE)
						.addComponent(jlTipoPesquisa)
						.addComponent(txtTipoPesquisa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_jpCadastroPesquisa.createParallelGroup(Alignment.BASELINE)
						.addComponent(jlFormato)
						.addComponent(txtFormato, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(24)
					.addGroup(gl_jpCadastroPesquisa.createParallelGroup(Alignment.BASELINE)
						.addComponent(jlTipo)
						.addComponent(txtTipo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_jpCadastroPesquisa.createParallelGroup(Alignment.BASELINE)
						.addComponent(jlMediaIdade)
						.addComponent(txtMediaIdade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(77, Short.MAX_VALUE))
		);
		jpCadastroPesquisa.setLayout(gl_jpCadastroPesquisa);
		getContentPane().setLayout(groupLayout);

	}

	public void setPesquisaEdicao(Pesquisa pesquisa) {
		this.pesquisa = pesquisa;
		preencherFormulario();

		
	}
	private void preencherFormulario() {
		if(pesquisa != null) {
			txtInstituto.setText(pesquisa.getInstituto());
			//txtDataPesquisa.setText(pesquisa.getDataPesquisa());
			txtUF.setText(pesquisa.getUf());
			txtTipoPesquisa.setText(pesquisa.getTipoPesquisa());
			txtFormato.setText(pesquisa.getFormato());
			txtTipo.setText(pesquisa.getTipo());
			//txtMediaIdade.setText(pesquisa.getMediaIdade());
			
			
		}
	}
	

}
