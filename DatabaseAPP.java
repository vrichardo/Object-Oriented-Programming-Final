package projectLab116;
import java.util.*;

public class DatabaseAPP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Database database = new Database();
		Scanner userInput = new Scanner(System.in); //scanner for user input
		
		boolean bool = true; //boolean value used to activate loop so people can return to main menu
		
		System.out.println("ID DATABASE SYSTEM"+"\n"+"\n");
		
		try {
		
		while(bool) {
			
			System.out.println("1) ADD"+"\n"+"2) REMOVE"+"\n"+"3) SHOW"+"\n"+"4) Save"+"\n"+"*please enter the number assign to selected option*"+"\n");
			bool = false; //set bool to false so loop only run once
			int mms = userInput.nextInt();
			
				switch(mms) { //switch case 1
				
					case 1:
						System.out.println("How would you like to ADD IDs"+"\n"+"\n"+"1) Individualy"+"\n"+"2) Bulk");
						int ams = userInput.nextInt();
						switch(ams) { //switch add
						
							case 1:
								try {
								System.out.println("Please enter ID type. (S,T,F)");
								userInput.nextLine();//uses because scanner will for some reason skip a line so it will skip this one instead of the one we are using 
								
								String idType = userInput.nextLine();
								
								
								
								if(!idType.equals("T")&&!idType.equals("S")&&!idType.equals("F")) {
									throw new Unusable();
									
								}
								
								
								System.out.println("Please enter your A-number");
								String aNUM = userInput.nextLine();
								
								
								System.out.println("Please enter your first name");
								String fName = userInput.nextLine();
								
						
								System.out.println("Please enter your last name");
								String lName = userInput.nextLine();
								
								
								System.out.println("Please enter your age");
								int age = userInput.nextInt();
								
								
								switch(idType) {
								case "S":
								System.out.println("What is your degree");	
								userInput.nextLine();//uses because scanner will for some reason skip a line so it will skip this one instead of the one we are using 

								String degree = userInput.nextLine();
								
								if(aNUM.equals(null)||aNUM.isEmpty()||fName.isEmpty()||fName.equals(null)||lName.isEmpty()||lName.equals(null)||age<0||degree.equals(null)||degree.isEmpty()) {
									throw new Unusable();
								}
								
								for (ID id :database.idDatabase) {
									if(aNUM.equals(id.getAnum())) {
										throw new Unusable();
									}
								}
								
								ID stuID = new StudentID(idType,aNUM,fName,lName,age,degree);
								database.add(stuID);
								
								System.out.println("Would you like to save?"+"\n"+"1) yes"+"\n"+"2) no");
								int se = userInput.nextInt();
								switch(se) {
								case 1:
									database.save();
									
									System.out.println("Would you like to go back to the main menu?"+"\n"+"1) yes "+"\n"+"2) no");
									int gd = userInput.nextInt();
									switch(gd) {
									case 1:
										bool = true;
										break;
									case 2:
										System.out.println("Thank you for using our database");
										break;
									default:
										System.out.println("Thank you for using our database");
										break;
									}
									
									break;
								case 2:
									System.out.println("Would you like to go back to the main menu?"+"\n"+"1) yes "+"\n"+"2) no");
									int gd3 = userInput.nextInt();
									switch(gd3) {
									case 1:
										bool = true;
										break;
									case 2:
										System.out.println("Thank you for using our database");
										break;
									default:
										System.out.println("Thank you for using our database");
										break;
									}
								
									break;
								default:
									System.out.println("Would you like to go back to the main menu?"+"\n"+"1) yes "+"\n"+"2) no");
									int gd1 = userInput.nextInt();
									switch(gd1) {
									case 1:
										bool = true;
										break;
									case 2:
										System.out.println("Thank you for using our database");
										break;
									default:
										System.out.println("Thank you for using our database");
										break;
									}
								break;
								}
								
								break;
								case "F":
								System.out.println("What is your department");
								userInput.nextLine();//uses because scanner will for some reason skip a line so it will skip this one instead of the one we are using 

								String department = userInput.nextLine();
								
								if(aNUM.equals(null)||aNUM.isEmpty()||fName.isEmpty()||fName.equals(null)||lName.isEmpty()||lName.equals(null)||age<0||department.equals(null)||department.isEmpty()) {
									throw new Unusable();
								}
								
								for (ID id :database.idDatabase) {
									if(aNUM.equals(id.getAnum())) {
										throw new Unusable();
									}
								}
								
								ID facID = new FacultyID(idType,aNUM,fName,lName,age,department);
								database.add(facID);
								
								System.out.println("Would you like to save?"+"\n"+"1) yes"+"\n"+"2) no");
								int gd = userInput.nextInt();
								
								switch(gd) {
								case 1:
									
									database.save();
									System.out.println("Would you like to go back to the main menu?"+"\n"+"1) yes "+"\n"+"2) no");
									int gd5 = userInput.nextInt();
									switch(gd5) {
									case 1:
										bool = true;
										break;
									case 2:
										System.out.println("Thank you for using our database");
										break;
									default:
										System.out.println("Thank you for using our database");
										break;
									}
									break;
								case 2:
									System.out.println("Would you like to go back to the main menu?"+"\n"+"1) yes "+"\n"+"2) no");
									int gdg= userInput.nextInt();
									switch(gdg) {
									case 1:
										bool = true;
										break;
									case 2:
										System.out.println("Thank you for using our database");
										break;
									default:
										System.out.println("Thank you for using our database");
										break;
									}
								
									break;
								default:
									System.out.println("Would you like to go back to the main menu?"+"\n"+"1) yes "+"\n"+"2) no");
									int gdd = userInput.nextInt();
									switch(gdd) {
									case 1:
										bool = true;
										break; 
									case 2:
										System.out.println("Thank you for using our database");
										break;
									}
							
								break;
								}
								
								break;	
								case "T":
								System.out.println("Enter your salary");
								int pay = userInput.nextInt();
								
								if(aNUM.equals(null)||aNUM.isEmpty()||fName.isEmpty()||fName.equals(null)||lName.isEmpty()||lName.equals(null)||age<0||pay<0) {
									throw new Unusable();
								}
								
								for (ID id :database.idDatabase) {
									if(aNUM.equals(id.getAnum())) {
										throw new Unusable();
									}
								}
								
								ID staffID = new StaffID(idType,aNUM,fName,lName,age,pay);
								database.add(staffID);
								
								System.out.println("Would you like to save?"+"\n"+"1) yes"+"\n"+"2) no");
								int sd = userInput.nextInt();
								switch(sd) {
								case 1:
									database.save();
									System.out.println("Would you like to go back to the main menu?"+"\n"+"1) yes "+"\n"+"2) no");
									int de = userInput.nextInt();
									switch(de) {
									case 1:
										bool = true;
										break;
									case 2:
										System.out.println("Thank you for using our database");
										break;
									default:
										System.out.println("Thank you for using our database");
										break;
									}
									
									break;
								case 2:
									System.out.println("Would you like to go back to the main menu?"+"\n"+"1) yes "+"\n"+"2) no");
									int gda = userInput.nextInt();
									switch(gda) {
									case 1:
										bool = true;
										break;
									case 2:
										System.out.println("Thank you for using our database");
										break;
									default:
										System.out.println("Thank you for using our database");
										break;
									}
								
									break;
								default:
									System.out.println("Would you like to go back to the main menu?"+"\n"+"1) yes "+"\n"+"2) no");
									int gdr = userInput.nextInt();
									switch(gdr) {
									case 1:
										bool = true;
										break;
									case 2:
										System.out.println("Thank you for using our database");
										break;
									default:
										System.out.println("Thank you for using our database");
										break;
									}
								break;
								}
								
								break;
								default:
								throw new Unusable();
								
								
								
								}
								
								
							
								
								
								
								
								}catch(NullPointerException npe) {
									System.out.println("ERROR");
								}catch(InputMismatchException ime) {
									System.out.println("ERROR");
								}catch(Unusable unu) {
									System.out.println("ERROR");
								}
								
								break;
							case 2: //add by bulk
								System.out.println("Enter the file name");
								try {
									userInput.nextLine();//uses because scanner will for some reason skip a line so it will skip this one instead of the one we are using 
									
									String file = userInput.nextLine();//scan user input for file name 
									database.add(file);//use add method to input file to database arraylist

									System.out.println("Would you like to save?"+"\n"+"1) yes"+"\n"+"2) no");
									int yn = userInput.nextInt();
									
									switch(yn){
									case 1:
										
										database.save();
										System.out.println("Would you like to go back to the main menu?"+"\n"+"1) yes "+"\n"+"2) no");
										int gd = userInput.nextInt();
										switch(gd) {
										case 1:
											bool = true;
											break;
										case 2:
											System.out.println("Thank you for using our database");
											break;
										default:
											System.out.println("Thank you for using our database");
											break;
										}
										
										break;
									case 2:
										System.out.println("Would you like to go back to the main menu?"+"\n"+"1) yes "+"\n"+"2) no");
										int gd3 = userInput.nextInt();
										switch(gd3) {
										case 1:
											bool = true;
											break;
										case 2:
											System.out.println("Thank you for using our database");
											break;
										default:
											System.out.println("Thank you for using our database");
											break;
										}
									
										break;
									default:
										System.out.println("Would you like to go back to the main menu?"+"\n"+"1) yes "+"\n"+"2) no");
										int gd7 = userInput.nextInt();
										switch(gd7) {
										case 1:
											bool = true;
											break;
										case 2:
											System.out.println("Thank you for using our database");
											break;
										default:
											System.out.println("Thank you for using our database");
											break;	
										}
									break;
									}
									
									

									
								}catch(NullPointerException nully) {
									System.out.println("Error: Null value found");
								}catch(InputMismatchException inputty) {
									System.out.println("Error: Input mismatch found");
								}
							
								
								
								
								
								break;
							default:
								System.out.println("Enter 1 or 2");
								break;
						
						}//switch add
						break;
						
						
					case 2: //remove
						System.out.println("Enter A-Number or last name of ID(s) you would like to remove");
						try {
						
						userInput.nextLine();//uses because scanner will for some reason skip a line so it will skip this one instead of the one we are using 
	
						String input34 = userInput.nextLine();
						database.remove(input34);
						
						System.out.println("Would you like to save?"+"\n"+"1) yes"+"\n"+"2) no");
						int yn = userInput.nextInt();
						switch(yn) {
						case 1:
							
							database.save();
							System.out.println("Would you like to go back to the main menu?"+"\n"+"1) yes "+"\n"+"2) no");
							int gd = userInput.nextInt();
							switch(gd) {
							case 1:
								bool = true;
								break;
							case 2:
								System.out.println("Thank you for using our database");
								break;
							default:
								System.out.println("Thank you for using our database");
								break;
							}
							
							break;
						case 2:
							System.out.println("Would you like to go back to the main menu?"+"\n"+"1) yes "+"\n"+"2) no");
							int gdq = userInput.nextInt();
							switch(gdq) {
							case 1:
								bool = true;
								break;
							case 2:
								System.out.println("Thank you for using our database");
								break;
							default:
								System.out.println("Thank you for using our database");
								break;
							}
						
							break;
						default:
							System.out.println("Would you like to go back to the main menu?"+"\n"+"1) yes "+"\n"+"2) no");
							int gds= userInput.nextInt();
							switch(gds) {
							case 1:
								bool = true;
								break;
							case 2:
								System.out.println("Thank you for using our database");
								break;
							default:
								System.out.println("Thank you for using our database");
								break;
							}
						break;
						
						}
						
						
						}catch(InputMismatchException ipm) {
							System.out.println("Error: Input mismatch found");
						}catch(NullPointerException nme) {
							System.out.println("Error: Null Value Found");
						}
						break;
					
					case 3://show
						System.out.println("How would you like to view the database"+"\n"+"\n"+"1) View all IDs"+"\n"+"2) View IDs of a specific type"+"\n"+"3) View IDs with age greater then the given age");
						int vms = userInput.nextInt();
						
						switch(vms) { //switch case 2
						
							case 1://show all
								System.out.println("Show all ID");
								database.show();
								
								System.out.println("\n"+"Would you like to go back to the main menu?"+"\n"+"1) yes "+"\n"+"2) no");
								int gd = userInput.nextInt();
								switch(gd) {
								case 1:
									bool = true;
									break;
								case 2:
									System.out.println("Thank you for using our database");
									break;
								default:
									System.out.println("Thank you for using our database");
									break;
									
								}
								
								break;
							case 2://show types
								System.out.println("Enter an ID type");
								try {
									userInput.nextLine();//uses because scanner will for some reason skip a line so it will skip this one instead of the one we are using 
									String type = userInput.nextLine();
									database.show(type);
								

									System.out.println("\n"+"Would you like to go back to the main menu?"+"\n"+"1) yes "+"\n"+"2) no");
									int gd2 = userInput.nextInt();
									switch(gd2) {
									case 1:
										bool = true;
										break;
									case 2:
										System.out.println("Thank you for using our database");
										break;
									default:
										System.out.println("Thank you for using our database");
										break;
									}
									
									
								}catch(NullPointerException nulpu) {
									System.out.println("Error: Null value found");
								}catch(InputMismatchException inputmis) {
									System.out.println("Error: Input mismatch found");
								}
								
								
								break;
							case 3://show 
								System.out.println("Enter age ");
								try {
									userInput.nextLine();//uses because scanner will for some reason skip a line so it will skip this one instead of the one we are using 
									int type2 = userInput.nextInt();
									database.show(type2);
								

									System.out.println("\n"+"Would you like to go back to the main menu?"+"\n"+"1) yes "+"\n"+"2) no");
									int gda = userInput.nextInt();
									switch(gda) {
									case 1:
										bool = true;
										break;
									case 2:
										System.out.println("Thank you for using our database");
										break;
									default:
										System.out.println("Thank you for using our database");
										break;
									}
									
								}catch(NullPointerException nulpu) {
									System.out.println("Error: Null value found");
								}catch(InputMismatchException inputmis) {
									System.out.println("Error: Input mismatch found");
								}
								
								
								
								break;	
							default:
								System.out.println("please enter the vale from 1-3");
								break;
								}//switch case 2
						
						break;
						
					case 4:
						database.save();
						System.out.println("Would you like to go back to the main menu?"+"\n"+"1) yes "+"\n"+"2) no");
						int gd = userInput.nextInt();
						switch(gd) {
						case 1:
							bool = true;
							break;
						case 2:
							System.out.println("Thank you for using our database");
							break;
						default:
							System.out.println("Thank you for using our database");
							break;
						}
						break;
					default:
						System.out.println("Enter value from 1-4");
						break;
				}//switch case 1
			}//while loop
		}catch(InputMismatchException s){
			System.out.println("Error:Input mismatch");
		}//try catch
		
	}//main
}//class
