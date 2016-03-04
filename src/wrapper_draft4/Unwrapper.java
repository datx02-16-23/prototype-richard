package wrapper_draft4;
//package wrapper_draft3;
//
//import java.util.Collection;
//import java.util.HashMap;
//
////TODO: vettigt namn
//public class Unwrapper {
//	private final HashMap<String, AnnotatedVariable> knownVariables;
//	
//	public Unwrapper(){
//		knownVariables = new HashMap<String, AnnotatedVariable>();
//	}
//	
//	public void unwrap (Wrapper wrapper){
//		/**
//		 * Unwrap header data.
//		 */
//		if (wrapper.header != null){
//			Collection<AnnotatedVariable> collection = wrapper.header.annotatedVariables.values();
//			for (AnnotatedVariable av : collection){
//				knownVariables.put(av.identifier, av);
//			}
//		}
//		
//		/**
//		 * Unwrap body data.
//		 */
//		if (wrapper.body != null){
//			for(int i = 0; i < wrapper.body.length; i++){
//				dispatchCommand(wrapper.body[i]);
//			}
//		}
//	}
//
//	public boolean skipUndeclared = true;
//	private void dispatchCommand(Operation command) {
//		if (skipUndeclared && containsUndeclaredVariable(command)){
//			return;
//		}
//		
//		switch(command.operation){
//			case "read":
//
//				break;
//				
//			case "write":
//
//				break;
//				
//			case "swap":
//
//				break;
//				
//			case "init":
//			case "initialize":
//
//				break;
//				
//			default:
//				System.out.println("Unknown function name: " + command.operation);
//		}
//	}
//	
//	
//	private boolean containsUndeclaredVariable(Operation command){
//		for(int i = 0; i < command.variables.length; i++){
//			if(knownVariables.containsKey(command.variables[i].id) == false){
//					System.out.println("Undeclared variable with id: \"" + command.variables[i].id + "\" found.");
//					return true;
//			}
//		}
//		return false;
//	}
//}
