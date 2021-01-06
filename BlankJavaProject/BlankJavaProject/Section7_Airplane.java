
public class Section7_Airplane {
	private boolean airbrone;
	
	public Section7_Airplane() { //飞机构造
		buildFuselage();
		buildWings();
		this.airbrone=false;
	}
	
	public boolean isAirbrone() {//返回飞机状态（起飞还是降落）
		return airbrone;
	}
	
	public void takeOff() {
		System.out.println("distaching plane!");
		this.airbrone=true;
		
	}
	
	public void buildFuselage() {
		System.out.println("Fuselage installed completely!");
		
	}
	public void buildWings() {
		System.out.println("Wings complete!");
	}
	
	
}
