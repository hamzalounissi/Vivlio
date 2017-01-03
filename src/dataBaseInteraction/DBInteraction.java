/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataBaseInteraction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author lounissi
 */
public class DBInteraction {
    static String url="jdbc:mysql://localhost:3306/bibliotheque";
	static Connection conn;
	static Statement st;
	static PreparedStatement pst;
	public static void connect()
	{
		//chargement du pilot
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//etablir la connection
			 conn = DriverManager.getConnection(url,"root","");
			 //preparation d instruction
			  st = conn.createStatement();
			
		} catch (ClassNotFoundException | SQLException e) {
		}
	}
	
	public static void disconnect()
	{
		try {
			conn.close();
		} catch (SQLException e) {
		}
	}
	public static int Maj(String sql)
	{
		int nb = 0;
		try {
			 nb=st.executeUpdate(sql);
		} catch (SQLException e) {
		}
		return nb;
	}
	public static ResultSet select(String sql)
	{
		ResultSet rs = null;
		try {
			 rs = st.executeQuery(sql);
		} catch (SQLException e) {
		}
		return rs;
	}
        public static Connection getConnection() {
		return conn;
	}
}
