package view;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

import _main.Algorithms;
import datastructures.Element;

@SuppressWarnings("serial")
public class BoxView extends View {
	private int size;
	private int boxWidth = 70;
	private int boxHeight = 50;
	private int columns = 40;
	private int padding = 50;
	
	public BoxView(int size){
		this.size = size;
		this.setBackground(Color.WHITE);
		if (columns > size){
			columns = size;
		}
	}

	
	//WHERE THE MAGIC HAPPENS
	@Override
	public void drawElements(Graphics g) {
		
		int rows = (int)(0.999999999999+(double)size/columns);

		//Draw boxes
		for (Element e : elements){
			
			//Determine box colour.
			if (e.checkRecentlyModified()){
				g.setColor(Color.RED);
				e.checkRecentlyRead(); //clear read flag 
			} else {
				if (e.checkRecentlyRead()){
					g.setColor(Color.GREEN);
				}	else {
					g.setColor(Color.WHITE); //No access by setters/getters since last pass.
				}
			}
			
			int xPos = padding + (e.index%columns)*boxWidth;
			int yPos = padding + (e.index/columns)*boxHeight;
			
			g.fillRect(xPos, yPos, boxWidth, boxHeight);
			
			g.setColor(Color.BLACK);
			String str = Double.toString(e.value);
			g.drawString(str, xPos+boxWidth/3, yPos+boxHeight/2);
		}
			
			
		g.setColor(Color.BLACK);
		//Draw vertical lines
		for (int i = 0; i < columns+1; i++ ){
			g.drawLine(padding+i*boxWidth, padding, padding+i*boxWidth, padding+boxHeight*rows);
		}
		//Draw horizontal lines
		for (int i = 0; i < rows+1; i++ ){
			g.drawLine(padding, padding+boxHeight*i, padding + boxWidth*columns, padding+i*boxHeight);	
		}
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		this.drawElements(g);
	}
}
