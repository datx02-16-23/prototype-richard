package _main;
import java.util.List;

import datastructures.Element;
import view.View;

public class Algorithms {
	
	public static int SLEEP_DURATION = 25;
	
	public static void LoLSorT(List<Element> elements, View view) {
		System.out.println("Running LoLSorT.");
		boolean outOfOrder = true;
		
		while (outOfOrder){
			outOfOrder = false;
			
			
			//TODO: concurrent modification exception might be cast. Not yet tested
			for (Element e1 : elements){
				for (Element e2 : elements){
					
					if (e1.getValue() > e2.getValue() && e1.getIndex() < e2.getIndex()
							||  e1.getValue() < e2.getValue() && e1.getIndex() > e2.getIndex()){
						swapIndex(e1, e2);
						outOfOrder = true;
					}
					
					//try {Thread.sleep(SLEEP_DURATION);} catch (InterruptedException e) {}
					view.repaint();
				}
			}			
		}
		
		System.out.println("Done!");
	}
	
	private static void swapIndex(Element b1, Element b2){
		int index_tmp = b1.getIndex();
		b1.setIndex(b2.getIndex());
		b2.setIndex(index_tmp);		
	}
}
