package homeWork0908;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

//现在是十一点半


public class Test {
	public  static void main(String[] args) throws Exception {
		Location loc=new Location(349, "广州");
		DuridDao dao=new DuridDao();
	//	dao.insert(loc);
	//	dao.upDate(loc, 341);
	//	dao.delete("州");
		List<Integer> list=new ArrayList<Integer>();
		list.add(320);
		list.add(321);
		list.add(322);
		for (Location lc:dao.select(list)) {
			System.out.println(lc.getName()+"   "+lc.getId());
		}
	}
}
