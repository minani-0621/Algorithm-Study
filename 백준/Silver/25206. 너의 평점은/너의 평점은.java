import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static String subject;
	static double credit;
	static String grade;
	static double totalCredit = 0;
	static double total = 0;
	static double totalGrade = 0;
	
	public static void main(String[] args) {
		for(int i = 0; i < 20; i++) {
			subject = scanner.next();
			credit = scanner.nextDouble();
			grade = scanner.next();
			
			if(grade.equals("P") == false) {
				total = total + (credit * takeGrade(grade));
				totalCredit += credit;
			}
		}
		totalGrade = total / totalCredit;	
		System.out.printf("%f", totalGrade);
	}
	
	static double takeGrade(String gradeString){
		double g = 0;
		
		if(gradeString.equals("A+")) {
			g = 4.5;
		}else if(gradeString.equals("A0")) {
			g = 4.0;
		}else if(gradeString.equals("B+")) {
			g = 3.5;
		}else if(gradeString.equals("B0")) {
			g = 3.0;
		}else if(gradeString.equals("C+")) {
			g = 2.5;
		}else if(gradeString.equals("C0")) {
			g = 2.0;
		}else if(gradeString.equals("D+")) {
			g = 1.5;
		}else if(gradeString.equals("D0")) {
			g = 1.0;
		}else if(gradeString.equals("F")) {
			g = 0.0;
		}
		return g;
	}
}
