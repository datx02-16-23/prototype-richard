package wrapper_draft4;

import java.util.HashMap;

public class OP_Read extends Operation{
	private static final String OPERATION = "read";
	private static final String KEY_DESTINATION = "destination";
	private static final String KEY_SOURCE = "source";
	private static final String KEY_VALUE = "value";

	public OP_Read() {
		super(OPERATION);
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
