package model;

public class Candidato {

	private int id;
	private String nome;
	private String fichaLimpa;
	private String partido;
	
	public Candidato(String nome, String fichaLimpa, String partido) {
		this.nome = nome;
		this.fichaLimpa = fichaLimpa;
		this.partido = partido;
	}
	
	public Candidato() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getFichaLimpa() {
		return fichaLimpa;
	}
	public void setFichaLimpa(String fichaLimpa) {
		this.fichaLimpa = fichaLimpa;
	}
	public String getPartido() {
		return partido;
	}
	public void setPartido(String partido) {
		this.partido = partido;
	}
	
	public String toString() {
		return "Nome do Candidato: " + nome + " - Partido: " + partido + " - Ficha Limpa: " + fichaLimpa;
		
}
}	
