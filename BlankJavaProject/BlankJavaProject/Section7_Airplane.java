
public class Section7_Airplane {
	private boolean airbrone;
	
	public Section7_Airplane() { //�ɻ�����
		buildFuselage();
		buildWings();
		this.airbrone=false;
	}
	
	public boolean isAirbrone() {//���طɻ�״̬����ɻ��ǽ��䣩
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
