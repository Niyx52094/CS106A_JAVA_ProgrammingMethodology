package practice10;
import acm.graphics.*;
import acm.program.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
public class Weather extends ConsoleProgram {
	public void run(){
        
        String name=readLine("Input file?");
        Scanner fi=new Scanner(new File(name));
        while(fi.hasNextLine()){
        StringTokenizer token=new StringTokenizer(fi.nextLine());
            String ID=token.nextToken();
            String na=token.nextToken();
            double Hour=0;
            for(int count=2;token.hasMoreTokens();count++){
                Hour+=Double.parseDouble(token.nextToken());
            }
            perDay=Hour/(count-2);
            println(na+" (ID#"+ID+") worked "+Hour+" hours ("+perDay+"/day)");
        }
    }
    
   
}