package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Candidato;
import model.CandidatoxPesquisa;
import util.ConnectionUtil;

public class CandidatoxPesquisaDao {

	private static CandidatoxPesquisaDao instance;
	private List<CandidatoxPesquisa> listaCandidatoxPesquisa = new ArrayList<>();
	private Connection con = ConnectionUtil.getConnection();
	public static CandidatoxPesquisaDao getInstance() {
		if(instance == null) {
			instance = new CandidatoxPesquisaDao();
			
		}
		return instance;
	}
	
	public void salvar(CandidatoxPesquisa candidatoxpesquisa) {
		try {
			String sql= " insert into candidatoxpesquisa (id, candidato, pesquisa, votos) values (?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, candidatoxpesquisa.getId());
			pstmt.setString (2, candidatoxpesquisa.getCandidato());
			pstmt.setFloat(3,candidatoxpesquisa.getPesquisa());
			pstmt.setInt(4,candidatoxpesquisa.getVotos());
			pstmt.execute(); 
					
		
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void atualizar(CandidatoxPesquisa candidatoxpesquisa) {
		
		
		try {
			String sql= " update candidatoxpesquisa  set id=? ,candidato=? ,pesquisa=? ,votos=? ,where id=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setFloat(1, candidatoxpesquisa.getCandidato());
			pstmt.setFloat (2, candidatoxpesquisa.getPesquisa());
			pstmt.setInt(3,candidatoxpesquisa.getVotos());
			pstmt.setInt(4,candidatoxpesquisa.getId());
			pstmt.executeUpdate();   
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public void excluir(int idCandidatoxPesquisa) {
		
		try {
			String sql= " delete from candidatoxpesquisa where id=? ";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, idCandidatoxPesquisa);
			pstmt.executeUpdate();   
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	public List<CandidatoxPesquisa> listar(){
		
		List<CandidatoxPesquisa>  listaCandidatoxPesquisas = new ArrayList<>();
		try {		
			String sql = " select * from candidatoxpesquisa"; 
			java.sql.Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				CandidatoxPesquisa c= new CandidatoxPesquisa();
		      	c.setId (rs.getInt("id"));		
		      	c.setVotos(rs.getInt("votos"));
				c.setPesquisa(rs.getString("pesquisa"));
				c.setCandidato(rs.getNString("candidato"));
				listaCandidatoxPesquisas.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	
		return listaCandidatoxPesquisas;
		
	}
}


