import java.util.HashMap;

/**
 * Create a new Write operation, from the variable at index specified by {@code source}
 * to the variable at index specified by {@target}. The source may be set null if necessary.
 */
public class OP_Write extends Operation{
	private static final String OPERATION = "write";
	private static final String KEY_TARGET = "target";
	private static final String KEY_SOURCE = "source";
	private static final String KEY_VALUE = "value";

	/**
	 * Create a new Write operation.  Note that you must set the target, source and value.
	 */
	public OP_Write() {
		super(OPERATION, new HashMap<String, Object>());
	}
	
	/**
	 * Set the target variable for this Write operation.
	 * The identifier of the variable should be previously declared in the header.
	 * @param target The target variable for this Write operation.
	 */
	public void setTarget(ArrayVariable target){
		this.operationBody.put(KEY_TARGET, target);
	}
	
	/**
	 * Set the source variable for this Write operation.
	 * The identifier of the variable should be previously declared in the header.
	 * @param source The source variable for this Write operation.
	 */
	public void setSource(ArrayVariable source){
		this.operationBody.put(KEY_SOURCE, source);
	}
	
	/**
	 * Set the value(s) which were written to {@code target} (from {@code source}, if applicable).
	 * @param value Set the value(s) written to {@code target}.
	 */
	public void setValue(String value){
		this.operationBody.put(KEY_VALUE, value);
	}
	
	public ArrayVariable getTarget(){
		return (ArrayVariable)this.operationBody.get(KEY_TARGET);
	}

	public ArrayVariable getSource(){
		return (ArrayVariable)this.operationBody.get(KEY_SOURCE);
	}

	
	public String getValue(){
		return (String)this.operationBody.get(KEY_VALUE);
	}

	@Override
	public String toString() {
		return "{ \"operation\": "+OPERATION+", \"operationBody\":"+Operation.printOperationBody(this)+"}";
	}
	
	

}
