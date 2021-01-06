import java.util.*;

import acm.graphics.*;
import acm.program.*;
import acm.util.RandomGenerator;
import java.awt.event.*;
import javax.swing.*;
public class Section7_WordCloud extends GraphicsProgram{
	public void init() {
		add(new JLabel("Name "),SOUTH);
		tf.addActionListener(this);
		add(tf,SOUTH);
		add(add,SOUTH);
		add(remove,SOUTH);
		add(clear,SOUTH);
		addActionListeners();
		addMouseListeners();
	}
	
	public void actionPerformed(ActionEvent e) {
	
		if(e.getSource()==add) {
			GLabel word=new GLabel(tf.getText());
			words.put(tf.getText(),word);
			//add(word,getWidth()/2-word.getWidth()/2.0,getHeight()/2+word.getDescent()/2);
			double x=rg.nextDouble(0,getWidth());
			double y=rg.nextDouble(0,getHeight());
			add(word,x,y);
		}
		if(e.getSource()==remove) {
			String removeWord=tf.getText();
			for(String localword:words.keySet()) {
				if(removeWord.equals(localword)){
					remove(words.get(localword));
					words.remove(removeWord);
				}
			}
			
		}
		if(e.getSource()==clear) {
			removeAll();
			words.clear();
		}
		
		
		
	}
	
	public void mousePressed(MouseEvent e) {
		po=new GPoint(e.getPoint());
		label=getElementAt(po);
		
	}
	
	public void mouseDragged(MouseEvent e) {
		if(label!=null) {
		double orix=label.getX();
		double oriy=label.getY();
		double dx=e.getX()-orix;
		double dy=e.getY()-oriy;
		label.move(dx,dy);
		po=new GPoint(e.getPoint());
		}
	}
	private GPoint po;
	private GLabel label;
	private JTextField tf=new JTextField(50);
	private JButton add=new JButton("Add");
	private JButton remove=new JButton("Remove");
	private JButton clear=new JButton("Clear");
	private RandomGenerator rg=new RandomGenerator().getInstance();
	private HashMap<String,GLabel> words=new HashMap<String,GLabel>();
}
