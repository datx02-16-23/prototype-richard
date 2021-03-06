

import java.util.List;

/**
 * Wrapper class for GLO and HOG files on the JSON format.
 */
public class Wrapper {
	/**
	 * Header data for the file. Contains version number and variable declarations.
	 */
	public final Header header;
	/**
	 * Operations contained in this file.
	 */
	public final List<Operation> body;
	
	/**
	 * Create a new Wrapper with the given header and body.
	 * @param header Header data for the file. Contains version number and variable declarations.
	 * @param body Operations contained in this file.
	 */
	public Wrapper(Header header, List<Operation> body){
		this.header = header;
		this.body = body;
	}
}
