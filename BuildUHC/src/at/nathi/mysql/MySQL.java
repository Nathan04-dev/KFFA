package at.nathi.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class MySQL {
	
	public static String host;
	public static String port;
	public static String database;
	public static String username;
	public static String password;
	public static Connection con;
	
	public static void connect() {
		if(!isConnected()) {
			try {
				con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, username, password);
				System.out.println("[MySQL] Verbindung aufgebaut");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	public static void disconnect() {
		if(isConnected()) {
			try {
				con.close();
				System.out.println("[MySQL] Verbindung geschlossen");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static boolean isConnected() {
		//wenn con null ist wird false zurückgegeben wenn es nicht null ist dann true
		return (con == null ? false : true);
	}
	
	public static void update(String qry) {
		try {
		PreparedStatement ps = con.prepareStatement(qry);
		ps.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static ResultSet getResult(String qry) {
		try {
			PreparedStatement ps = con.prepareStatement(qry);
			return ps.executeQuery();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
		
		
	}
}
