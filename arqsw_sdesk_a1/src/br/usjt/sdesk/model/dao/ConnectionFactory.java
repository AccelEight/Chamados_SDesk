package br.usjt.sdesk.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * @author Accel Gustavo Ara�jo Rocha  RA: 81616654	 SI3AN-MCA
 *
 */
public class ConnectionFactory {
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection obterConexao() throws SQLException {
		return DriverManager
				.getConnection("jdbc:mysql://localhost/servicedesk?user=alunos&password=alunos&useSSL=false");
	}

}
