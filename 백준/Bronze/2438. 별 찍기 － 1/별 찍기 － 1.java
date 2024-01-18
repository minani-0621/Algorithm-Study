import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int n;
	
	public static void main(String[] args) {
		n = scanner.nextInt();
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j <= i; j++) {
				System.out.printf("%s", "*");
			}
			System.out.println();
		}
	}
}
