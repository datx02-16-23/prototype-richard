package wrapper_draft1;

import java.util.HashMap;

public class Header {
	public final long version;
	public final HashMap<String, AnnotatedVariable> annotatedVariables;
	
	public Header(long version){
		this.version = version;
		annotatedVariables = new HashMap<String, AnnotatedVariable>();
	}
	
	public Header(){
		this.version = 0;
		annotatedVariables = new HashMap<String, AnnotatedVariable>();
	}
}
