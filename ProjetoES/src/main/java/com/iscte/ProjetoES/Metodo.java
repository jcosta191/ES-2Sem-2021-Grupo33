package com.iscte.ProjetoES;

public class Metodo {
	
	private int methodID;
	private String Package;
	private String Class;
	private String method;
	private int NOM_class;
	private int LOC_class;
	private int WMC_class;
	private boolean is_God_Class;
	private int LOC_method;
	private int CYCLO_method;
	private boolean is_Long_Method;
	
	
	public Metodo(int methodID, String Package, String Class, String method, int NOM_class, int LOC_class, int WMC_class, boolean is_God_Class, int LOC_method, int CYCLO_method, boolean is_Long_Method) {
		this.methodID =methodID;
		this.Package=Package;
		this.Class=Class;
		this.method=method;
		this.NOM_class=NOM_class;
		this.LOC_class=LOC_class;
		this.WMC_class=WMC_class;
		this.is_God_Class=is_God_Class;
		this.LOC_method=LOC_method;
		this.CYCLO_method=CYCLO_method;
	    this.is_Long_Method=is_Long_Method;
		
	}


	public int getMethodID() {
		return methodID;
	}


	public String getPackage() {
		return Package;
	}
	
	
	public String getClasse() {
		return Class;
	}
	
	public String getMethod() {
		return method;
	}


	public int getNOM_class() {
		return NOM_class;
	}


	public int getLOC_class() {
		return LOC_class;
	}


	public int getWMC_class() {
		return WMC_class;
	}

	public int getLOC_method() {
		return LOC_method;
	}


	public int getCYCLO_method() {
		return CYCLO_method;
	}


	public boolean isIs_God_Class() {
		return is_God_Class;
	}


	public boolean isIs_Long_Method() {
		return is_Long_Method;
	}



	

	

}
