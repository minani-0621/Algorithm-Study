import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		int month = scanner.nextInt();
		int day = scanner.nextInt();
		
		if(month == 2) {
			if(day == 18) {
				System.out.println("Special");
			}else if(day < 18) {
				System.out.println("Before");
			}else if(day > 18) {
				System.out.println("After");
			}
		}else if(month < 2) {
			System.out.println("Before");
		}else if(month > 2) {
			System.out.println("After");
		}
	}
}
