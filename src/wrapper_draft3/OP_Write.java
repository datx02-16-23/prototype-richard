package wrapper_draft3;

import java.util.HashMap;

public class OP_Write extends Operation{
	private static final String OPERATION = "write";
	private static final String KEY_DESTINATION = "destination";
	private static final String KEY_SOURCE = "source";
	private static final String KEY_VALUE = "value";

	public OP_Write() {
		super(OPERATION, new HashMap<String, Object>());
	}
	
	public void setDestination(Variable_Array var){
		this.operationBody.put(KEY_DESTINATION, var);
	}
	
	public void setSource(Variable_Array var){
		this.operationBody.put(KEY_SOURCE, var);
	}
	
	public void setValue(String value){
		this.operationBody.put(KEY_VALUE, value);
	}
	
	public Variable_Array getDestination(){
		return (Variable_Array)this.operationBody.get(KEY_DESTINATION);
	}

	public Variable_Array getSource(){
		return (Variable_Array)this.operationBody.get(KEY_SOURCE);
	}

	
	public String getValue(){
		return (String)this.operationBody.get(KEY_VALUE);
	}

	@Override
	public String toString() {
		return "{ \"operation\": "+OPERATION+", \"operationBody\":"+Operation.printOperationBody(this)+"}";
	}
	
	

}
