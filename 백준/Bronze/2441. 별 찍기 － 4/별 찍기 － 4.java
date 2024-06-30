import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		int n = scanner.nextInt();
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			
			for(int k = n - i; k > 0; k--) {
				System.out.print("*");
			}
			
			System.out.println();
		}
	}
}
