import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		String input = scanner.next();
		int i = scanner.nextInt();
		
		System.out.println(input.charAt(i - 1));
	}
}
