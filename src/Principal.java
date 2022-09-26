
import controller.CandidatoController;
import controller.PesquisaController;
import controller.CandidatoxPesquisaController;
import model.Pesquisa;
import model.Candidato;
import model.CandidatoxPesquisa;

public class Principal {

       public static void main(String[] args) {
	

		Pesquisa p1 = new Pesquisa();
		
		p1.setId(1);
		p1.setInstituto("Datafolha");
		p1.setUf("SC");
		p1.setMediaIdade(25);
		p1.setTipoPesquisa("Pesquisa feita por telefone.");
		
		
		Pesquisa p2 = new Pesquisa();
		
		p2.setId(2);
		p2.setInstituto("Ipec");
		p2.setUf("RJ");
		p2.setMediaIdade(42);
		p2.setTipoPesquisa("Pesquisa feita pessoalmente.");
		
		Pesquisa p3 = new Pesquisa();
		
		p3.setId(3);
		p3.setInstituto("Quaest");
		p3.setUf("SP");
		p3.setMediaIdade(60);
		p3.setTipoPesquisa("Pesquisa feita pessoalmente.");
		
		PesquisaController controller = new PesquisaController();
		
		try {
			
		controller.salvar(p1);
		controller.salvar(p2);
		controller.salvar(p3);
	} 
		catch (Exception e) {
			
		System.out.println(e.getMessage());
	}
		
	for (Pesquisa p : controller.listar()) {
		System.out.println(p.toString());
	}
	
	
//------------------Candidato------------------------
	
	
		Candidato c1 = new Candidato();
		
		c1.setId(1);
		c1.setNome("Jair Messias Bolsonaro");
		c1.setPartido("PL");
		c1.setFichaLimpa("Sim");
		
		Candidato c2 = new Candidato();
		
		c2.setId(1);
		c2.setNome("Luis Inacio Lula da Silva");
		c2.setPartido("PT");
		c2.setFichaLimpa("N�o");
		
		Candidato c3 = new Candidato();
		
		c3.setId(1);
		c3.setNome("Ciro Gomes");
		c3.setPartido("PDT");
		c3.setFichaLimpa("N�o");
		
		CandidatoController controller1 = new CandidatoController();
		

		try {
			
		controller1.salvar(c1);
		controller1.salvar(c2);
		controller1.salvar(c3);
	} 
		catch (Exception e) {
			
		System.out.println(e.getMessage());
		}
			
	for (Candidato c : controller1.listar()) {
			System.out.println(c.toString());
		}

//////------------------CandidatoxPesquisa------------------------
		
		
		CandidatoxPesquisa cp1 = new CandidatoxPesquisa();
		
		cp1.setId(1);
		cp1.setVotos(33370739);
		
	
		CandidatoxPesquisa cp2 = new CandidatoxPesquisa();
		
		cp2.setId(2);
		cp2.setVotos(3370739);
		
	
		CandidatoxPesquisa cp3 = new CandidatoxPesquisa();
		
		cp3.setId(2);
		cp3.setVotos(370739);
		
		CandidatoController controller3 = new CandidatoController();
		

		try {
			
		controller3.salvar(cp1);
		controller3.salvar(cp2);
		controller3.salvar(cp3);
	} 
		catch (Exception e) {
			
		System.out.println(e.getMessage());
		}

// Era para colocar CandidatoxPesquisa a baixo, mas n�o est� aceitando e quando vou ver diz que tem que colocar conforme est�  baixo. N�o conseguimos idenditicar o erro.
//Mas se tirar essa parte do CndidatoxPesquisa o restante est� tuso funcionando
		
	for (Candidato d : controller3.listar()) {
		System.out.println(d.toString());
		}
}
}
