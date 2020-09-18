package homeWork0908;


import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

public class DuridConn {
	static DataSource dataS;
	static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();
	
	static {
		Properties pro=new Properties();
		InputStream in= DuridConn.class.getResourceAsStream("druid.properties");
		try {
			pro.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			dataS=DruidDataSourceFactory.createDataSource(pro);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection getConnection() throws SQLException {
		Connection conn=threadLocal.get();
		if (conn==null) {
			conn=dataS.getConnection();
			threadLocal.set(conn);
		}
		return conn;
	}
	public static void closeAll() {
		
	}
}
