package view;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Visualiser extends JFrame{
	
	private final List<View> views;
	
	public Visualiser(){
		super();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int)screenSize.getWidth()*8/10;
		int height = (int)screenSize.getHeight()*8/10;
		this.setSize(width, height);
		this.setLocationRelativeTo(null);
		this.setLayout(new GridLayout(1,2));
		this.setTitle("Visualiser");
		this.setBackground(Color.RED);
		views = new ArrayList<View>();
	}
	
	public void addView(View v){
		v.setVisible(true);
		this.add(v);
		views.add(v);
		this.revalidate();
	}
	
	public void removeView(View v){
		this.remove(v);
		views.remove(v);
	}

}
