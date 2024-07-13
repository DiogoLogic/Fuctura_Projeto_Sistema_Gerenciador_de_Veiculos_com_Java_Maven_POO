package br.com.fuctura.model.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

	private static final String URL = "jdbc:postgresql://localhost:5432/sistema_gerenciador_veiculos";
	private static final String USER = "postgres";
	private static final String PASSWORD = "";
	private static Connection connection;

	private DatabaseConnection() {

	}

	public static Connection getConnection() {
		if (connection == null) {

			synchronized (DatabaseConnection.class) {

				if (connection == null) {
					try {
						connection = DriverManager.getConnection(URL, USER, PASSWORD);
						System.out.println("Iniciando e estabelecendo Conexão..." +
						"............................................................");

					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return connection;
	}

	public static void closeConnection() {
		if (connection != null) {
			try {
				connection.close();
				
				connection = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
