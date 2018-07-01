package test;

import java.sql.Connection;

import model.data.ConnDB;

public class Teste {

	public static void main(String[] args) {
		
		Teste.testConnection();

	}


	public static void testConnection() {
		
		Connection conn = ConnDB.getConnection();
		
		if(conn != null) {
			System.out.println("Conexão ok!");
		}
		
		
	}


}
