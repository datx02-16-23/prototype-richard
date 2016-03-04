package wrapper_draft1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import operations_interceptor.OIWrapper;

public class Main {
	private static final Gson GSON = new Gson();
	private static final String jsonFileURL = "C:\\Users\\Richard\\Desktop\\test1.json";
	
	private JsonReader jsoReader;
	private FileReader fileReader;
	private Wrapper wrapper;

	public static void main(String[] args) {
		System.out.println("draft 1");
		new Main();
	}
	
	public Main(){
		
		try {
			fileReader = new FileReader(jsonFileURL);
		} catch (FileNotFoundException e) {System.out.println("not found");}
		jsoReader = new JsonReader(fileReader);
		wrapper = GSON.fromJson(jsoReader, Wrapper.class);
		System.out.println(wrapper);
	}


}
