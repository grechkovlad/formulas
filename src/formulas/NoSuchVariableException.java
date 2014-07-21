package formulas;

public class NoSuchVariableException extends RuntimeException {

	private static final long serialVersionUID = 44735325165791500L;

	public NoSuchVariableException(String name) {
		super(name);
	}
	
}
