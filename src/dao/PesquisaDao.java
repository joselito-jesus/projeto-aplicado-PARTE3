package dao;


import util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Candidato;
import model.Pesquisa;
import model.Pesquisa;


public class PesquisaDao {
	
	
	
	private static PesquisaDao instance;
	private Connection con = ConnectionUtil.getConnection();
	public static PesquisaDao getInstance() {
		if(instance == null) {
			instance = new PesquisaDao();
			
		}
		return instance;
	}

	public void salvar(Pesquisa pesquisa) {
		try {
			String sql= " insert into pesquisa (datapesquisa, formato,instituto,mediaidade,tipo,uf) values (?,?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setDate(1,pesquisa.getDataPesquisa());
			pstmt.setString(2,pesquisa.getFormato());
			pstmt.setString(3,pesquisa.getInstituto());
	//		pstmt.setString(4,pesquisa.getId());
			pstmt.setFloat(5,pesquisa.getMediaidade());
			pstmt.setString(6,pesquisa.getTipo());
			pstmt.execute(); 	
			}
		catch (SQLException e) {
			e.printStackTrace();
			}}
	
	
	public void atualizar(Pesquisa pesquisa) {
		try {
			String sql= " update pesquisa set datapesquisa=? ,formato=? ,instituto=?, mediaidade=?, tipo=?, uf=? ,where id=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setDate(1, pesquisa.getDataPesquisa());
			pstmt.setString (2, pesquisa.getFormato());
			pstmt.setString(3,pesquisa.getInstituto());
			pstmt.setFloat(4,pesquisa.getMediaidade());
			pstmt.setString(5, pesquisa.getTipo());
			pstmt.executeUpdate();   
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public void excluir(int idPesquisa) {
		try {
			String sql= " delete from pesquisa where id=? ";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, idPesquisa);
			pstmt.executeUpdate();   
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
		
	public List<Pesquisa> listar(){
		List<Pesquisa>  listaPesquisa = new ArrayList<>();
		try {		
			String sql = " select * from pesquisa"; 
			java.sql.Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Pesquisa p= new Pesquisa();
		      	p.setDataPesquisa(rs.getDate("datapesquisa"));		
		      	p.setFormato(rs.getString("formato"));
				p.setInstituto(rs.getString("instituto"));
				p.setMediaidade(rs.getInt("mediaidade"));
				p.setTipo(rs.getString("tipo"));
				listaPesquisa.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	
		return listaPesquisa;
		
	}
		}
