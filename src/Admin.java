
import java.util.*;
import java.io.*;
/** 
 * Class Admin that extending the Employee
 * @version 2.1
*/
public class Admin extends Employee {
	private static Admin admin = null;
	public Admin() {
		super();
	}
	
	public Admin(String name) {
		super(name);
	}
	public Admin(String name, String surname) {
		super(name,surname);
	}
	public Admin(String name, String surname, double salary) {
		super(name,surname,salary);
	}
	public static Admin getInstance() {
		if(admin == null) {
			admin = new Admin();
		}
		return admin;
	}
	/** 
	 * addUser method to adding the user
	 * @version 2.1
	*/
	public void addUser(BufferedReader br) throws IOException {
		System.out.println("Who do you want to add?\n");
		System.out.println("1:Student\n2:Teacher\n3:Manager\n4:Librarian");
		String obj = br.readLine();
		if(obj.equalsIgnoreCase("Student")) {
			Student s = Student.createNewStudent(br);
			University.addUser(s);
		}
		else if(obj.equalsIgnoreCase("Teacher")) {
			Teacher t = Teacher.createNewTeacher(br);
			University.addUser(t);
		}
		else if(obj.equalsIgnoreCase("Manager")) {
			Manager m = Manager.createNewManager(br);
			University.addUser(m);
		}
		else if(obj.equalsIgnoreCase("Librarian")) {
			Librarian l = Librarian.createNewLibrarian(br);
			University.addUser(l);
		}
		
	}
	public void removeUser(BufferedReader br) throws IOException{
		System.out.println("Who do you want to remove?");
		System.out.println("1:Student\n2:Teacher\n3:Manager\n4:Librarian");
		String obj = br.readLine();
		 Vector<User> newUsers = University.getUsers();
		if(obj.equalsIgnoreCase("Student")) {
			System.out.println("Write mail of student:");
			String mail = br.readLine();
			for(User u : newUsers) {
				if(u instanceof Student) {
					Student s = (Student)u;
					if(s.getMail().equalsIgnoreCase(mail)) {
						newUsers.remove(u);
						University.setUsers(newUsers);
						return;
					}
				}
			}
			System.out.println("Student does not exist!");
			return;
		}else if(obj.equalsIgnoreCase("Teacher")) {
			System.out.println("Write mail of teacher:");
			String mail = br.readLine();
			for(User u : newUsers) {
				if(u instanceof Teacher) {
					Teacher t = (Teacher)u;
					if(t.getMail().equalsIgnoreCase(mail)) {
						newUsers.remove(u);
						University.setUsers(newUsers);
						return;
					}
				}
			}
			System.out.println("Teacher does not exist!");
			return;
		}else if(obj.equalsIgnoreCase("Manager")) {
			System.out.println("Write email of manager:");
			String mail = br.readLine();
			for(User u : newUsers) {
				if(u instanceof Manager) {
					Manager m = (Manager)u;
					if(m.getMail().equalsIgnoreCase(mail)) {
						newUsers.remove(u);
						University.setUsers(newUsers);
						return;
					}
				}
			}
			System.out.println("Manager does not exist!");
			return;
		}
		else if(obj.equalsIgnoreCase("Librarian")) {
			System.out.println("Write email of librarian:");
			String mail = br.readLine();
			for(User u : newUsers) {
				if(u instanceof Librarian) {
					Librarian l = (Librarian)u;
					if(l.getMail().equalsIgnoreCase(mail)) {
						newUsers.remove(u);
						University.setUsers(newUsers);
						return;
					}
				}
			}
			System.out.println("Librarian does not exist!");
			return;
		}
	}
	/** 
	 * method update that will update the User
	 * @version 2.1
	*/
	public void updateUser(BufferedReader br) throws IOException {
		System.out.println("Who do you want to update?");
		System.out.println("1:Student\n2:Teacher\n3:Manager\n4:Librarian");
		String obj = br.readLine();
		 Vector<User> newUsers = University.getUsers();
		if(obj.equalsIgnoreCase("Student")) {
			System.out.println("Write email of student:");
			String mail = br.readLine();
			for(User u : newUsers) {
				if(u instanceof Student) {
					Student s = (Student)u;
					if(s.getMail().equalsIgnoreCase(mail)) {
						System.out.println("What do you want to change in student?");
						System.out.println("1:Name\n2:Surname\n3:Id\n4:Faculty\n");
						int command = Integer.parseInt(br.readLine());
						if(command == 1) {
							System.out.println("Write new name for student: ");
							String newName = br.readLine();
							s.setName(newName);
							s.constructMail();
							University.setUsers(newUsers);
							return;
							
						}else if(command == 2) {
							System.out.println("Write new surname for student: ");
							String newSurname = br.readLine();
							s.setSurname(newSurname);
							s.constructMail();
							return;
							
						}else if(command == 3) {
							System.out.println("Write new id for student: ");
							String newId = br.readLine();
							s.setId(newId);
							s.constructId();
							return;
							
						}else {
							System.out.println("Write new faculty for student");
							String faculty = br.readLine();
							if(faculty.equalsIgnoreCase("FIT")) {
								s.setFaculty(Faculty.FIT);
							}else if(faculty.equalsIgnoreCase("BS")) {
								s.setFaculty(Faculty.BS);
							}else if(faculty.equalsIgnoreCase("FEOGI")) {
								s.setFaculty(Faculty.FEOGI);
							}else if(faculty.equalsIgnoreCase("FGE")) {
								s.setFaculty(Faculty.FGE);
							}else if(faculty.equalsIgnoreCase("SCE")) {
								s.setFaculty(Faculty.SCE);
							}else if(faculty.equalsIgnoreCase("ISE")) {
								s.setFaculty(Faculty.ISE);
							}else if(faculty.equalsIgnoreCase("KMA")) {
								s.setFaculty(Faculty.KMA);
							}else {
								s.setFaculty(Faculty.SMC);
							}
							return;
							
						}
						
						
						
					}
				}
//				University.setUsers(newUsers);
//				for(User user : newUsers) {
//					user.printInfo();
//				}
			}
			
			System.out.println("Student does not exist!");
			return;
		}
		else if(obj.equalsIgnoreCase("Teacher")) {
			System.out.println("Write email of teacher:");
			String mail = br.readLine();
			for(User u : newUsers) {
				if(u instanceof Teacher) {
					Teacher t = (Teacher)u;
					if(t.getMail().equalsIgnoreCase(mail)) {
						System.out.println("What do you want to change in teacher?");
						System.out.println("1:Name\n2:Surname\n3:Salary\n");
						int command = Integer.parseInt(br.readLine());
						if(command == 1) {
							System.out.println("Write new name for teacher: ");
							String newName = br.readLine();
							t.setName(newName);
							t.constructMail();
							return;
						}else if(command == 2) {
							System.out.println("Write new surname for teacher: ");
							String newSurname = br.readLine();
							t.setSurname(newSurname);
							t.constructMail();
							return;
						}else if(command == 3) {
							System.out.println("Write new salary for teacher: ");
							double newSalary = Double.parseDouble(br.readLine());
							t.setSalary(newSalary);
							return;
						}
					}
				}
			}
			System.out.println("Teacher does not exist!");
			return;
		}
		else if(obj.equalsIgnoreCase("Manager")) {
			System.out.println("Write email of manager:");
			String mail = br.readLine();
			for(User u : newUsers) {
				if(u instanceof Manager) {
					Manager m = (Manager)u;
					if(m.getMail().equalsIgnoreCase(mail)) {
						System.out.println("What do you want to change in manager?");
						System.out.println("1:Name\n2:Surname\n3:Salary\n4:Type\n");
						int command = Integer.parseInt(br.readLine());
						if(command == 1) {
							System.out.println("Write new name for manager: ");
							String newName = br.readLine();
							m.setName(newName);
							m.constructMail();
							return;
						}else if(command == 2) {
							System.out.println("Write new surname for manager: ");
							String newSurname = br.readLine();
							m.setSurname(newSurname);
							m.constructMail();
							return;
						}else if(command == 3) {
							System.out.println("Write new salary for manager: ");
							double newSalary = Double.parseDouble(br.readLine());
							m.setSalary(newSalary);
							return;
						}else {
							System.out.println("Write new type for manager: ");
							String type = br.readLine();
							if(type.equalsIgnoreCase("OR")) {
								if(m.getType().equals(Type.OR)) {
									System.out.println("Manager already of OR type!");
									return;
								}else {
									m.setType(Type.DEPARTAMENT);
									return;
								}
							}
							else {
								if(m.getType().equals(Type.DEPARTAMENT)) {
									System.out.println("Manager already of DEPARTAMENT type!");
									return;
								}else {
									m.setType(Type.OR);
									return;
								}
							}
						}
					}
				}
			}
			System.out.println("Manager does not exist!");
			return;
		}
		else if(obj.equalsIgnoreCase("Librarian")) {
			System.out.println("Enter librarian email:");
			String mail = br.readLine();
			for(User u : newUsers) {
				if(u instanceof Librarian) {
					Librarian l = (Librarian)u;
					if(l.getMail().equals(mail)) {
						System.out.println("What do you want to change in librarian?");
						System.out.println("1:Name\n2:Surname\n3:Salary\n");
						int command = Integer.parseInt(br.readLine());
						if(command == 1) {
							System.out.println("Write new name for librarian: ");
							String newName = br.readLine();
							l.setName(newName);
							l.constructMail();
							return;
						}else if(command == 2) {
							System.out.println("Write new surname for librarian: ");
							String newSurname = br.readLine();
							l.setSurname(newSurname);
							l.constructMail();
							return;
						}else if(command == 3) {
							System.out.println("Write new salary for librarian: ");
							double newSalary = Double.parseDouble(br.readLine());
							l.setSalary(newSalary);
							return;
						}
					}
				}
			}
		}
		
	}
	
	
	
	
}
	
