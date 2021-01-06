
public class S7_Employee {
	private String name;
	private String title;
	public double salary;
	public S7_Employee(String name,String title) {
		this.name=name;
		this.title=title;
	}
	
	public String getName() {
		return this.name;
		
	}
	
	public void setTitle(String title) {
		this.title=title;
		
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public void setSalary(double amou) {
		this.salary=amou;
	}
	
	public double getSalary() {
		return this.salary;
	}
	
	public void promote() {
		this.title="Senior "+this.title;
		this.salary=2*this.salary;
	}
}
