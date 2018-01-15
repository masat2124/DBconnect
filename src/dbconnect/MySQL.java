package dbconnect;

import java.sql.*;

public class MySQL {	
	String driver;
	
	String server, dbname, url, user, password;
	Connection con;
	Statement stmt;
	ResultSet rs;

	public MySQL() {
		super();
		this.driver = "org.gjt.mm.mysql.Driver";
		this.server = "ms000.sist.ac.jp";
		this.dbname = "java2017";
		this.url = "jdbc:mysql://" + server + "/"
				+ dbname + "?useUnicode=true&characterEncoding=UTF-8";
		this.user = "java2017";
		this.password = "java2017";
		
		try {
			this.con = DriverManager.getConnection(this.url, this.user, this.password);
			this.stmt = con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void close() {
		try {
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ResultSet selectAll() {
		String sql = "SELECT * FROM `50516024`";
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
}