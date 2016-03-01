package view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

import _main.Algorithms;
import datastructures.Element;

@SuppressWarnings("serial")
public class BarView extends View{
	private int elementGap = 15;
	private int padding = 50;
	private int unitHeight = 30;
	private int barWidth = 30;
	
	public BarView(){
		super();
		this.setBackground(Color.WHITE);
	}

	
	//WHERE THE MAGIC HAPPENS
	@Override
	public void drawElements(Graphics g){
		final int CANVAS_HEIGHT = this.getHeight();
		final int CANVAS_WIDTH= this.getWidth();

		//Draw axes
		g.drawLine(0, CANVAS_HEIGHT-padding, CANVAS_WIDTH, CANVAS_HEIGHT-padding);
		g.drawLine(padding, 0, padding, CANVAS_HEIGHT);
		//Draw y axis steps
		int yValueTag = 1;
		for(int yPos = CANVAS_HEIGHT-(padding + unitHeight); yPos > 0; yPos = yPos - unitHeight){
			g.drawLine(padding-6,yPos,padding+6,yPos);
			g.drawString(Integer.toString(yValueTag), padding-15, yPos);
			yValueTag++;
		}
		
		
		for (Element e : elements){
			
			//Determine bar colour.
			if (e.checkRecentlyModified()){
				g.setColor(Color.RED);
				e.checkRecentlyRead(); //Clear recentlyRead flag 
			} else {
				if (e.checkRecentlyRead()){
					g.setColor(Color.GREEN);
				}	else {
					g.setColor(Color.BLACK); //No access by setters/getters since last pass.
				}
			}
			
			//Calculate bar width and height.
			int width = barWidth;
			int height = (int) (e.value*unitHeight);
			height = height + 3; //Show elements of value 0
			
			//Calculate starting positions when drawing.
			int xPos = padding + elementGap + e.index*(barWidth+elementGap);
			int yPos = CANVAS_HEIGHT-(height+padding);
			
			String valueStr = Double.toString(e.value);
			g.fillRect(xPos, yPos, width, height); //Draw bar.
			g.setColor(Color.BLACK);
			g.drawString(valueStr, xPos+5, yPos-10); //Draw value above bar.
			
			String indexStr = Integer.toString(e.index);
			g.drawString(indexStr, xPos+barWidth/3, height+yPos+15); //Draw index below bar.
			
			//Inefficient
			for (int j = 1; j < e.value; j++){
				g.setColor(Color.WHITE);
				g.drawLine(xPos, CANVAS_HEIGHT-(j*unitHeight+padding), xPos+barWidth, CANVAS_HEIGHT-(j*unitHeight+padding));
			}
			super.drawInfoBox(g, null);
		}
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		this.drawElements(g);
	}
	
	public void sayHello(){
		System.out.println("Hello from class BarView!");
	}
}
