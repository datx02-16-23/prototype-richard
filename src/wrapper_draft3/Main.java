package wrapper_draft3;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import wrapper_draft3.AnnotatedVariable;
import wrapper_draft3.Operation;
import wrapper_draft3.Header;
import wrapper_draft3.Wrapper;

public class Main {
	private static final Gson GSON = new Gson();
	private static final String R_DESKTOP = "C:\\Users\\Richard\\Desktop\\";
	private static final String jsonFileURL = R_DESKTOP+"test2.json";
	
	private JsonReader jsoReader;
	private FileReader fileReader;
	private Wrapper wrapper;

	public static void main(String[] args) {
		System.out.println("draft 2");
		new Main();
		System.out.println("done 2");
	}
	
	public Main(){

		printTest();
//		
//		try {
//			fileReader = new FileReader(jsonFileURL);
//		} catch (FileNotFoundException e) {System.out.println("not found");}
//		jsoReader = new JsonReader(fileReader);
//		wrapper = GSON.fromJson(jsoReader, Wrapper.class);
//		System.out.println("Read file.");	
	}
	
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
			
			Header header = new Header(Header.VERSION_UNKNOWN, annotatedVariables);
		
		//Create body
			//Initialize
			OP_Init init_array1 = new OP_Init();
					init_array1.setDestination(new Variable_Array("array1", null));
					init_array1.setSize(new int[]{5});
					init_array1.setValue("[1,2,3,4,5]");
			System.out.println(init_array1);
			OP_Init init_array2 = new OP_Init();
				init_array2.setDestination(new Variable_Array("array2", null));
				init_array2.setSize(new int[]{3});
				init_array2.setValue("[3,4,5]");
			OP_Init init_array_as_binary_tree = new OP_Init();
				init_array2.setDestination(new Variable_Array("array_as_binary_tree", null));
				init_array2.setSize(new int[]{7});
				init_array2.setValue("[3,4,5,6,7,8,9]");
			OP_Init init_tree1 = new OP_Init();
				init_array2.setDestination(new Variable_Array("tree1", null));
				init_array2.setSize(new int[]{7});
				init_array2.setValue("[3,4,5,6,7,8,9]");
			
			//Do some stuff
			OP_Read read_from_array1_to_array2 = new OP_Read();
				read_from_array1_to_array2.setSource(new Variable_Array("array1", new int[]{3}));
				read_from_array1_to_array2.setDestination(new Variable_Array("array2", new int[]{7}));
				read_from_array1_to_array2.setValue("3");
				
			OP_Write write_to_array_as_binary_tree = new OP_Write();
				read_from_array1_to_array2.setDestination(new Variable_Array("array2", new int[]{7}));
				read_from_array1_to_array2.setValue("1337");
				
		String outputFileName = "2016-03-04.json";
		
		ArrayList<Operation> body = new ArrayList<Operation>();
		body.add(init_array1);
		body.add(init_array2);
		body.add(init_array_as_binary_tree);
		body.add(init_tree1);
		
		body.add(read_from_array1_to_array2);
		body.add(write_to_array_as_binary_tree);
		
		//Print
		Wrapper testJson = new Wrapper(header, body);
		String jsonString = gson.toJson(testJson);
		try (PrintStream out = new PrintStream(new FileOutputStream(R_DESKTOP+outputFileName))) {
		    out.print(jsonString);
		    out.flush();
		    out.close();
		    System.out.println(jsonString.length());
		} catch (FileNotFoundException e) {e.printStackTrace();}
		
		
	}
}
