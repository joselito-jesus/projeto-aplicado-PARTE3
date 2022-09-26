package controller;

import java.util.List;

import dao.PesquisaDao;
import model.Pesquisa;

public class PesquisaController {

	public void salvar(Pesquisa pesquisa) throws Exception {
		
		if (pesquisa.getUf() == null || pesquisa.getUf().length() > 2) {
			throw new Exception("UF está incorreto, favor verificar");
		}
		if (pesquisa.getTipoPesquisa() == null || pesquisa.getTipoPesquisa().trim().equals("")) {
			throw new Exception("Descçãoo do tipo de pesquisa está inválido");	
		}
		if (pesquisa.getInstituto() == null) {
			throw new Exception("Instituto inválido");
		}
		PesquisaDao.getInstance().salvar(pesquisa);
	
	}
	public void atualizar(Pesquisa pesquisa) throws Exception {
		if (pesquisa.getUf() == null || pesquisa.getUf().length() > 2) {
			throw new Exception("UF está incorreto, favor verificar");
		}
		if (pesquisa.getTipoPesquisa() == null || pesquisa.getTipoPesquisa().trim().equals("")) {
			throw new Exception("Descrição do tipo de pesquisa está inválido");
		}
		if (pesquisa.getInstituto() == null) {
			throw new Exception("Instituto inválido");
		}
		PesquisaDao.getInstance().atualizar(pesquisa);
	}
	
	public void excluir(int idPesquisa) throws Exception{
		if (idPesquisa == 0) {
			throw new Exception("Nenhuma pesquisa selecionada");
		}
		PesquisaDao.getInstance().excluir(idPesquisa);
	}
	
	public List<Pesquisa> listar(){
		return PesquisaDao.getInstance().listar();
		
	}
}
