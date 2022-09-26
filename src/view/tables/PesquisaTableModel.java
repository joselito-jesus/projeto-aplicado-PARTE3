package view.tables;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Candidato;
import model.Pesquisa;

public class PesquisaTableModel extends AbstractTableModel {
	
	private static final long serialVersionUID = 1;
	private static final int COL_INSTITUTO = 0; 
	private static final int COL_DATAPESQUISA = 1;
	private static final int COL_UF = 2;
	private static final int COL_TIPOPESQUISA = 3;
	private static final int COL_FORMATO = 4;
	private static final int COL_TIPO = 5;
	private static final int COL_MEDIAIDADE = 6;

	
	
	private List<Pesquisa> valores;
	
	public PesquisaTableModel(List<Pesquisa> valores) {
		this.valores = new ArrayList<Pesquisa>(valores);
	}
	
	public int getRowCount() {
		return valores.size();
	}
	
	public int getColumnCount() {
		return 7;
	}
	
	public String getCoumnName(int column) {
		
		if (column == COL_INSTITUTO) return "Instituto";
		if (column == COL_DATAPESQUISA) return "Data Pesquisa";
		if (column == COL_UF) return "UF";
		if (column == COL_TIPOPESQUISA) return "Tipo Pesquisa";
		if (column == COL_FORMATO) return "Formato";
		if (column == COL_TIPO) return "Tipo";
		if (column == COL_MEDIAIDADE) return "Idade média";
		return"";

	}
	
	public Object getValueAt(int row, int column) {
		Pesquisa pesquisa = valores.get(row);
		
		if (column == COL_INSTITUTO)
			return pesquisa.getInstituto();
		else
			if (column == COL_DATAPESQUISA)
				return pesquisa.getDataPesquisa();
			else
				if (column == COL_UF)
					return pesquisa.getUf();
				else
					if (column == COL_TIPOPESQUISA)
						return pesquisa.getTipoPesquisa();
					else
						if (column == COL_FORMATO)
							return pesquisa.getFormato();
						else
							if (column == COL_TIPO)
								return pesquisa.getTipo();
							else
								if (column == COL_MEDIAIDADE)
									return pesquisa.getMediaIdade();
				return"";
				
	}
	
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		Pesquisa pesquisa = valores.get(rowIndex);
		
		if (columnIndex == COL_INSTITUTO)
			pesquisa.setInstituto(aValue.toString());
		else
			if (columnIndex == COL_DATAPESQUISA)
				pesquisa.setDataPesquisa(aValue.toString());
			else
				if (columnIndex == COL_UF)
					pesquisa.setUf(aValue.toString());
				else
					if (columnIndex == COL_TIPOPESQUISA)
						pesquisa.setTipoPesquisa(aValue.toString());
					else
						if (columnIndex == COL_FORMATO)
							pesquisa.setFormato(aValue.toString());
						else
							if (columnIndex == COL_TIPO)
								pesquisa.setTipo(aValue.toString());
							else
								if (columnIndex == COL_MEDIAIDADE)
									pesquisa.setMediaIdade(Double.parseDouble (aValue.toString()));
		
		}
	
	public Class<?> getColumnClass(int columnIndex) {
	 	return String.class;
}
	
	public boolean isCellEditable (int rowIndex, int columnIndex) {
		return true;
	}
	
	public Pesquisa get(int row) {
		return valores.get(row);
	}
	
	
		
		
	
	
	

}
