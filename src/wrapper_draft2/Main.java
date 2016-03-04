package wrapper_draft2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import wrapper_draft2.AnnotatedVariable;
import wrapper_draft2.Command;
import wrapper_draft2.Header;
import wrapper_draft2.Wrapper;

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
		
		try {
			fileReader = new FileReader(jsonFileURL);
		} catch (FileNotFoundException e) {System.out.println("not found");}
		jsoReader = new JsonReader(fileReader);
		wrapper = GSON.fromJson(jsoReader, Wrapper.class);
		System.out.println("Read file.");	
	}
	
	public static void printTest(){

		Gson gson = new GsonBuilder().setPrettyPrinting().create(); //Somewhat human readable
		
		//Create annotated variables
		AnnotatedVariable array_1 = 	new AnnotatedVariable("array_1", "array", new int[]{1}, "bar");
		AnnotatedVariable array_2 = 	new AnnotatedVariable("array_2", "array", null, "box");
		AnnotatedVariable tree_1 = 		new AnnotatedVariable("tree_1", "tree", new int[]{1}, null);
		AnnotatedVariable tree_2 = 		new AnnotatedVariable("tree_2", "tree", new int[]{1}, null);
		AnnotatedVariable array_3 = 	new AnnotatedVariable("array_3", "array", new int[]{16}, "array_as_binTree");
		
		//Initialize them
		Command array_1_init = new Command(
				new Operator[]{	new Operator("array_1", null)},			//Create operator
				"init",													//Function
				new String[]{"array_1-1", "array_2-2"},					//Result
				new int[]{1}											//Size
				);
		
		Command array_2_init = new Command(
				new Operator[]{	new Operator("array_2", null)},			//Create operator
				"init",													//Function
				new String[]{"array_2-1", "array_2-2"},					//Result
				new int[]{1}											//Size
				);
		
		Command tree_1_init = new Command(
				new Operator[]{	new Operator("tree_1", null)},			//Create operator
				"init",													//Function
				null,													//Result
				new int[]{4}											//Size
				);
		
		Command tree_2_init = new Command(
				new Operator[]{	new Operator("tree_2", null)},			//Create operator
				"init",													//Function
				new String[]{"5", "2", "3", "15"},						//Result
				new int[]{4}											//Size
				);
		
		Command array_3_init = new Command(
				new Operator[]{	new Operator("array_3", null)},			//Create operator
				"init",													//Function
				new String[]{"1", "2", "1", "2", "1", "2"},				//Result
				null													//Size
				);
		
		//Do some stuff
		Command read_with_source = new Command(
				new Operator[]{	new Operator("array_1", new String[]{"1"}),	//Create operator 1 (target)
								new Operator("array_2", new String[]{"2"})},//Create operator 2 (source)	
				"read",												    //Function
				new String[]{"2"},										//Result
				null													//Size
				);
		
		Command write_with_source = new Command(
				new Operator[]{	new Operator("array_1", new String[]{"1"}),	//Create operator 1 (target)
								new Operator("array_3", new String[]{"2"})},//Create operator 2 (source)	
				"write",												//Function
				new String[]{"2"},										//Result
				null													//Size
				);
		
		Command write_nosource = new Command(
				new Operator[]{	new Operator("array_3", new String[]{"1"})},//Create operator	
				"write",												//Function
				new String[]{"2"},										//Result
				null													//Size
				);
		
		Command message = new Command(
				null,													//Create operator	
				"message",												//Function
				new String[]{"Tjena!"},									//Result
				null													//Size
				);
		
		Command swap = new Command(
				new Operator[]{
				new Operator("array_1", new String[]{"2"}),				//Create operator 1
				new Operator("array_3", new String[]{"1"})},			//Create operator 2
																		//TODO: Hur representera tempvariabel?
				"swap",													//Function
				new String[]{"array3-1, array1-2"},						//Result - values in operator 1, 2 after completion
				null													//Size
				);
		
		Command[] commands = {array_1_init, array_2_init, tree_1_init, tree_2_init, array_3_init,
				read_with_source, write_with_source, write_nosource, message, swap};
		
		Header header = new Header();
		header.annotatedVariables.put(array_1.id, array_1);
		header.annotatedVariables.put(array_2.id, array_2);
		header.annotatedVariables.put(tree_1.id, tree_1);
		header.annotatedVariables.put(tree_2.id, tree_2);
		header.annotatedVariables.put(array_3.id, array_3);
		
		Command[] body = commands;
		Wrapper testJson = new Wrapper(header, body);
		String jsonString = gson.toJson(testJson);
		
		String outputFileName = "pretty_Test_JSON.json";
		
		//Print
		try (PrintStream out = new PrintStream(new FileOutputStream(R_DESKTOP+outputFileName))) {
		    out.print(jsonString);
		    out.flush();
		    out.close();
		    System.out.println(jsonString.length());
		} catch (FileNotFoundException e) {e.printStackTrace();}
		
		
	}
}
