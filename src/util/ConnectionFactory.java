package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public Connection getConnection() {
		try {
			
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			return DriverManager.getConnection(
					// drivermanager é a classe (letra maiuscula)
					// getconnection (metodo de conexão da classe drivermanager)
					"jdbc:sqlserver://localhost:1433;" +
					// jdb é o conector, no caso sqlserver
					// localhost é que o servidor está na máquina
					// 1433 porta
							"databaseName=Portalzinho_v3;" +
							// nome do banco
							"user = usuario; password = 123456;");
			// usuario e senha

		} catch (SQLException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}
