package view;
/**package proto1;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class TreeView extends View {
	private int size;
	private Element[] elements;
	private final Canvas CANVAS;
	private int elemWidth = 70;
	private int elemHeight = 50;
	private int padding = 50;
	private int depth;
	private int width;
	JFrame jf = new JFrame();
	
	public TreeView(int size){
		this.size = size;
		elements = new Element[size];
		CANVAS = new Canvas(this);
		CANVAS.setVisible(true);
		jf.add(CANVAS);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
		jf.setSize(1440, 820);
		CANVAS.setBackground(Color.WHITE);
		
		depth = (int)Math.sqrt(size)+1;	
		width = depth*2;
	}
	

	//WHERE THE MAGIC HAPPENS
	@Override
	public void drawElements(Graphics g) {
		for (int i = 0; i < size; i++){
			Element cElem = elements[i];
			
			int xPos = padding;
			int yPos = padding + (i*size)%depth;
			
			g.fillRect(xPos, yPos, elemWidth, elemHeight);
			
			g.setColor(Color.BLACK);
			String str = Integer.toString(elements[i].value);
			g.drawString(str, xPos+elemWidth/3, yPos+elemHeight/2);
			
		}
	}
}
*/