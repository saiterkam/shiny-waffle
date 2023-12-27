package project02;


import java.util.Arrays; // required for auto grading

/**
 * midterm, homework, final grades are over 100.
 * 
 * row 0: column titles row 1: weights row 2: full grades for testing row 3-:
 * actual students
 * 
 * String studentDataCsv = "studentID,name,lastName,midterm,homework,lab\n"// +
 * "-1,-weight,percent,40,10,50\n"// percentages where studentID=-1 +
 * "-2,-full,point,100,100,100\n"// test for full points where studentID=-1 +
 * "1001,Aaa,Aaaa,50,50,50\n"// first student + "1002,Bbb,Bbbb,10,10,10"//
 * second student ;
 */
public class ProcessGradingData {

	public static final String MY_ID = "20231601056";
	public static final String MY_NAME = "Vugar";
	public static final String MY_LASTNAME = "Hasanzada";

	public static final int WEIGHT = -1;
	public static final int FULL = -2;
	//
	public static final int S_ID = 0;
	public static final int S_NAME = 1;
	public static final int S_LAST_NAME = 2;
	public static final int MIDTERM = 3;
	public static final int HOMEWORK = 4;
	public static final int FINAL = 5;
	//
	public static double[] weight = new double[3];

	/**
	 * Student info
	 * 
	 * @return
	 */
	public static String getStudentInfo() {
		return MY_ID + "," + MY_LASTNAME + "," + MY_NAME;
	}

	/**
	 * Given two `Student`s, return `true` if the students are equal in content.
	 * 
	 * @param stdA
	 * @param stdB
	 * @return `true` if the students are equal in content.
	 */
	public static boolean equals(Student stdA, Student stdB) {
		//
		// System.out.println("\nnot implemented"); // TODO
		//
boolean idEquality = (stdA.getStudentID() == stdB.getStudentID());
boolean nameEquality = stdA.getName().equals(stdB.getName());
boolean lastName = stdA.getLastName().equals(stdB.getLastName());
boolean lab = (stdA.getLab() == stdB.getLab()); 
boolean hw = (stdA.getHomework() == stdB.getHomework());
boolean mid = (stdA.getMidterm()== stdB.getMidterm());
		return idEquality && nameEquality && lastName && lab && hw && mid;
	}

	/**
	 * Given `weight` array and `Student`, calculate the weighted grade
	 * 
	 * @param weight
	 * @param student
	 * @return weighted grade
	 */
	public static double getWeightedGrade(double[] weight, Student student) {
		double grade = 0;
		//
		// System.out.println("\nnot implemented"); // TODO
		//
double a = student.getMidterm() * weight[0];
double b = student.getHomework() * weight[1];
double c = student.getLab() * weight[2];
grade = a + b + c;
		return grade;
	}

	/**
	 * Convert student data in csv format into <code>arrStudent</code> and populate
	 * `weight` array.
	 * 
	 * @param csv student data
	 * @return array of <code>Students</code>
	 */
	public static Student[] getStudentData(String csv) {
		Student[] arrStudent = null;
		//
//		System.out.println("\nnot implemented"); // TODO
		//
String[] lines = csv.split("\n");
int numStudents = lines.length - 3;
Student[] arrStudent1= new Student [numStudents];
for(int i = 0; i < arrStudent1.length; i++) {
String[] res = lines[i + 3].split(",");
int studentID = Integer.parseInt(res[0].trim());
String name = res[1];
String lastName = res[2];
int midterm = Integer.parseInt(res[3]);
int homework = Integer.parseInt(res[4]);
int lab = Integer.parseInt(res[5]);
arrStudent1[i] = new Student(studentID, name, lastName, midterm, homework, lab);
}
return arrStudent1;
	}

	/**
	 * Produce report of student number and weighted grade
	 * 
	 * @param arrStudent
	 * @return
	 */
	public static String[] getReport(Student[] arrStudent) {
		String[] arrGradesOverAll = null;
		//
//		System.out.println("\nnot implemented"); // TODO
		//
		  String[] arrGradesOverAll1 = new String[arrStudent.length];

	        for (int i = 0; i < arrStudent.length; i++) {
	            // Calculate overall grade for each student
	            double overallGrade = calculateOverallGrade(arrStudent[i]);

	            // Format the result as "studentID,overallGrade"
	            arrGradesOverAll1[i] = arrStudent[i].getStudentID() + "," + overallGrade;
	        }

		//
		return arrGradesOverAll1;
	}

	private static double calculateOverallGrade(Student student) {
		// TODO Auto-generated method stub
		return 0;
	}

}
