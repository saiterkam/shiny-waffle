package project02;

public class Student {

	int studentID;
	String name;
	String lastName;
	int midterm;
	int homework;
	int lab;

	public Student(//
			int studentID, String name, String lastName, //
			int midterm, int homework, int lab //
	) {
		this.studentID = studentID;
		this.name = name;
		this.lastName = lastName;
		this.midterm = midterm;
		this.homework = homework;
		this.lab = lab;
	}

	@Override
	public String toString() {
		String s = "";
		s += "[Student";
		s += " ID:" + studentID;
		s += " name:" + name;
		s += " lastName:" + lastName;
		s += " midterm:" + midterm;
		s += " homework:" + homework;
		s += " lab:" + lab;
		s += "]";
		return s;
	}

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getMidterm() {
		return midterm;
	}

	public void setMidterm(int midterm) {
		this.midterm = midterm;
	}

	public int getHomework() {
		return homework;
	}

	public void setHomework(int homework) {
		this.homework = homework;
	}

	public int getLab() {
		return lab;
	}

	public void setLab(int lab) {
		this.lab = lab;
	}

}
