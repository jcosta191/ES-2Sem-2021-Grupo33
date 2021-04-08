
//Classe que receberá uma regra com thresholds e um determinado modo.

public class Rule {
	
	private String ruleName;
	private int mode= -1;
	private int limit1;
	private int limit2;
	public LogicalOperators lop;

	
	
	/*
	 * This constructor create a rule using rule.featureEnvy or rule.longMethod in the mode parameter
	 */
	public Rule(String ruleName, int limit1, int limit2, LogicalOperators lop, int mode) {
		this.ruleName=ruleName;
		this.limit1=limit1;
		this.limit2=limit2;
		this.lop=lop;
		this.mode=mode;
	}
	
	public String getName() {
		return ruleName;
	}
	
	public void setName(String name) {
		this.ruleName = name;
	}
	
	
	public void setLimit1(int limit1) {
		limit1 = this.limit1;
	}
	
	public void setLimit2(int limit2) {
		limit2 = this.limit2;
	}
	
	public int getLimit1() {
		return this.limit1;
	}
	
	public int getLimit2() {
		return this.limit2;
	}
	
	public String getMode() {
		if(mode==0) 
			return "Feature Envy";
		return "Long Method";
	}
	
	public void setMode(int mode) {
		this.mode = mode;
	}
	
}
