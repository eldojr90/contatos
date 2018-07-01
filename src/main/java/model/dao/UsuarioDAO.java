package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.data.ConnDB;
import model.Usuario;

public class UsuarioDAO {

	public Usuario findByNameAndPassword(String name, String password) {
		
		Connection conn = ConnDB.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
			String sql = "SELECT * " + 
					"FROM usuario " + 
					"WHERE nome_de_usuario = ? " + 
					"AND senha = upper(md5(?)) " +
					 "LIMIT 1;";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, password);
			
			rs = ps.executeQuery();
			rs.next();
			
			return new Usuario(
						rs.getInt("id"),
						rs.getString("nome"), 
						rs.getString("nome_de_usuario"), 
						rs.getString("senha")
					);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnDB.closeResultSet(rs);
			ConnDB.closePreparedStatement(ps);
			ConnDB.closeConnection(conn);
		}
		
		return null;
	}
	
	public Usuario findById(int id) {
		
		Connection conn = ConnDB.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
			String sql = "SELECT * " + 
					"FROM usuario " + 
					"WHERE id = ? " +
					 "LIMIT 1;";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			rs.next();
			
			return new Usuario(
						rs.getInt("id"),
						rs.getString("nome"), 
						rs.getString("nome_de_usuario"), 
						rs.getString("senha")
					);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnDB.closeResultSet(rs);
			ConnDB.closePreparedStatement(ps);
			ConnDB.closeConnection(conn);
		}
		
		return null;
	}
	
}
