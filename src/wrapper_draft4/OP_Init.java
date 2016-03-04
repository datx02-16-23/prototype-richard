package wrapper_draft4;

import java.util.Arrays;
import java.util.HashMap;

public class OP_Init extends Operation{
	private static final String OPERATION = "init";
	private static final String KEY_DESTINATION = "destination";
	private static final String KEY_SIZE = "size";
	private static final String KEY_VALUE = "value";

	public OP_Init() {
		super(OPERATION);
	}
	
	public void setDestination(Variable_Array var){
		this.operationBody.put(KEY_DESTINATION, var);
	}
	
	public void setSize(int [] size){
		this.operationBody.put(KEY_SIZE, size);
	}
	
	public void setValue(String value){
		this.operationBody.put(KEY_VALUE, value);
	}
	
	public Variable_Array getDestination(){
		return (Variable_Array)this.operationBody.get(KEY_DESTINATION);
	}
	
	public int[] getSize(){
		return (int[])this.operationBody.get(KEY_SIZE);
	}
	
	public String getValue(){
		return (String)this.operationBody.get(KEY_VALUE);
	}
	
	public String printBody(){
		StringBuilder builder = new StringBuilder();
		builder.append("{");
		for( String key : operationBody.keySet()){
			builder.append("\""+key+"\": ");
			switch(key){
				case KEY_DESTINATION:
					builder.append(((Variable_Array)operationBody.get(key)).toString() +",\n");
				break;
				case KEY_SIZE:
					builder.append(Arrays.toString((int[])operationBody.get(key))+",\n");
				break;
				case KEY_VALUE:
					builder.append((String)operationBody.get(key) +",\n");
				break;
			}
			 
		}
		builder.delete(builder.length()-2, builder.length());
		builder.append("}");
		return builder.toString();
	}

	@Override
	public String toString() {
		return "{ \"operation\": \""+OPERATION+"\", \"operationBody\":"+printBody()+"}";
	}
	
	

}
