import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int n;
	
	public static void main(String[] args) {
		n = scanner.nextInt();
		
		for(int i = n; i > 0; i--) {
			System.out.println(i);
		}
	}
}
