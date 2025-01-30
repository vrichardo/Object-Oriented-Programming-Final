package projectLab116;

public class StaffID extends ID{
	
	private int salary; //unique to Staff

	public StaffID(String IDtype, String Anum, String Fname, String Lname, int Age,int Salary) {
		super(IDtype,  Anum, Fname,  Lname, Age);
		this.salary=Salary;
	}
	
	public int getSalary() {
		return salary;
	}

	

	@Override
	public String toString() {
		return super.toString()+","+getSalary();
	}
	
	@Override
	public void Print() {
		System.out.println(this.toString());
	}
	
	

}
