package wrapper_draft2;

public class AnnotatedVariable {
	public final String id, type, visual;
	public final int[] maxSize;
	
	public AnnotatedVariable(String id, String type, int[] maxSize, String visual){
		this.id = id;
		this.type = type;
		this.maxSize = maxSize;
		this.visual = visual;
	}
}
