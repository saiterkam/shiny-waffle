package project02;

import java.util.Arrays;

public class StudentUsage {

	public static void main(String[] args) {
		System.out.println("\nStudentUsage");

		Student stdA = new Student(2001, "Nnnn", "Llll", 96, 95, 55);
		System.out.println(stdA);

		//
		Student[] arrStd = new Student[2];
		arrStd[0] = stdA;
		arrStd[1] = new Student(2005, "Pppp", "Qqqq", 47, 49, 70);

		//
		for (int i = 0; i < arrStd.length; i++) {
			System.out.println(i + ":" + arrStd[i]);
		}
		
		//
		System.out.println(Arrays.toString(arrStd));
	}

}
