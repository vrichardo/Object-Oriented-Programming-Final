package projectLab116;
import java.io.*;
import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;


public class Database {

	
	ArrayList<ID> idDatabase = new ArrayList<ID>();//ArrayList to hold object of ID
	
	public void add(ID id) { //Add method Adds IDs to the ArrayList and catch if ID is null
		try {
		idDatabase.add(id);
		}catch(NullPointerException nulpoint) {
			System.out.println("Error: ID null");
		}
	}
	
	public void add(String s) {// Adds given a file,scanner will scan file and add them to the arraylist
		
		try {
			File file = new File("src/" + s); //Scanner to find file in src(file folder)
			Scanner scan = new Scanner(file); //scanner scanning from file
			
			String [] afterSplit =null; //array used to hold variables of ID temporarily
			String idType=null; 
			String aNum=null; 
			String fName=null; 
			String lName=null; 
			int age=0;
			String degree = null;
			String department = null;
			int salary = 0;
		
			while(scan.hasNextLine()) {//will iterate if file has another line
				
				try {
					String myLine = scan.nextLine();
					afterSplit = myLine.split(",");
					if(afterSplit.length ==6) { //length must be 6 because each ID class have 6 variable
						if(afterSplit[0].equals("T")||afterSplit[0].equals("S")||afterSplit[0].equals("F")) {//ID type can only be T,S,F
							idType = afterSplit[0];
						}else {
						throw new Unusable();
						}
							switch(idType) {//using switch cases to check data after split and create IDs base on iD Types
							
							case "T":
								if(afterSplit[1].equals(null)||afterSplit[1].isEmpty()||afterSplit[2].isEmpty()||afterSplit[2].equals(null)||afterSplit[3].isEmpty()||afterSplit[3].equals(null)||Integer.parseInt(afterSplit[4])<0||Integer.parseInt(afterSplit[5])<0) {
									throw new Unusable();
								}
								
								for (ID id :idDatabase) {
									if(afterSplit[1].equals(id.getAnum())) {
										throw new Unusable();
									}
									}
								
									aNum=afterSplit[1]; 
									fName=afterSplit[2]; 
									lName=afterSplit[3]; 
									age=Integer.parseInt(afterSplit[4]);
									salary =Integer.parseInt(afterSplit[5]);
									
									ID staffId = new StaffID(idType,aNum,fName,lName,age,salary);
									idDatabase.add(staffId);
									
							
								break;
							case "S":
								if(afterSplit[1].equals(null)||afterSplit[1].isEmpty()||afterSplit[2].isEmpty()||afterSplit[2].equals(null)||afterSplit[3].isEmpty()||afterSplit[3].equals(null)||Integer.parseInt(afterSplit[4])<0||afterSplit[5].isEmpty()||afterSplit[5].equals(null)) {
									throw new Unusable();
								}
								
								for (ID id :idDatabase) {
									if(afterSplit[1].equals(id.getAnum())) {
										throw new Unusable();
									}
									}
								
									aNum=afterSplit[1]; 
									fName=afterSplit[2]; 
									lName=afterSplit[3]; 
									age=Integer.parseInt(afterSplit[4]);
									degree = afterSplit[5];
									
									ID stuId = new StudentID(idType,aNum,fName,lName,age,degree);
									idDatabase.add(stuId);
								
								
								break;
							case "F":
								if(afterSplit[1].equals(null)||afterSplit[1].isEmpty()||afterSplit[2].isEmpty()||afterSplit[2].equals(null)||afterSplit[3].isEmpty()||afterSplit[3].equals(null)||Integer.parseInt(afterSplit[4])<0||afterSplit[5].isEmpty()||afterSplit[5].equals(null)) {
									throw new Unusable();
								}
								
								for (ID id :idDatabase) {
									if(afterSplit[1].equals(id.getAnum())) {
										throw new Unusable();
									}
									}
								
									aNum=afterSplit[1]; 
									fName=afterSplit[2]; 
									lName=afterSplit[3]; 
									age=Integer.parseInt(afterSplit[4]);
									department = afterSplit[5];
									
									ID faculty = new FacultyID(idType,aNum,fName,lName,age,department);
									idDatabase.add(faculty);
								
									
								
							
								break;
							
							}
						
						
						
						
					}else {
						throw new Unusable();
					}
				
					
			}catch(Unusable una) {
			
			System.out.println("Error:ID is unusable");	
				
				
			}catch(NumberFormatException nfe) {
				
				System.out.println("Error:ID is unusable");	
				
				
				}
			}
		
		}catch(FileNotFoundException fnfe) {
			System.out.println("File not found");
		}
		}
		
	
	public void remove(String x) {
		try {
		for (int i = 0; i < idDatabase.size(); i++){
			if(x.equals(idDatabase.get(i).getAnum())||x.equals(idDatabase.get(i).getLname())){
				idDatabase.remove(i);
				System.out.println("ID(s) was succesfully removed");
		
		}else {
			throw new Unusable();
		}
		
		}
	
	}catch(Unusable unsu) {
		System.out.println("ID not found");
	}
		
	}
	
	public void show() {
		for (ID id :idDatabase) {
		id.Print();
		}
	}
	
	public void show(String type) {
		try {
			if(!type.equals("S")&&!type.equals("F")&&!type.equals("T")) {
				throw new Unusable();
			}
		for(ID id: idDatabase) {
            if(id.getIDType().equals(type)) {
                id.Print();
            }
		}
		}catch(Unusable unuse) {
			System.out.println("Error: invalid ID Type.   (S,F,T)");
		}
	}
	
	public void show(int age) {
		try {
			if(age<0) {
				throw new Unusable();
			}
        for(ID id: idDatabase) {
            if(id.getAge()> age){
                id.Print();
            }
        }
	}catch(Unusable un) {
		System.out.println("Error: invalid age");
	}catch(InputMismatchException ime) {
		System.out.println("Error: input mismatch");
	}
    }

	
	public void save() {
        try{
            LocalDateTime date = LocalDateTime.now();
            DateTimeFormatter myFormatDate = DateTimeFormatter.ofPattern("MM_dd_yyyy_HH_mmSS");
            String savedFileName = "DATABASE" + date.format(myFormatDate)+".csv";

            File newFile = new File("src/"+savedFileName);
            FileOutputStream fos = new FileOutputStream(newFile, true);
            PrintWriter pw = new PrintWriter(fos);

            for(int i=0; i<idDatabase.size(); i++) {
                pw.println(idDatabase.get(i));
            }

            pw.close();
            System.out.println("New file saved successfully!");
        }catch (FileNotFoundException e) {
            System.out.println("No file found!");
        }
    }



}
