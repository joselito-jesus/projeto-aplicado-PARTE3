package controller;

import java.util.List;

import dao.CandidatoDao;
import model.Candidato;
import model.CandidatoxPesquisa;

public class CandidatoController {

	public void salvar(Candidato candidato) throws Exception {
		if(candidato.getNome() == null || candidato.getNome().length() < 3) {
			throw new Exception("Candidato inválido");
		}
		CandidatoDao.getInstance().salvar(candidato);

	}
	public void atualizar(Candidato candidato) throws Exception {
		if(candidato.getNome() == null || candidato.getNome().length() < 3) {
			throw new Exception("Candidato inválido");
		}
		CandidatoDao.getInstance().atualizar(candidato);
	}
	public void excluir(int idCandidato) throws Exception {
		if (idCandidato == 0) {
			throw new Exception("Nenhum candidato selecionado");
		}
		CandidatoDao.getInstance().excluir(idCandidato);
	}
	public List<Candidato> listar(){
		return CandidatoDao.getInstance().listar();
		
	}
	public void salvar(CandidatoxPesquisa cp1) {
		// TODO Auto-generated method stub
		
	}
	
}

