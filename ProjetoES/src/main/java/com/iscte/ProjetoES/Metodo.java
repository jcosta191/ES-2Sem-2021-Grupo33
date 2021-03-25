package com.iscte.ProjetoES;

public class Metodo {
	
	private int methodID;
	private String Package;
	private String Class;
	private String method;
	private int NOM_class;
	private int LOC_class;
	private int WMC_class;
	private int LOC_method;
	private int CYCLO_method;
	
	
	public Metodo(int methodID, String Package, String Class, String method, int NOM_class, int LOC_class, int WMC_class, int LOC_method, int CYCLO_method) {
		this.setMethodID(methodID);
		this.setPackage(Package);
		this.setClass(Class);
		this.setMethod(method);
		this.setNOM_class(NOM_class);
		this.setLOC_class(LOC_class);
		this.setWMC_class(WMC_class);
		this.setLOC_method(LOC_method);
		this.setCYCLO_method(CYCLO_method);
		
	}


	public int getMethodID() {
		return methodID;
	}


	public void setMethodID(int methodID) {
		this.methodID = methodID;
	}


	public String getPackage() {
		return Package;
	}


	public void setPackage(String package1) {
		Package = package1;
	}


	public String getClasse() {
		return Class;
	}


	public void setClass(String class1) {
		Class = class1;
	}


	public String getMethod() {
		return method;
	}


	public void setMethod(String method) {
		this.method = method;
	}


	public int getNOM_class() {
		return NOM_class;
	}


	public void setNOM_class(int nOM_class) {
		NOM_class = nOM_class;
	}


	public int getWMC_class() {
		return WMC_class;
	}


	public void setWMC_class(int wMC_class) {
		WMC_class = wMC_class;
	}


	public int getLOC_class() {
		return LOC_class;
	}


	public void setLOC_class(int lOC_class) {
		LOC_class = lOC_class;
	}


	public int getLOC_method() {
		return LOC_method;
	}


	public void setLOC_method(int lOC_method) {
		LOC_method = lOC_method;
	}


	public int getCYCLO_method() {
		return CYCLO_method;
	}


	public void setCYCLO_method(int cYCLO_method) {
		CYCLO_method = cYCLO_method;
	}
}

