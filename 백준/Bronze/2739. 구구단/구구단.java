import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		int n;
		n = scanner.nextInt();
		
		for(int i = 0; i < 9; i++) {
			System.out.printf("%d * %d = %d\n", n, i + 1, n * (i + 1));
		}
	}
}
