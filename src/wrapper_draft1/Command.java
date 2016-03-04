package wrapper_draft1;

public class Command {
	public final Actor target, source;
	public final String op;
	public final String value[];
	public final int[] size;
	
	public Command(Actor target, Actor source, String op, String value[], int[] size){
		this.target = target;
		this.source = source;
		this.op = op;
		this.value = value;
		this.size = size;
	}
}
