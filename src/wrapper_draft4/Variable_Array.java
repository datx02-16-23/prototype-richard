package wrapper_draft4;

import java.util.Arrays;

public class Variable_Array {
	public final String identifier;
	public final int[] index;
	
	public Variable_Array(String id, int[] index){
		this.identifier = id;
		this.index = index;
	}

	@Override
	public String toString() {
		
		return "{\"identifier\":"+identifier+", \"index\": "+Arrays.toString(index)+"}";
	}
	
	
}
