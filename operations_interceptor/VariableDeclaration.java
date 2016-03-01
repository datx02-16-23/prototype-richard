package operations_interceptor;

/**
 * Wrapper class for data structure declarations received when parsing a JSon.
 * @author Richard
 *
 */
public class VariableDeclaration {
	public final String identifier, type, visual;
	
	public VariableDeclaration(String identifier, String type, String visual){
		this.identifier = identifier;
		this.type = type;
		this.visual = visual;
	}
	
	public String toString() {
		return super.toString() + ": [identifier = " + identifier + ", type = " + type + ", visual = " + visual +"]";
	}
}
