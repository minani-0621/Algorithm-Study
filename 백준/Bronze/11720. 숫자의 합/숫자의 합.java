import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int n, num;
	static String input;
	static int sum = 0;
	
	public static void main(String[] args) {
		n = scanner.nextInt();
		input = scanner.next();
		
		for(int i = 0; i < n; i++) {
			num = Character.getNumericValue(input.charAt(i));
			sum += num;
		}
		
		System.out.println(sum);
	}
}
