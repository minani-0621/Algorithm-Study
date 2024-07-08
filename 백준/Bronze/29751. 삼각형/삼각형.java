import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		int w = scanner.nextInt();
		int h = scanner.nextInt();
		
		double area = 0.5 * (double)w * (double)h;
		
		System.out.printf("%.1f", area);
	}
}
