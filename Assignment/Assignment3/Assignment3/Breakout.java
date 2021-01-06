/*
 * File: Breakout.java
 * -------------------
 * Name:
 * Section Leader:
 * 
 * This file will eventually implement the game of Breakout.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Breakout extends GraphicsProgram {

	// Dimensions of the canvas, in pixels
	// These should be used when setting up the initial size of the game,
	// but in later calculations you should use getWidth() and getHeight()
	// rather than these constants for accurate size information.
	public static final double CANVAS_WIDTH = 420;
	public static final double CANVAS_HEIGHT = 600;

	// Number of bricks in each row
	public static final int NBRICK_COLUMNS = 10;

	// Number of rows of bricks
	public static final int NBRICK_ROWS = 10;

	// Separation between neighboring bricks, in pixels
	public static final double BRICK_SEP = 4;

	// Width of each brick, in pixels
	public static final double BRICK_WIDTH = Math.floor(
			(CANVAS_WIDTH - (NBRICK_COLUMNS + 1.0) * BRICK_SEP) / NBRICK_COLUMNS);

	// Height of each brick, in pixels
	public static final double BRICK_HEIGHT = 8;

	// Offset of the top brick row from the top, in pixels
	public static final double BRICK_Y_OFFSET = 70;

	// Dimensions of the paddle
	public static final double PADDLE_WIDTH = 60;
	public static final double PADDLE_HEIGHT = 10;

	// Offset of the paddle up from the bottom 
	public static final double PADDLE_Y_OFFSET = 30;

	// Radius of the ball in pixels
	public static final double BALL_RADIUS = 10;

	// The ball's vertical velocity.
	public static final double VELOCITY_Y = 3.0;

	// The ball's minimum and maximum horizontal velocity; the bounds of the
	// initial random velocity that you should choose (randomly +/-).
	public static final double VELOCITY_X_MIN = 1.0;
	public static final double VELOCITY_X_MAX = 3.0;

	// Animation delay or pause time between ball moves (ms)
	public static final double DELAY =500.0 / 60.0;

	// Number of turns 
	public static final int NTURNS = 3;

	public void run() {
		// Set the window's title bar text
		setTitle("CS 106A Breakout");

		// Set the canvas size.  In your code, remember to ALWAYS use getWidth()
		// and getHeight() to get the screen dimensions, not these constants!
		setCanvasSize(CANVAS_WIDTH, CANVAS_HEIGHT);

		/* You fill this in, along with any subsidiary methods */
		setUpBricks();
		setPaddle();
		createBoucedBall();
		checkLoseOrWin();//判断游戏输赢
	}
	
	//设置初始的砖块
	private void setUpBricks() {
		for(int i=0;i<NBRICK_ROWS;i++) {
			for(int j=0;j<NBRICK_COLUMNS;j++) {
				brick=new GRect(BRICK_WIDTH,BRICK_HEIGHT);
				brick.setFilled(true);
				switch(j/2) {
				case 0:
					brick.setColor(Color.RED);
					break;
				case 1:
					brick.setColor(Color.ORANGE);
					break;
				case 2:
					brick.setColor(Color.YELLOW);
					break;
				case 3:
					brick.setColor(Color.GREEN);
					break;
				default:
					brick.setColor(Color.CYAN);
					break;
			}
				double x=(getWidth()-(BRICK_WIDTH+BRICK_SEP)*NBRICK_COLUMNS)/2.0+i*(BRICK_WIDTH+BRICK_SEP);
				double y=BRICK_Y_OFFSET+j*(BRICK_HEIGHT+BRICK_SEP);
				add(brick,x,y);
				
			}
			
		}
		
	}
	
	
	//设置下挡板
	private void setPaddle() {
		paddle =new GRect(PADDLE_WIDTH,PADDLE_HEIGHT);
		paddle.setFilled(true);
		add(paddle,(getWidth()-PADDLE_WIDTH)/2,getHeight()-PADDLE_Y_OFFSET-PADDLE_HEIGHT);
		addMouseListeners();
	}
	
	//建立paddle与mouse运动的联系，
	
	public void mouseMoved(MouseEvent e) {
		if(e.getX()<getWidth()-PADDLE_WIDTH&&e.getX()>PADDLE_WIDTH/2) {
		add(paddle,e.getX()-PADDLE_WIDTH/2,getHeight()-PADDLE_Y_OFFSET-PADDLE_HEIGHT);
		}else if(e.getX()>=getWidth()-PADDLE_WIDTH) {
			add(paddle,getWidth()-PADDLE_WIDTH,getHeight()-PADDLE_Y_OFFSET-PADDLE_HEIGHT);
		}else {
			add(paddle,0,getHeight()-PADDLE_Y_OFFSET-PADDLE_HEIGHT);
		}
	}
	
	//createBoucedBall();创建一个弹珠小球
	private void createBoucedBall() {
		ball=new GOval(BALL_RADIUS*2,BALL_RADIUS*2);
		ball.setFilled(true);
		double x=getWidth()/2.0-BALL_RADIUS;
		double y=getHeight()/2.0-BALL_RADIUS;
		add(ball,x,y);
		waitForClick();
		vy=VELOCITY_Y;
		vx=rgen.nextDouble(VELOCITY_X_MIN,VELOCITY_X_MAX);
		if(rgen.nextBoolean(0.5)) {
			vx=-vx;
		}
		while(ball.getX()+2*BALL_RADIUS<=getWidth()
				&&ball.getX()>=0
				&&ball.getY()+2*BALL_RADIUS<=getHeight()
				&&ball.getY()>=0) {
		makeBallBounce();//   装木板或者paddle
		if(num==0||turn==0) {//判断是否游戏可以终止。
			break;
		}
	}
	}
	//运动跳球
	
	private void makeBallBounce() {
		ball.move(vx, vy);
		checkCollision();//检查是否出现撞击
		pause(DELAY);
		
	}
	
	//check weather a collision exists
	private void checkCollision() {
		collideWall();//   撞墙
		checkCollidingObject();
	}
	
	//撞墙
	private void collideWall(){
		if(ball.getX()+2*BALL_RADIUS>getWidth()){ //撞击右墙
			vx=-vx;
			diff=(ball.getX()-(getWidth()-2*BALL_RADIUS))*2;
			ball.move(-diff, 0);
		}else if(ball.getX()<0) {//撞击左墙
			vx=-vx;
			diff=ball.getX()*2;
			ball.move(-diff, 0);
		}
		if(ball.getY()<0) {//撞击上墙
			vy=-vy;
			diff=ball.getY()*2;
			ball.move(0, -diff);
			
		}else if(ball.getY()+2*BALL_RADIUS>getHeight()) {
			turn=NTURNS-i;
			i++;
			double x=getWidth()/2.0-BALL_RADIUS;
			double y=getHeight()/2.0-BALL_RADIUS;
			ball.setLocation(x,y);
			waitForClick();
			//vy=-vy;
			//diff=(ball.getY()-(getHeight()-2*BALL_RADIUS))*2;
			//ball.move(0, -diff);
			
		}
		
	}
	//check if the ball hit any objects
	private void checkCollidingObject() {
		GObject collider=getCollidingObject();
		if(collider!=null) {
		if(collider==paddle) {
			vy=-vy;
			diff=(ball.getY()-(paddle.getY()-2*BALL_RADIUS))*2;
			ball.move(0, -diff);
		}else {
			bounceClip.play();
			remove(collider);
			num-=1;
			if(ball.getY()+BALL_RADIUS<collider.getY()+BRICK_HEIGHT/2.0) {
			vy=-vy;
			diff=(ball.getY()-(collider.getY()-2*BALL_RADIUS))*2;
			ball.move(0, -diff);
			}else{
				vy=-vy;
				diff=(ball.getY()-(collider.getY()+BRICK_HEIGHT))*2;
				ball.move(0, -diff);
			}
		}
		}
		
	}
	//return an object where the ball hit;
	private GObject getCollidingObject() {
		if(getElementAt(ball.getX(),ball.getY())!=null) {
			return getElementAt(ball.getX(),ball.getY());
		}else if(getElementAt(ball.getX()+2*BALL_RADIUS,ball.getY())!=null) {
			return getElementAt(ball.getX()+2*BALL_RADIUS,ball.getY());
		}else if(getElementAt(ball.getX(),ball.getY()+2*BALL_RADIUS)!=null) {
			return getElementAt(ball.getX(),ball.getY()+2*BALL_RADIUS);
		}else if(getElementAt(ball.getX()+2*BALL_RADIUS,ball.getY()+2*BALL_RADIUS)!=null) {
			return getElementAt(ball.getX()+2*BALL_RADIUS,ball.getY()+2*BALL_RADIUS);
		}else {
			return null;
		}
		
	}
	
	//检查游戏是否结束。
private void checkLoseOrWin() {
		if(num==0) {
			removeAll();
			GLabel label=new GLabel("CONGRATULATION! You WON THE GAME! !");
			label.setFont("Courier-20");
			double x=(getWidth()-label.getWidth())/2;
			double y=(getHeight()+label.getAscent())/2;
			add(label,x,y);
			
		}
		if(turn==0) {
			
			removeAll();
			GLabel label=new GLabel("SORRY,  YOU LOSE!!  KEEP FIGHTING! !");
			label.setFont("Courier-20");
			double x=(getWidth()-label.getWidth())/2;
			double y=(getHeight()+label.getAscent())/2;
			add(label,x,y);
		}
		
	}


AudioClip bounceClip = MediaTools.loadAudioClip("bounce.au");
private GRect paddle;
private GRect brick;
private int i=1;
private int turn=1;
private GOval ball;
private int num=NBRICK_ROWS*NBRICK_COLUMNS;
private double vx,vy,diff;
private RandomGenerator rgen=RandomGenerator.getInstance();
}
