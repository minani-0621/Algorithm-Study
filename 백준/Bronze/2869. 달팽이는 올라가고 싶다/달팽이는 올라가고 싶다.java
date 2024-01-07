import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int a, b, v;
	
	public static void main(String[] args) {
		a = scanner.nextInt();
		b = scanner.nextInt();
		v = scanner.nextInt();
		
		double day = (double)(v - a) / (double)(a - b);
		
		int countDay = (int)Math.ceil(day);
		countDay++;
		
		System.out.printf("%d", countDay);
	}
}
