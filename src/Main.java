import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

public class Main {
	private static final String R_DESKTOP = "C:\\Users\\Richard\\Desktop\\";

	public static void main(String[] args) {
		new Main();
	}
	
	public Main(){
		System.out.println("Begin.");
		printTest();
		System.out.println("End.");
	}
	
	/**
	 * Print a test JSON to Richard's desktop.
	 */
	public static void printTest(){

		Gson gson = new GsonBuilder().setPrettyPrinting().create(); //Somewhat human readable
		//Create header
			//Create annotated variables
			AnnotatedVariable array1 = new AnnotatedVariable("array1", "array", null, null);
			AnnotatedVariable array2 = new AnnotatedVariable("array2", "array", null, "box");
			AnnotatedVariable array_as_binary_tree = new AnnotatedVariable("array_as_binary_tree", "array", "binary_tree", null);
			AnnotatedVariable tree1 = new AnnotatedVariable("tree1", "tree", null, null);
			
			//Populate map
			HashMap<String, AnnotatedVariable> annotatedVariables = new HashMap<String, AnnotatedVariable>();
			annotatedVariables.put(array1.identifier, array1);
			annotatedVariables.put(array2.identifier, array2);
			annotatedVariables.put(array_as_binary_tree.identifier, array_as_binary_tree);
			annotatedVariables.put(tree1.identifier, tree1);
			
			Header header = new Header(1, annotatedVariables);
		
		//Create body
			//Initialize
			OP_Init init_array1 = new OP_Init();
					init_array1.setTarget(new ArrayVariable("array1", null));
					init_array1.setSize(new int[]{5});
					init_array1.setValue("[1,2,3,4,5]");

			OP_Init init_array2 = new OP_Init();
				init_array2.setTarget(new ArrayVariable("array2", null));
				init_array2.setSize(new int[]{3});
				init_array2.setValue("[3,4,5]");
			OP_Init init_array_as_binary_tree = new OP_Init();
				init_array2.setTarget(new ArrayVariable("array_as_binary_tree", null));
				init_array2.setSize(new int[]{7});
				init_array2.setValue("[3,4,5,6,7,8,9]");
			OP_Init init_tree1 = new OP_Init();
				init_array2.setTarget(new ArrayVariable("tree1", null));
				init_array2.setSize(new int[]{7});
				init_array2.setValue("[3,4,5,6,7,8,9]");
			
			//Do some stuff
			OP_Read read_from_array1_to_array2 = new OP_Read();
				read_from_array1_to_array2.setSource(new ArrayVariable("array1", new int[]{3}));
				read_from_array1_to_array2.setTarget(new ArrayVariable("array2", new int[]{7}));
				read_from_array1_to_array2.setValue("3");
				
			OP_Write write_to_array_as_binary_tree = new OP_Write();
				read_from_array1_to_array2.setTarget(new ArrayVariable("array2", new int[]{7}));
				read_from_array1_to_array2.setValue("1337");
				
			OP_Swap swap_array1_array2 = new OP_Swap();
				swap_array1_array2.setVar1(new ArrayVariable("array1", new int[]{0}));
				swap_array1_array2.setVar2(new ArrayVariable("array2", new int[]{0}));
				swap_array1_array2.setValue("[3, 1]");
				
		String outputFileName = "2016-03-04.json";
		
		ArrayList<Operation> body = new ArrayList<Operation>();
		body.add(init_array1);
		body.add(init_array2);
		body.add(init_array_as_binary_tree);
		body.add(init_tree1);
		
		body.add(read_from_array1_to_array2);
		body.add(write_to_array_as_binary_tree);
		body.add(swap_array1_array2);
		
		//Print
		Wrapper testJson = new Wrapper(header, body);
		String jsonString = gson.toJson(testJson);
		try (PrintStream out = new PrintStream(new FileOutputStream(R_DESKTOP+outputFileName))) {
		    out.print(jsonString);
		    out.flush();
		    out.close();
		} catch (FileNotFoundException e) {e.printStackTrace();}
		
		
	}
}
