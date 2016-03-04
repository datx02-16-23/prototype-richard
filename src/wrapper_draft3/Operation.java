package wrapper_draft3;

import java.util.HashMap;

public class Operation {
	public final String operation;
	public final HashMap<String, Object> operationBody;
	
	public Operation(String operation, HashMap<String, Object> operationBody){
		this.operation = operation;
		this.operationBody = operationBody;
	}
	
	public static String printOperationBody(Operation op){
		StringBuilder builder = new StringBuilder();
		builder.append("{");
		for( String key : op.operationBody.keySet()){
			builder.append("\""+key+"\": "+ op.operationBody.get(key).toString() +",\n");
		}
		builder.delete(builder.length()-2, builder.length());
		builder.append("}");
		return builder.toString();
	}
}
