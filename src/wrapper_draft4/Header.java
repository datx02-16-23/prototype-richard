package wrapper_draft4;

import java.util.HashMap;

public class Header {
	public static final int VERSION_UNKNOWN = 0;
	
	public final int version;
	public final HashMap<String, AnnotatedVariable> annotatedVariables;
	
	public Header(int version, HashMap<String, AnnotatedVariable> annotatedVariables){
		this.version = version;
		this.annotatedVariables = annotatedVariables;
	}
	
	public Header(){
		this.version = VERSION_UNKNOWN;
		annotatedVariables = new HashMap<String, AnnotatedVariable>();
	}
}
