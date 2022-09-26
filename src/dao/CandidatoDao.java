package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;
import java.sql.ResultSet;
import model.Candidato;
import util.ConnectionUtil;

public class CandidatoDao {
	
	private static CandidatoDao instance;
	private List<Candidato> listaCandidato = new ArrayList<>();
	private Connection con = ConnectionUtil.getConnection();
	
	public static CandidatoDao getInstance() {

 		
		if(instance == null) {
			instance = new CandidatoDao();
			
		}
		return instance;
	}

	public void salvar(Candidato candidato) {
		try {
			String sql= " insert into candidato (nome,fichalimpa, id, partido) values (?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, candidato.getNome());
			pstmt.setString (2, candidato.getFichaLimpa());
			pstmt.setString(3,candidato.getPartido());
			pstmt.setString(4,candidato.getPartido());
			pstmt.execute(); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void atualizar(Candidato candidato) {
		try {
			String sql= " update candidato set fichalimpa=? ,nome=? ,partido=? ,where id=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, candidato.getNome());
			pstmt.setString (2, candidato.getFichaLimpa());
			pstmt.setString(3,candidato.getPartido());
			pstmt.setString(4,candidato.getPartido());
			pstmt.setInt(5, candidato.getId());
			pstmt.executeUpdate();   
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public void excluir(int idCandidato) {
		try {
			String sql= " delete from candidato where id=? ";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, idCandidato);
			pstmt.executeUpdate();   
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public List<Candidato> listar(){
		List<Candidato>  listaCandidato = new ArrayList<>();
		try {		
			String sql = " select * from candidato"; 
			java.sql.Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Candidato c= new Candidato();
		      	c.setId (rs.getInt("id"));		
		      	c.setFichaLimpa(rs.getString("fichalimpa"));
				c.setNome(rs.getString("nome"));
				c.setPartido(rs.getNString("partido"));
				listaCandidato.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	
		return listaCandidato;
		
	}
}
