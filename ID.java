package projectLab116;

public abstract class ID implements Print { //ID is abstract because it implements Print which have an abstract method
	protected String idType;
	protected String aNum;
	protected String fName;
	protected String lName;
	protected int age;
	
	
	public ID(String IDtype, String Anum, String Fname, String Lname, int Age) { 
		this.idType=IDtype;
		this.aNum=Anum;
		this.fName=Fname;
		this.lName=Lname;
		this.age=Age;
	}
	
	public String getIDType() {
		return idType;
	}
	
	public String getAnum() {
		return aNum;
	}
	
	public String getFname() {
		return fName;
	}
	
	public String getLname() {
		return lName;
	}

	public int getAge() {
		return age;
	}
	
	public String toString() {
		return idType+","+aNum+","+fName+","+lName+","+age;
	}
	
	
	

}
