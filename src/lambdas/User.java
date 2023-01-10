package lambdas;

public class User {
	
	private String name;
	
	private String job; 
	

	public User() {
	}
	
	public User(String name) {
		this.name = name; 
	}
	
	public User(String name, String job) {
		this.name = name; 
		this.job = job; 
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	} 
	
	public String getTitle() {
		return job;
	}

	public void setTitle(String job) {
		this.job = job;
	}

}
