package view.tables;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Candidato;
import model.CandidatoxPesquisa;

public class CandidatoxPesquisaTableModel extends AbstractTableModel {
	
	private static final long serialVersionUID = 1;
	private static final int COL_VOTOS = 0; 
	private static final int COL_CANDIDATO = 1;
	private static final int COL_PESQUISA = 2;
	
	
	private List<CandidatoxPesquisa> valores;
	
	public CandidatoxPesquisaTableModel(List<CandidatoxPesquisa> valores) {
		this.valores = new ArrayList<CandidatoxPesquisa>(valores);
	}
	
	public int getRowCount() {
		return valores.size();
	}
	
	public int getColumnCount() {
		return 3;
	}
	
	public String getCoumnName(int column) {
		
		if (column == COL_VOTOS) return "Votos";
		if (column == COL_CANDIDATO) return "Candidato";
		if (column == COL_PESQUISA) return "Pesquisa";
		return"";
	}
	
	public Object getValueAt(int row, int column) {
		CandidatoxPesquisa candidatoxPesquisa = valores.get(row);
		
		if (column == COL_VOTOS)
			return candidatoxPesquisa.getVotos();
		else
			if (column == COL_CANDIDATO)
				return candidatoxPesquisa.getCandidato();
			else
				if (column == COL_PESQUISA)
					return candidatoxPesquisa.getPesquisa();
		return"";
		
		
	}
	
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		CandidatoxPesquisa candidatoxPesquisa = valores.get(rowIndex);
		
		if (columnIndex == COL_VOTOS)
			candidatoxPesquisa.setVotos(Integer.parseInt(aValue.toString()));
		else
			if (columnIndex == COL_CANDIDATO)
				candidatoxPesquisa.setCandidato(aValue.toString());
			else
				if (columnIndex == COL_PESQUISA)
					candidatoxPesquisa.setPesquisa(aValue.toString());
				
		
	}
	
	public Class<?> getColumnClass(int columnIndex) {
		 	return String.class;
	}
	
	public boolean isCellEditable (int rowIndex, int columnIndex) {
		return true;
	}
	
	public CandidatoxPesquisa get(int row) {
		return valores.get(row);
	}
	
	

}



