import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		int k = scanner.nextInt();
		
		System.out.println(k * m + m);
	}
}
