package wrapper_draft3;

import java.util.List;

public class Wrapper {
	public final Header header;
	public final List<Operation> body;
	
	public Wrapper(Header header, List<Operation> body){
		this.header = header;
		this.body = body;
	}
}
