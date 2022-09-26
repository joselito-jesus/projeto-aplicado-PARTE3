package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PrincipalUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalUI frame = new PrincipalUI();
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
	public PrincipalUI() {
		setTitle("Projeto Eleições");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(500, 500, 1028, 539);
		
		JMenuBar jbPrincipal = new JMenuBar();
		setJMenuBar(jbPrincipal);
		
		JMenu jmCadastro = new JMenu("Cadastro");
		jbPrincipal.add(jmCadastro);
		
		JMenuItem jmCandidato = new JMenuItem("Candidato");
		jmCandidato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroCandidatoUI cadCandidato = new CadastroCandidatoUI();
				cadCandidato.setVisible(true);
				contentPane.add(cadCandidato, 0);
			}
		});
		jmCadastro.add(jmCandidato);
		
		JMenuItem jmPesquisa = new JMenuItem("Pesquisa");
		jmPesquisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroPesquisaUI cadastroPesqUI = new CadastroPesquisaUI();
				cadastroPesqUI.setVisible(true);
				contentPane.add(cadastroPesqUI, 0);
													
			}
		});
		jmCadastro.add(jmPesquisa);
		
		JMenu jmConsultas = new JMenu("Consultas");
		jbPrincipal.add(jmConsultas);
		
		JMenuItem jmConsultaCandidato = new JMenuItem("Candidato");
		jmConsultaCandidato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultaCandidatoUI consultaCandUI = new ConsultaCandidatoUI();
				consultaCandUI.setVisible(true);
				contentPane.add(consultaCandUI, 0);			
												
				
			}
		});
		jmConsultas.add(jmConsultaCandidato);
		
		JMenuItem jmConsultaPesquisa = new JMenuItem("Pesquisa");
		jmConsultaPesquisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultaPesquisaUI consultaPesqUI = new ConsultaPesquisaUI();
				consultaPesqUI.setVisible(true);
				contentPane.add(consultaPesqUI, 0);
				
				
				
				
			}
		});
		jmConsultas.add(jmConsultaPesquisa);
		
		JMenu jmResultado = new JMenu("Resultado");
		jbPrincipal.add(jmResultado);
		
		JMenuItem jmCandidatoXPesquisa = new JMenuItem("Candidato x Pesquisa");
		jmCandidatoXPesquisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResultadoCandidatoxPesquisaUI resultadoCandXPesqUI = new ResultadoCandidatoxPesquisaUI();
				resultadoCandXPesqUI.setVisible(true);
				contentPane.add(resultadoCandXPesqUI, 0);
				
				
				
				
			}
		});
		jmResultado.add(jmCandidatoXPesquisa);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 1004, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 492, Short.MAX_VALUE)
		);
		contentPane.setLayout(gl_contentPane);
	}

}
