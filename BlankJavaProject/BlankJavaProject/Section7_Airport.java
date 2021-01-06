import java.util.*;

import acm.program.*;
public class Section7_Airport extends ConsoleProgram {
	private final static int AIRPLANE_BUILDNUM=4;
	private final static int DISTACHNUMBER=2;
	public void run() {
		
		manufactureAirplane(AIRPLANE_BUILDNUM);
		distachAirplane(DISTACHNUMBER);
	}
	
	private void manufactureAirplane(int amount) {
		for(int i=0;i<amount;i++) {
		Section7_Airplane airp= new Section7_Airplane();
		airInLand.add(airp);
		}
	}
	
	private void distachAirplane(int num) {
		if(num<=AIRPLANE_BUILDNUM) {
			System.out.println(num+" airplane distached!");
			for(int i=0;i<num;i++) {
				airInLand.get(0).takeOff();
				airOnSky.add(airInLand.get(0));
				airInLand.remove(0);
			}
		}else {
			
			System.out.println("Do not build enough Airplane!");
		}
		
	}
	private ArrayList<Section7_Airplane> airInLand;
	private ArrayList<Section7_Airplane> airOnSky;
}
