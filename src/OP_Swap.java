

import java.util.HashMap;

/**
 * Create a new Swap operation, shifting the values of {@code var1} and {@code var2}.
 */
public class OP_Swap extends Operation{
	private static final String OPERATION = "swap";
	private static final String KEY_VAR1 = "var1";
	private static final String KEY_VAR2 = "var2";
	private static final String KEY_VALUE = "value";

	/**
	 * Create a new Swap operation.  Note that you must set var1, var2, and value.
	 */
	public OP_Swap() {
		super(OPERATION, new HashMap<String, Object>());
	}
	
	/**
	 * Set var1 for this Swap operation.
	 * The identifier of the variable should be previously declared in the header.
	 * @param var1 Variable 1 for this Swap operation.
	 */
	public void setVar1(ArrayVariable var1){
		this.operationBody.put(KEY_VAR1, var1);
	}
	
	/**
	 * Set var2 for this Swap operation.
	 * The identifier of the variable should be previously declared in the header.
	 * @param var2 Variable 2 for this Swap operation.
	 */
	public void setVar2(ArrayVariable var2){
		this.operationBody.put(KEY_VAR2, var2);
	}
	
	
	/**
	 * The values contained at var1 and var2 respectively, AFTER this Swap operation has been executed.
	 * @param value The values in var1 and var2 after execution.
	 */
	public void setValue(String values){
		this.operationBody.put(KEY_VALUE, values);
	}
	
	
	
	public ArrayVariable getTarget(){
		return (ArrayVariable)this.operationBody.get(KEY_VAR1);
	}
	public ArrayVariable getSource(){
		return (ArrayVariable)this.operationBody.get(KEY_VAR2);
	}
	public String getValue(){
		return (String)this.operationBody.get(KEY_VALUE);
	}

	@Override
	public String toString() {
		return "{ \"operation\": "+OPERATION+", \"operationBody\":"+Operation.printOperationBody(this)+"}";
	}
	
	

}
