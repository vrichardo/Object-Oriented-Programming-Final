package projectLab116;

public class FacultyID extends ID{
	private String department; //Unique to Faculty
	
	public FacultyID(String IDtype, String Anum, String Fname, String Lname, int Age,String department) {
		super(IDtype,  Anum, Fname,  Lname, Age);
		this.department = department;
	}
	
	public String getDepartment() {
		return department;
	}

	
	@Override
	public String toString() {
		return super.toString()+","+getDepartment();
	}
	
	@Override
	public void Print() {
		System.out.println(this.toString());
	}
	
	

}
