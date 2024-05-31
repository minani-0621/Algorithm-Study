import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		int n = scanner.nextInt();
		
		for(int i = 1; i <= n; i++) {
			System.out.println("Hello World, Judge " + i + "!");
		}
	}
}
