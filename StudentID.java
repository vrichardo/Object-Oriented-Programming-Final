package projectLab116;

public class StudentID extends ID {
	
	private String degree;//Unique to Student

	public StudentID(String IDtype, String Anum, String Fname, String Lname, int Age,String degree) {
		super(IDtype,  Anum, Fname,  Lname, Age);
		this.degree = degree;
	}
	
	public String getDegree() {
		return degree;
	}
	
	@Override
	public String toString() {
		return super.toString()+","+getDegree();
	}
	
	@Override
	public void Print() {
		System.out.println(this.toString());
	}
	
}
