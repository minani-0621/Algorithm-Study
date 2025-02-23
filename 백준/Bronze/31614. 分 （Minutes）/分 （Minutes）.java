import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		int H = scanner.nextInt();
		int M = scanner.nextInt();
		
		System.out.println(H * 60 + M);
	}
}
