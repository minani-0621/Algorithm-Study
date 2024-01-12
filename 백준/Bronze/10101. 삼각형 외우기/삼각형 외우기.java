import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int a, b, c;
	
	public static void main(String[] args) {
		a = scanner.nextInt();
		b = scanner.nextInt();
		c = scanner.nextInt();
		
		if(a == 60 && b == 60 && c == 60) {
			System.out.printf("%s", "Equilateral");
		}else if(a + b + c == 180 && (a == b || a == c || b == c) ) {
			System.out.printf("%s", "Isosceles");
		}else if(a + b + c == 180 && a != b && a != c && b != c) {
			System.out.printf("%s", "Scalene");
		}else if(a + b + c != 180){
			System.out.print("Error");
		}
	}
}
