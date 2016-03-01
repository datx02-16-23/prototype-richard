package datastructures;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Provides a context for collections of the Element Type.
 * @author Richard
 *
 */
public class DataStructure {
	private ArrayList<Element> elements;
	/**
	 * The type of data structure this class represents.
	 */
	private String type;

	/**
	 * The preferred visual style of this DataStructure. May vary depending on DataStructure type.
	 */
	private String visualStyle;

	private Color preferredColor = Color.BLACK;
	
	public final String IDENTIFIER;
	
	public DataStructure(String identifier, String type, String style){
		if (identifier == null){
			throw new NullPointerException("Identifier cannot be NULL.");
		}
		this.IDENTIFIER = identifier;
		this.type = type;
		ensureVisual(type, style);
		elements = new ArrayList<Element>();
	}
	
	
	
	/**********************************************/
				     /*Methods*/
	/**********************************************/
	
	/**
	 * Add new Elements to this DataStructure.
	 * @param additionalElements The List of Elements to add.
	 * @return True additional Elements were added.
	 */
	public boolean addElements(List<Element> additionalElements){
		return elements.addAll(additionalElements);
	}
	/**
	 * Add new Elements to this DataStructure.
	 * @param additionalElements The array Elements to add.
	 * @return True additional Elements were added.
	 */
	public boolean addElements(Element[] additionalElements){
		return elements.addAll(Arrays.asList(additionalElements));
	}
	/**
	 * Add new Elements to this DataStructure.
	 * @param additionalElements The Element to add.
	 * @return True the Element were added.
	 */
	public boolean addElement(Element additionalElement){
		return elements.add(additionalElement);
	}
	
	/**
	 * Assign the default visual type for this type, if null.
	 * @return true if a visual type was successfully set.
	 */
	public boolean ensureVisual(){
		return ensureVisual(this.type, this.visualStyle);
	}
	
	/**
	 * Assign the default visual type for this type, if null.
	 * @param type The type of the data structure declared.
	 * @param visual The visual style declared for this data structure.
	 * @return true if a visual type was successfully set.
	 */
	private boolean ensureVisual(String type, String visual){
		if (visual != null){
			this.visualStyle = visual;
			return true;
		}
		
		//TODO: Keep this in a seperate config file.
		switch(type){
			case "array":
				this.visualStyle = "bar";
				break;
			case "graph":
				this.visualStyle = "pretty fucking graph with colour and shit";
				break;
			default:
				System.out.println("Default visual style DataStructure of type: \"" + type + "\" is not defined.");
				return false;
		}
		return true;
	}
	
	
	
	
	
	
	
	
	/**********************************************/
				/*Setters and Getters*/
	/**********************************************/
	
	
	
	public String getType() {
		return type;
	}

	public void setType(String newType) {
		this.type = newType;
	}
	
	public String getVisual() {
		return visualStyle;
	}
	public void setVisualStyle(String newVisualStyle) {
		this.visualStyle = newVisualStyle;
	}
	
	public void setPreferredColor(Color newColor){
		this.preferredColor = newColor;			
	}
	
	public Color getPreferredColor(){
		return preferredColor;
	}

	public List<Element> getElements() {
		return elements;
	}

	public void setElements(List<Element> elements) {
		this.elements = (ArrayList<Element>) elements;	//COWBOY CASTING
	}
}
