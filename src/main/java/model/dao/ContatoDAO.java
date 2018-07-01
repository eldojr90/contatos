package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.data.ConnDB;
import model.Contato;

public class ContatoDAO {

	public boolean inserirContato(Contato contato) {
		
		Connection conn = ConnDB.getConnection();
		PreparedStatement ps = null;
		
		try {
			
			String sql = "INSERT INTO contato(nome,sobrenome,telefone,nascimento,endereco,email) " + 
						 "VALUES(?,?,?,?,?,?);";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, contato.getNome());
			ps.setString(2, contato.getSobrenome());
			ps.setString(3, contato.getTelefone());
			ps.setDate(4, contato.getNascimento());
			ps.setString(5, contato.getEndereco());
			ps.setString(6, contato.getEmail());
			
			return ps.executeUpdate() == 1;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnDB.closePreparedStatement(ps);
			ConnDB.closeConnection(conn);
		}
		
		return false;
	}
	
	public Contato findById(int id){
		
		Connection conn = ConnDB.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
			String sql = "SELECT * "
					   + "FROM contato "
					   + "WHERE id = ? "
					   + "LIMIT 1;";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			rs.next();
			
			return new Contato(
					rs.getInt("id"), 
					rs.getString("nome"), 
					rs.getString("sobrenome"), 
					rs.getString("telefone"), 
					rs.getDate("nascimento"), 
					rs.getString("endereco"), 
					rs.getString("email"));
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
		}
		
		return null;
	}
	
	public List<Contato> todosContatos(){	
		
		List<Contato> contatos = new ArrayList<>();
		Connection conn = ConnDB.getConnection();
		Statement st = null;
		ResultSet rs = null;
		
		try {
			
			String sql = "SELECT *,floor(datediff(current_date,nascimento)/365.25) idade "
					   + "FROM contato "
					   + "ORDER BY nome;";
			
			st = conn.createStatement();
			
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				contatos.add(new Contato(
							rs.getInt("id"), 
							rs.getString("nome"), 
							rs.getString("sobrenome"), 
							rs.getString("telefone"), 
							rs.getDate("nascimento"),
							rs.getInt("idade"), 
							rs.getString("endereco"), 
							rs.getString("email")));
			}
			
			return contatos;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnDB.closeResultSet(rs);
			ConnDB.closeStatement(st);
			ConnDB.closeConnection(conn);
		}
		
		return contatos;
		
	}
		
	public boolean deletarContato(int id) {
		
		Connection conn = ConnDB.getConnection();
		PreparedStatement ps = null;
		
		try {
			
			String sql = "DELETE FROM contato " + 
						 "WHERE id = ?;";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
						
			return ps.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnDB.closePreparedStatement(ps);
			ConnDB.closeConnection(conn);
		}
		
		return false;
	}
	
}
