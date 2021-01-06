import java.io.File;
import java.util.*;
/*
 * File: Flight.java
 * Will eventually represent a particular flight between 
 * two locations.
 */
public class Flight {
	private String destination;
	private double hours;
	private String source;
	
	public Flight(String des,String sour,double hours) {
		this.destination=des;
		this.hours=hours;
		this.source=sour;
	}
	
	public String getDes() {
		return this.destination;
	}
	
	public String getSource() {
		return this.source;
		
	}
	
	public double getHours() {
		return this.hours;
	}
	
	public String toString() {
		return this.source+"->"+this.destination+":"+this.hours;
	}
}

