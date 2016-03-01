package operations_interceptor;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import datastructures.DataStructure;
import datastructures.Element;
import view.BarView;
import view.BoxView;
import view.View;
import view.Visualiser;

public class OI_Reader {
	private static final Gson gson = new Gson();
	private FileReader fileReader;
	private JsonReader jsoReader;
	private OIWrapper oiWrapper;
	private final Visualiser vis;
	
	/**
	 * Creates a new OI reader.
	 * @param view The View to apply changes to.
	 * @param jsonFileURL The URL of the file to read changes from.
	 */
	public OI_Reader(Visualiser vis, String jsonFileURL){
		this.vis = vis;
		try {
			fileReader = new FileReader(jsonFileURL);
			jsoReader = new JsonReader(fileReader);
		} catch (Exception e) {
			System.out.println(this.getClass() + ": " + e.toString());
		}
		oiWrapper = gson.fromJson(jsoReader, OIWrapper.class);
		try {
			processOI(oiWrapper);
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
			System.exit(-1);
		}
		System.out.println("Done!");
	}

	private HashMap<String, DataStructure> knownDataStructures = new HashMap<String, DataStructure>();
	private HashMap<String, View> dsViews = new HashMap<String, View>();
	public void processOI(OIWrapper oiw) throws NullPointerException{
		/**
		 * Process declarations.
		 */
		if (oiw.declarations != null){
			VariableDeclaration[] declarations = oiw.declarations;
			
				//Process all declarations
				for(int i = 0; i < declarations.length; i++){
					System.out.println(declarations[i].toString());
					DataStructure ds = knownDataStructures.get(declarations[i].identifier);
					if(ds != null){
						//Known identifier. Expecting update of some parameter.
						
						if (declarations[i].type != null){
							ds.setType(declarations[i].type);
							//TODO: Sets visual style to default for the type regardless of wether it changed. Might be annoying.
							ds.setVisualStyle(null);
							ds.ensureVisual();
						}
						if (declarations[i].visual != null){
							ds.setVisualStyle(declarations[i].visual);
							View v = createView(ds);
							v.setElements(ds.getElements());
							dsViews.put(ds.IDENTIFIER, v); 
						}
					} else {
						//New identifier. Initialize and add it to the list of known data structures.
						DataStructure newDS = new DataStructure(declarations[i].identifier, declarations[i].type, declarations[i].visual);
						knownDataStructures.put(newDS.IDENTIFIER, newDS);
						View v = createView(newDS); //bla
						v.setElements(newDS.getElements());
						dsViews.put(newDS.IDENTIFIER, v); 
						vis.addView(v);
					}
				}
			}
//		}
		else {
			System.out.println("No declaratins to process.");
		}
		
		/**
		 * Process commands.
		 */
		if (oiw.commands != null){
			Command[] commands = oiw.commands;
			//Process all commands
			for (int i = 0; i < commands.length; i++){
				Command cmd = commands[i];
				if (knownDataStructures.containsKey(cmd.id) == false){
					//Skip to next command if the id is unknown.
					System.out.println("Unknown identifier: \"" + cmd.id + "\". Did you forget to declare it?");
					continue;
				}
				//Process the command.
				dispatchCommand(knownDataStructures.get(cmd.id), cmd.op, cmd.index, cmd.value);
			}
		} else {
			System.out.println("No commands to process.");
		}
	}
	
	/**
	 * Execute a command on a DataStructure ds with any type.
	 * @param ds The data structure to execute a command on.
	 * @param operation The operation to perform.
	 * @param index The index(es) of the operation.
	 * @param value The parameter for the operation.
	 */
	public void dispatchCommand(DataStructure ds, String operation, int[] index, double value){
		try {Thread.sleep(500);} catch (InterruptedException e) {}
		View v = dsViews.get(ds.IDENTIFIER);
		v.repaint();
		
		//TODO: Extract known types into a file.
		switch(ds.getType()){
		case "array":
			executeArrayCommand(ds, operation, index, value);
			break;
		case "trä":
			//TODO: Tree operations.
			break;
		default:
			System.out.println("Unknown DataStructure type: " + ds.getType());
			break;
		}
	}
	
	/**
	 * Execute a command on a DataStructure ds with type array.
	 * @param ds The data structure to execute a command on.
	 * @param operation The operation to perform.
	 * @param index The index(es) of the operation.
	 * @param value The parameter for the operation.
	 */
	public void executeArrayCommand(DataStructure ds, String operation, int[] index, double value){
		List<Element> elements = ds.getElements();
		switchCase: switch(operation){
			case Command.OP_READ:
				for(Element e : elements){
					if(e.index == index[0]){
						e.getValue();
						break switchCase;
					}
				}
				//if(discovery) TODO: let the user choose if discovery is enabled
				Element er = discover(ds, index, value);
				er.setRecentlyRead(true);
				break;
			case Command.OP_WRITE:
				for(Element e : elements){
					if(e.index == index[0]){
						e.setValue((int) value);
						break switchCase;
					}
				}
				//if(discovery) TODO: let the user choose if discovery is enabled
				Element ew = discover(ds, index, value);
				ew.setRecentlyModified(true);
				break;
			default:
				System.out.println("Invalid operation:" + operation);
				break;
		}
	}
	
	public Element discover(DataStructure ds, int[] index, double value){
		Element e = new Element(index[0], value);
		ds.addElement(e);
		return e;
	}
	
	/**
	 * Create a View in the preferred style of the given DataStructure. 
	 * @param ds The DataStructure to create a style for.
	 * @return A view if the type requested by ds was known, null otherwise.
	 */
	public View createView (DataStructure ds){
		View v;
		String visualStyle = ds.getVisual();
		
		//TODO: Hårdkodade antal. Borde skötas av View...
		switch(visualStyle){
		case "bar":
			v = new BarView();
			break;
		case "box":
			v = new BoxView(30);
			break;
		default:
			System.out.println("DataStructure " + ds.IDENTIFIER + " requested an unknown style: \"" + visualStyle + "\".");
			return null;
	}
		return v;
	}
}
