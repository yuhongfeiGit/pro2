package homeWork0908;

public class Location {
	int id;
	String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Location(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
}
