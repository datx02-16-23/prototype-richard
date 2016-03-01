package view;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import datastructures.Element;

public abstract class View extends JPanel {
	private static final long serialVersionUID = 1L;
	
	protected List<Element> elements = new ArrayList<Element>();
	
	public abstract void drawElements(Graphics g);

	public List<Element> getElements(){
		return elements;
	};
	public void setElements(List<Element> newElements){
		this.elements = newElements;
	}
	
	public void sayHello(){
		System.out.println("Hello from abstract class View!");
	}
	
	public void drawInfoBox(Graphics g, InfoBox ib){
		final int CANVAS_WIDTH= this.getWidth();
		int boxWidth = 200;
		int boxHeight = 100;
		int padding = 20;
		int x = CANVAS_WIDTH-boxWidth-padding;
		int y = padding;
		g.setColor(Color.CYAN);
		g.fillRect(x, y, boxWidth, boxHeight);
		g.setColor(Color.BLACK);
		g.drawRect(x, y, boxWidth, boxHeight); //Draw box.
		g.drawString("Some info.", x-padding/2+15, y+15);
		g.drawString("Gson is pretty neat.", x-padding/2+15, y+30);
		g.drawString("It's 02:32 I should be sleeping.", x-padding/2+15, y+45);
		g.drawString("Help me.", x-padding/2+15, y+60);
		g.drawString("Bleep bloop!", x-padding/2+15, y+75);
		g.drawString("Ayyyy.", x-padding/2+15, y+90);
	}
}
