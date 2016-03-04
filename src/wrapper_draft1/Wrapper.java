package wrapper_draft1;

public class Wrapper {
	public final Header header;
	public final Command[] body;
	
	public Wrapper(Header header, Command[] body){
		this.header = header;
		this.body = body;
	}
}
