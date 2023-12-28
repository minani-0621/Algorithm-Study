import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int a;
		int b;
		double answer;
		
		a = scanner.nextInt();
		b = scanner.nextInt();
		while((a <= 0) || (a >= 10) || (b <= 0) ||(b >= 10)) {
			a = scanner.nextInt();
			b = scanner.nextInt();
		}
		
		answer = (double)a / (double)b;
		
		System.out.printf("%.9f", answer);
	}
}
