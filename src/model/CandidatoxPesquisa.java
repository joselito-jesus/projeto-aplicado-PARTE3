package model;

public class CandidatoxPesquisa {

	private int id;
	private int votos;
	private Candidato candidato;
	private Pesquisa pesquisa;
	
	
	public CandidatoxPesquisa(int votos, Candidato candidato, Pesquisa pesquisa) {
		this.votos = votos;
		this.candidato = candidato;
		this.pesquisa = pesquisa;
	}
	
	public CandidatoxPesquisa() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	

	
	public int getVotos() {
		return votos;
	}

	public void setVotos(int votos) {
		this.votos = votos;
	}

	public Candidato getCandidato() {
		return candidato;
	}
	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}
	public Pesquisa getPesquisa() {
		return pesquisa;
	}
	public void setPesquisa(Pesquisa pesquisa) {
		this.pesquisa = pesquisa;
	}
	
	public String toString() {
		return "Votos: " + votos;
	}

	public void setCandidato(String string) {
		
	}

	public void setPesquisa(String string) {
		
	}

	public void calcularValorTotal() {
		// fazer o calculo
		
	}

	
}
