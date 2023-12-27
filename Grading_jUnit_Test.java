package project02;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class Grading_jUnit_Test {

	static final double EPSILON = 1e-8;

	String csvStudentDataA = "studentID,name,lastName,midterm,homework,lab\n"//
			+ "-1,-weight,in percent,40,10,50\n" // percentages
			+ "-2,-full,point,100,100,100\n" // test for full points
			+ "1001,Aaa,Aaaa,50,50,50\n" // test for 50% points
			+ "1002,Bbb,Bbbb,10,10,10\n" // test for 10% points
			+ "1003,Ccc,Cccc,0,0,0\n" // test for 0% points
			+ "1004,Only,midterm,100,0,0\n" // test for midterm only
			+ "1005,Only,homework,0,100,0\n" // test for homework only
			+ "1006,Only,final,0,0,100\n" // test for final only
			+ "1007,Ddd,Dddd,1,2,3" // test for random points
	;

	/*
	 * New weights
	 */
	String csvStudentDataB = "studentID,name,lastName,midterm,homework,lab\n"//
			+ "-1,-weight,in percent,35,20,45\n" // percentages
			+ "-2,-full,point,100,100,100\n" // test for full points
			+ "1007,Ccc,Cccc,40,20,30\n" // test for random points
	;

	/*
	 * equals of `Student`
	 */

	@Test
	void equals_true_test() {
		System.out.println("\nequals_true_test");
		Student sA = new Student(1001, "Aaa", "Aaaa", 50, 50, 50);
		Student sB = new Student(1001, "Aaa", "Aaaa", 50, 50, 50);
		//
		boolean expected = true;
		boolean actual = ProcessGradingData.equals(sA, sB);
		//
		assertEquals(expected, actual);
	}

	@Test
	void equals_SID_test() {
		System.out.println("\nequals_SID_test");
		Student sA = new Student(1001, "Aaa", "Aaaa", 50, 50, 50);
		Student sB = new Student(1002, "Aaa", "Aaaa", 50, 50, 50);
		//
		boolean expected = false;
		boolean actual = ProcessGradingData.equals(sA, sB);
		//
		assertEquals(expected, actual);
	}

	@Test
	void equals_name_test() {
		System.out.println("\nequals_name_test");
		Student sA = new Student(1001, "Aaa", "Aaaa", 50, 50, 50);
		Student sB = new Student(1001, "AaaX", "Aaaa", 50, 50, 50);
		//
		boolean expected = false;
		boolean actual = ProcessGradingData.equals(sA, sB);
		//
		assertEquals(expected, actual);
	}

	@Test
	void equals_lastname_test() {
		System.out.println("\nequals_lastname_test");
		Student sA = new Student(1001, "Aaa", "Aaaa", 50, 50, 50);
		Student sB = new Student(1001, "Aaa", "AaaaX", 50, 50, 50);
		//
		boolean expected = false;
		boolean actual = ProcessGradingData.equals(sA, sB);
		//
		assertEquals(expected, actual);
	}

	@Test
	void equals_midterm_test() {
		System.out.println("\nequals_midterm_test");
		Student sA = new Student(1001, "Aaa", "Aaaa", 50, 50, 50);
		Student sB = new Student(1001, "Aaa", "Aaaa", 60, 50, 50);
		//
		boolean expected = false;
		boolean actual = ProcessGradingData.equals(sA, sB);
		//
		assertEquals(expected, actual);
	}

	@Test
	void equals_homework_test() {
		System.out.println("\nequals_homework_test");
		Student sA = new Student(1001, "Aaa", "Aaaa", 50, 50, 50);
		Student sB = new Student(1001, "Aaa", "Aaaa", 50, 60, 50);
		//
		boolean expected = false;
		boolean actual = ProcessGradingData.equals(sA, sB);
		//
		assertEquals(expected, actual);
	}

	@Test
	void equals_lab_test() {
		System.out.println("\nequals_lab_test");
		Student sA = new Student(1001, "Aaa", "Aaaa", 50, 50, 50);
		Student sB = new Student(1001, "Aaa", "Aaaa", 50, 50, 60);
		//
		boolean expected = false;
		boolean actual = ProcessGradingData.equals(sA, sB);
		//
		assertEquals(expected, actual);
	}

	/*
	 * weight
	 */

	@Test
	void weighted_40_10_50_test() {
		System.out.println("\nweighted_40_10_50_test");
		double[] weight = { 0.40, 0.10, 0.50 };
		Student sA = new Student(1001, "Aaa", "Aaaa", 10, 20, 30);
		//
		double expected = 21.0;
		double actual = ProcessGradingData.getWeightedGrade(weight, sA);
		assertEquals(actual, expected, EPSILON);
	}

	@Test
	void weighted_35_20_45_test() {
		System.out.println("\nweighted_35_20_45_test");
		double[] weight = { 0.35, 0.20, 0.45 };
		Student sA = new Student(1001, "Aaa", "Aaaa", 40, 25, 35);
		//
		double expected = 34.75;
		double actual = ProcessGradingData.getWeightedGrade(weight, sA);
		assertEquals(actual, expected, EPSILON);
	}

	/*
	 * getStudentData
	 */

	@Test
	void getStudentData_1001_test() {
		System.out.println("\ngetStudentData_1001_test");
		Student[] student = ProcessGradingData.getStudentData(csvStudentDataA);
		//
		int i = 0;
		Student expected = new Student(1001, "Aaa", "Aaaa", 50, 50, 50);
		Student actual = student[i];
		//
		assertEquals(true, ProcessGradingData.equals(expected, actual));
	}

	@Test
	void getStudentData_1002_test() {
		System.out.println("\ngetStudentData_1002_test");
		Student[] student = ProcessGradingData.getStudentData(csvStudentDataA);
		//
		int i = 1;
		Student expected = new Student(1002, "Bbb", "Bbbb", 10, 10, 10);
		Student actual = student[i];
		//
		assertEquals(true, ProcessGradingData.equals(expected, actual));
	}

	@Test
	void getStudentData_1003_test() {
		System.out.println("\ngetStudentData_1003_test");
		Student[] student = ProcessGradingData.getStudentData(csvStudentDataA);
		//
		int i = 2;
		Student expected = new Student(1003, "Ccc", "Cccc", 0, 0, 0);
		Student actual = student[i];
		//
		assertEquals(true, ProcessGradingData.equals(expected, actual));
	}


	/*
	 * getReport
	 */

	@Test
	void report_a_test() {
		System.out.println("\nreport_a_test");
		Student[] student = ProcessGradingData.getStudentData(csvStudentDataA);
		System.out.println(Arrays.toString(student));

		//
		String[] expected = { //
				"1001,50.0"//
				, "1002,10.0"//
				, "1003,0.0"//
				, "1004,40.0"//
				, "1005,10.0"//
				, "1006,50.0"//
				, "1007,2.1"//
		};
		String[] actual = ProcessGradingData.getReport(student);
		assertArrayEquals(actual, expected);
	}

	@Test
	void report_b_test() {
		System.out.println("\nreport_b_test");
		Student[] student = ProcessGradingData.getStudentData(csvStudentDataB);
		System.out.println(Arrays.toString(student));

		//
		String[] expected = { //
				"1007,31.5"//
		};
		String[] actual = ProcessGradingData.getReport(student);
		assertArrayEquals(actual, expected);
	}

}
