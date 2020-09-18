package homeWork0908;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.mysql.cj.api.mysqla.result.Resultset;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DuridDao {
	public void insert(Location loc) throws SQLException {
		Connection con=DuridConn.getConnection();
		String sql="insert into location(locationid,locationname) values("+loc.getId()+",'"+loc.getName()+"')";
	//	System.out.println(sql);
		Statement st= con.createStatement();
		
		st.execute(sql);
		st.close();
		con.close();
	}
	
	public void upDate(Location loc,int id) throws SQLException {
		Connection con=DuridConn.getConnection();
		String sql="update location set locationid=?,locationname=? where locationid=?";
		PreparedStatement st=con.prepareStatement(sql);
		
		st.setInt(1, id);
		st.setString(2, loc.getName());
		st.setInt(3,loc.getId());
		try {
			st.execute();
		} catch (Exception e) {
			System.out.println("主K重复");
		}finally {
			st.close();
			con.close();
		}
		
		
	}
	public void delete(String name) throws SQLException {
		Connection con=DuridConn.getConnection();
		String sql="delete from location where locationname like \'%"+name+"%\'";
		Statement st=con.createStatement();
		System.out.println(sql);
		
		st.execute(sql);
		
		st.close();
		con.close();
	}
	public List<Location> select(List<Integer> list) throws SQLException{
		Connection con=DuridConn.getConnection();
		String sql="select locationid,locationname from location where locationid in(";
		for(Integer it:list) {
			sql=sql+it+",";
		}
		sql=sql.substring(0, sql.length()-1)+")";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		List<Location> newlList=new ArrayList<Location>();
		Location loc=null;
		while(rs.next()) {
			loc=new Location(rs.getInt(1), rs.getString(2));
			newlList.add(loc);
		}
		return newlList;
	}
}
