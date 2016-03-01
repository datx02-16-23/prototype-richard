package datastructures;

public class Element implements Comparable<Element>{
	/**
	 * The value contained by this element.
	 */
	public double value = 0;
	/**
	 * The logical index of this Element.
	 */
	public int index = 0;
	/**
	 * Set to TRUE if this Elements index or value is been recently modified via SETTERS.
	 */
	boolean recentlyModified = false;
	/**
	 * Set to TRUE if this Elements index or value is been recently modified via GETTERS.
	 */
	boolean recentlyRead = false;
	
	public Element(int index, double value){
		this.index = index;
		this.value = value;
	}
	
	/**********************************************/
				     /*Methods*/
	/**********************************************/
	
	/**
	 * Returns the value of recentlyWritten and sets it to False.
	 * @return The old value of recentlyWritten.
	 */
	public boolean checkRecentlyModified(){
		boolean ans = this.recentlyModified;
		this.recentlyModified = false;
		return ans;
	}
	
	/**
	 * Returns the value of recentlyRead and sets it to False.
	 * @return The old value of recentlyRead.
	 */
	public boolean checkRecentlyRead(){
		boolean ans = this.recentlyRead;
		this.recentlyRead = false;
		return ans;
	}

	public static void clearFlags(Element[] elementsArray){
		for (int i = 0; i < elementsArray.length ; i++){
			elementsArray[i].recentlyModified = false;
			elementsArray[i].recentlyRead = false;
		}
	}
	
	public void clearFlags(){
		this.recentlyModified = false;
		this.recentlyRead = false;
	}
	
	/**********************************************/
				/*Setters and Getters*/
	/**********************************************/


	public boolean getRecentlyModified(){
		return this.recentlyModified;
	}
	
	public void setRecentlyModified(boolean newValue){
		this.recentlyModified = newValue;
	}
	
	public boolean getRecentlyRead(){
		return this.recentlyRead;
	}
	
	public void setRecentlyRead(boolean newValue){
		this.recentlyRead = newValue;
	}
	

	public void setIndex(int newIndex){
		this.index = newIndex;
		this.recentlyModified = true;
	}
	
	public int getIndex(){
		this.recentlyRead = true;
		return this.index;
	}

	public void setValue(double newValue){
		this.recentlyModified = true;
		this.value = newValue;
	}
	
	public double getValue(){
		recentlyRead = true;
		return this.value;
	}

	
	@Override
	public int compareTo(Element other) {
		other.recentlyRead = true;
		this.recentlyRead = true;
		
		if (this.value < other.value){
			return -1;
		} else if (this.value > other.value){
			return 1;
		} else {
			return 0;
		}
	}
}
