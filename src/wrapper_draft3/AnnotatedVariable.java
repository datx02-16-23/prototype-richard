package wrapper_draft3;

import java.util.HashMap;

public class AnnotatedVariable {
	public final String identifier, rawType, abstractType, visual;
	public final HashMap<String, Object> attributes;
	
	public AnnotatedVariable(String identifier, String rawType, String abstractType, String visual){
		this.identifier = identifier;
		this.rawType = rawType;
		this.abstractType = abstractType;
		this.visual = visual;
		this.attributes = new HashMap<String, Object>();
	}
}
