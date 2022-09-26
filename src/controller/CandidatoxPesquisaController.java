package controller;

import java.util.List;

import dao.CandidatoxPesquisaDao;
import model.CandidatoxPesquisa;


public class CandidatoxPesquisaController {

	public void salvar(CandidatoxPesquisa candidatoxpesquisa) throws Exception {
		if (candidatoxpesquisa.getVotos() == 0) {
			throw new Exception("N�o h� votos");
		}
		CandidatoxPesquisaDao.getInstance().salvar(candidatoxpesquisa);
		
	}
	public void atualizar(CandidatoxPesquisa candidatoxpesquisa) throws Exception {
		if (candidatoxpesquisa.getVotos() == 0) {
			throw new Exception("N�o h� votos");
		}
		CandidatoxPesquisaDao.getInstance().atualizar(candidatoxpesquisa);
	}
	
	public void excluir(int idCandidatoPesquisa) throws Exception{
		if (idCandidatoPesquisa == 0) {
			throw new Exception("Pesquisa inv�lida");
		}
		CandidatoxPesquisaDao.getInstance().excluir(idCandidatoPesquisa);
	}
	
	public List<CandidatoxPesquisa> listar(){
		return CandidatoxPesquisaDao.getInstance().listar();
		
	}
	public void registrarVotos(CandidatoxPesquisa candidatoxPesquisa) {
		// TODO Auto-generated method stub
		
	}
}
