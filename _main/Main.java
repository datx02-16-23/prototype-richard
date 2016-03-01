package _main;

import operations_interceptor.OI_Reader;
import view.Visualiser;

public class Main {

	public static void main(String[] args) {
			Visualiser vis = new Visualiser();
			new OI_Reader(vis, "C:\\Users\\Richard\\Desktop\\array_test2.json");
	}

}