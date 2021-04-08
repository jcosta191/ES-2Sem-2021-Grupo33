/*
 *This class will handle the logical operators chosen by the user and will compare two booleans 
 */
public class LogicalOperators {
	public static final int AND=0;
	public static final int OR=1;
	private int status=-1;
	
	/*
	 * LogicalOperators constructor which defines the comparison mode with number values
	 */
	public LogicalOperators(int op) throws Exception {
		if( op >= 0 && op <=1)
			this.status=op;
		else 
			throw new Exception ("Comparison mode not allowed");
	}
	
	/*
	 * LogicalOperators constructor which defines the comparison mode with a string
	 */
	public LogicalOperators(String op) throws Exception {
		if(op.equalsIgnoreCase("AND"))
			status=0;
		if(op.equalsIgnoreCase("OR"))
			status=1;
		else
			throw new Exception ("Comparison mode not allowed");
	}
	/*
	 * Runs the comparison with the selected mode
	 * Tenho de Confirmar isto!!
	 */
	public boolean comparison(boolean b1, boolean b2) {
		if (status==0)
			return (b1 && b2);
		if (status==1)
			return (b1 || b2);
		return false;
	}
	
	/*
	 * set the current comparison mode.
	 */
	public void setCurrentStatus(int s) {
		this.status=s;
	}
	/*
	 * get the current comparison mode.
	 */
	public int getCurrentStatus() {
		return status;
	}
}
