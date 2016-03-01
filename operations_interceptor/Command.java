package operations_interceptor;

public class Command {
	//TODO: Extract command types into separate file.
	public static final String OP_READ = "read";
	public static final String OP_WRITE = "write";
	public static final double VALUE_IGNORED = Double.POSITIVE_INFINITY;

	public final String id;
	public final String op;
	public final int[] index;
	public final double value;
	
	public Command (String id, String operation, int[] index, double value){
		this.id = id;
		this.op = operation;
		this.index = index;
		this.value = value;
	}
	
	public String toString(){
		return super.toString() + ": [id (identifier) = " + id + ", op = " + op + ", index = " + index + ", value = " + value +"]";
	}
}
