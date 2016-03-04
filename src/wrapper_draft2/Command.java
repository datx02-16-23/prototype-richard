package wrapper_draft2;

public class Command {
	public final Operator[] operators;
	public final String function;
	public final String result[];
	public final int[] size;
	
	public Command(Operator[] operators, String function, String result[], int[] size){
		this.operators = operators;
		this.function = function;
		this.result = result;
		this.size = size;
	}
}
