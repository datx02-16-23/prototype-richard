package wrapper_draft2;

import java.util.Collection;
import java.util.HashMap;

//TODO: vettigt namn
public class Unwrapper {
	private final HashMap<String, AnnotatedVariable> knownVariables;
	
	public Unwrapper(){
		knownVariables = new HashMap<String, AnnotatedVariable>();
	}
	
	public void unwrap (Wrapper wrapper){
		/**
		 * Unwrap header data.
		 */
		if (wrapper.header != null){
			Collection<AnnotatedVariable> collection = wrapper.header.annotatedVariables.values();
			for (AnnotatedVariable av : collection){
				knownVariables.put(av.id, av);
			}
		}
		
		/**
		 * Unwrap body data.
		 */
		if (wrapper.body != null){
			for(int i = 0; i < wrapper.body.length; i++){
				dispatchCommand(wrapper.body[i]);
			}
		}
	}

	public boolean skipUndeclared = true;
	private void dispatchCommand(Command command) {
		if (skipUndeclared && containsUndeclaredVariable(command)){
			return;
		}
		
		switch(command.function){
			case "read":
				read(command.operators, command.result);
				break;
				
			case "write":
				write(command.operators, command.result);
				break;
				
			case "swap":
				swap(command.operators, command.result);
				break;
				
			case "init":
			//case "initialize":
				init(command.operators, command.result);
				break;
				
			default:
				System.out.println("Unknown function name: " + command.function);
		}
	}
	
	private void read(Operator[] operators, String[] result){
		
	}
	
	private void write(Operator[] operators, String[] result){
		
	}
	
	private void swap(Operator[] operators, String[] result){
		
	}
	
	private void init(Operator[] operators, String[] result){
		
	}
	
	private boolean containsUndeclaredVariable(Command command){
		for(int i = 0; i < command.operators.length; i++){
			if(knownVariables.containsKey(command.operators[i].id) == false){
					System.out.println("Undeclared variable with id: \"" + command.operators[i].id + "\" found.");
					return true;
			}
		}
		return false;
	}
}
