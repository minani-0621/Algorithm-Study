import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		int n = scanner.nextInt();
		
		Student olderPerson = new Student(); // 가장 나이가 많은 사람 객체 생성
		Student youngerPerson = new Student(); // 가장 나이가 적은 사람 객체 생성
		
		// 입력으로 받는 이름, 일, 월, 년에 관한 변수 생성
		String name = scanner.next();
		int day = scanner.nextInt();
		int month = scanner.nextInt();
		int year = scanner.nextInt();
		
		// 첫 번째로 입력받은 사람을 olderPerson과 youngerPerson으로 설정
		olderPerson.name = name;
		olderPerson.day = day;
		olderPerson.month = month;
		olderPerson.year = year;
		
		youngerPerson.name = name;
		youngerPerson.day = day;
		youngerPerson.month = month;
		youngerPerson.year = year;
		
		for(int i = 1; i < n; i++) {
			name = scanner.next();
			day = scanner.nextInt();
			month = scanner.nextInt();
			year = scanner.nextInt();
			
			// olderPerson를 갱신하는 알고리즘
			if(olderPerson.year > year) {
				olderPerson.year = year;
				olderPerson.month = month;
				olderPerson.day = day;
				olderPerson.name = name;
			}else if(olderPerson.year == year) {
				if(olderPerson.month > month) {
					olderPerson.month = month;
					olderPerson.month = month;
					olderPerson.day = day;
					olderPerson.name = name;
				}else if(olderPerson.month == month) {
					if(olderPerson.day > day) {
						olderPerson.day = day;olderPerson.month = month;
						olderPerson.day = day;
						olderPerson.name = name;
					}
				}
			}
			
			// youngerPerson을 갱신하는 알고리즘
			if(youngerPerson.year < year) {
				youngerPerson.year = year;
				youngerPerson.month = month;
				youngerPerson.day = day;
				youngerPerson.name = name;
			}else if(youngerPerson.year == year) {
				if(youngerPerson.month < month) {
					youngerPerson.month = month;
					youngerPerson.month = month;
					youngerPerson.day = day;
					youngerPerson.name = name;
				}else if(youngerPerson.month == month) {
					if(youngerPerson.day < day) {
						youngerPerson.day = day;
						youngerPerson.month = month;
						youngerPerson.day = day;
						youngerPerson.name = name;
					}
				}
			}
		}
		
		System.out.println(youngerPerson.name);
		System.out.println(olderPerson.name);
	}
	
}

class Student {
	String name;
	int day;
	int month;
	int year;
}