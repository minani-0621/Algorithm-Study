import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		int R1 = scanner.nextInt();
		int S = scanner.nextInt();
		
		System.out.println(S * 2 - R1);
	}
}