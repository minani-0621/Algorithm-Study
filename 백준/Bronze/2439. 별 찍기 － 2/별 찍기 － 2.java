import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int n;
	
	public static void main(String[] args) {
		n = scanner.nextInt();
		
		for(int i = 0; i < n; i++) {
			for(int j = n - i - 1; j > 0; j--) {
				System.out.printf("%s", " ");
			}
			
			for(int k = 0; k < i + 1; k++) {
				System.out.printf("%s", "*");
			}
			
			System.out.println();
		}
	}
}
