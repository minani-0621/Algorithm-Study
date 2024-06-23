import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		int n = scanner.nextInt();
		
		for(int i = 1; i <= n; i++) {
			for(int j = n - 1; j >= i; j--) {
				System.out.print(" ");
			}
			
			for(int k = 1; k <= i * 2 - 1; k++) {
				System.out.print("*"); 
			}
			
			System.out.println();
		}
	}
}