/*
 * File: Hangman.java
 * ------------------
 * This program will eventually play the Hangman game from
 * Assignment #4.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hangman extends ConsoleProgram {

	/***********************************************************
	 *              CONSTANTS                                  *
	 ***********************************************************/
	
	/* The number of guesses in one game of Hangman */
	private static final int N_GUESSES = 7;
	/* The width and the height to make the karel image */
	private static final int KAREL_SIZE = 150;
	/* The y-location to display karel */
	private static final int KAREL_Y = 230;
	/* The width and the height to make the parachute image */
	private static final int PARACHUTE_WIDTH = 300;
	private static final int PARACHUTE_HEIGHT = 130;
	/* The y-location to display the parachute */
	private static final int PARACHUTE_Y = 50;
	/* The y-location to display the partially guessed string */
	private static final int PARTIALLY_GUESSED_Y = 430;
	/* The y-location to display the incorrectly guessed letters */
	private static final int INCORRECT_GUESSES_Y = 460;
	/* The fonts of both labels */
	private static final String PARTIALLY_GUESSED_FONT = "Courier-36";
	private static final String INCORRECT_GUESSES_FONT = "Courier-26";
	
	/***********************************************************
	 *              Instance Variables                         *
	 ***********************************************************/
	
	/* An object that can produce pseudo random numbers */
	private RandomGenerator rg = new RandomGenerator();
	private int k=-1;//a sentinel for check whether inputing a right letter or not
	private int rightest=6;//count for right cord 
	private int leftest=0;//count for left cord
	private int previousNum;//check the whether the string was removed or not;
	private int left;
	private String temp="";
	private GLine[] cord= new GLine[N_GUESSES];
	private GCanvas canvas = new GCanvas();
	private GImage parachute=new GImage("parachute.png");
	private GImage karel=new GImage("karel.png");
	private GImage karelFlipped=new GImage("karelFlipped.png");
	private GLabel guessed;
	private GLabel Incorrected;
	private String incorrectedStr="";
	private char incorrectedChar;
	/***********************************************************
	 *                    Methods                              *
	 ***********************************************************/
	public void init() {
		add(canvas);
		drawBackground();
		drawKarel();
		drawParachute();
		drawCords();
	}
	
	private void drawKarel() {
		karel.setSize(KAREL_SIZE,KAREL_SIZE);
		canvas.add(karel,(canvas.getWidth()-karel.getWidth())/2.0,KAREL_Y);
	}
	
	private void drawParachute() {
		parachute.setSize(PARACHUTE_WIDTH,PARACHUTE_HEIGHT);
		canvas.add(parachute,(canvas.getWidth()-parachute.getWidth())/2.0,PARACHUTE_Y);
		
	}
	
	private void drawBackground() {
		GImage back=new GImage("background.jpg");
		back.setSize(canvas.getWidth(),canvas.getHeight());
		canvas.add(back,0,0);	
	}
	
	//draw the cords and the number is identical with that of the guesses.
	private void drawCords() {
		for(int i=0;i<N_GUESSES;i++) {
			double x=(canvas.getWidth()-parachute.getWidth())/2.0+i*parachute.getWidth()/(N_GUESSES-1);
			cord[i]=new GLine(x,PARACHUTE_Y+parachute.getHeight(),canvas.getWidth()/2.0,KAREL_Y);
			canvas.add(cord[i]);

		}
	}
	
	//move away one String while user input an incorrect letter
	private void moveCords() {
		if(N_GUESSES!=left) {
			int i=N_GUESSES-left;
			if(previousNum!=i) {
				if(i%2==1) {
					canvas.remove(cord[rightest]);
					rightest--;
					previousNum=i;
				}else {
					canvas.remove(cord[leftest]);
					leftest++;
					previousNum=i;
				}
			}
		}
		checkStatus();
	}
	
	//check are there any cords left.
	private void checkStatus() {
		if(previousNum==N_GUESSES) {
			canvas.remove(karel);
			karelFlipped.setSize(KAREL_SIZE,KAREL_SIZE);
			canvas.add(karelFlipped,(canvas.getWidth()-karel.getWidth())/2.0,KAREL_Y);
		}
		
	}
	
	private void drawGuessed() {
		if(guessed!=null) {
		canvas.remove(guessed);
		}
		guessed=new GLabel(temp);
		guessed.setFont( PARTIALLY_GUESSED_FONT );
		canvas.add(guessed,(canvas.getWidth()-guessed.getWidth())/2.0,PARTIALLY_GUESSED_Y);
	}
	
	private void drawIncorrectedLetter() {
		if(Incorrected!=null) {
			canvas.remove(Incorrected);
		}
		Incorrected=new GLabel(incorrectedStr);
		Incorrected.setFont(INCORRECT_GUESSES_FONT);
		canvas.add(Incorrected,(canvas.getWidth()-Incorrected.getWidth())/2.0,INCORRECT_GUESSES_Y);
		
	}
	public void run() {
		println("Welcome to Hangman");
		String secretWord=getRandomWord();
		left=N_GUESSES;
		createDash(secretWord,k);
		try {
		userGuessLetter(secretWord);
		}catch(Exception e) {
			println("********************");
			println("Input a single char!");
			println("********************");
			userGuessLetter(secretWord);
		}
		
		
	}
	//create a dash string and update every guess
	private void createDash(String str,int pos) {
		String secretDashes="";
		if(pos<0) {
			for(int i=0;i<str.length();i++) {
				secretDashes+="-";
				temp+="-";
			}
			println("Your word now looks like this:"+secretDashes);
			println("You have "+left+" guesses left.");
		}else {
			for(int i=0;i<str.length();i++) {
				if(str.charAt(i)==str.charAt(pos)) {
					secretDashes+=str.charAt(i);
				}else {
				secretDashes+=temp.charAt(i);
				}
				
			}
			temp=secretDashes;	
		}
		
	}
	
	//make every guess
	private void userGuessLetter(String str) {
		drawGuessed();
		moveCords(); //答错一次，remove one cord in special order
		String gue=readLine("Your guess:");
		//确保输入的字符串只为字符，而不是符号等其他元素。
		if(gue.length()>=2||(!Character.isLetter(gue.charAt(0)))) {
			println("********************");
			println("Input a single char!");
			println("********************");
			userGuessLetter(str);	
		}
		else {
		int t=k;//识别辅助符号
		char guess=Character.toUpperCase(gue.charAt(0));
		for(int i=0;i<str.length();i++) {
			if(guess==Character.toUpperCase(str.charAt(i))) {
				k++;
				createDash(str,i);
			}
			incorrectedChar=guess;
		}
		
		if(t==k) //识别是否有对应的字母输出，有则iva与local va不相等。
		{	
			incorrectedStr+=incorrectedChar;
			drawIncorrectedLetter();
			checkLose(str);
		}else {
			
			checkWin(str);
		}	
		}
	}
	
	//check whether the result is satisfied the correct word
	private void checkWin(String str) {
		if(temp.equals(str)) {
			println("That guess is correct.");
			println("You win.");
			println("The word was: "+str);
			}else {
				left++;
				checkLose(str);
	}
	}
	
	//check whether the left turn is over and then user loss the game.
	private void checkLose(String str) {
		left--;
		if(left>0) {
			println("Your word now looks like this:"+temp);
			println("You have "+left+" guesses left.");
			userGuessLetter(str);
	}
		else {
			println("There are no R's in the word.");
			println("You're completely hung.");
			println("The word was: "+str);
			moveCords(); 
		}
		}
	
	/**
	 * Method: Get Random Word
	 * -------------------------
	 * This method returns a word to use in the hangman game. It randomly 
	 * selects from among 10 choices.
	 */
	private String getRandomWord() {
		try {
		Scanner file=new Scanner(new File("HangmanLexicon.txt"));
		ArrayList<String> line=new ArrayList<String>();
		while(file.hasNextLine()) {
			line.add(file.nextLine());
			}
		int index=rg.nextInt(line.size());
		file.close();
		return line.get(index);
		}catch(Exception e) {
		throw new ErrorException("getWord: Illegal file!"); 
		}
	}

}
