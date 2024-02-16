import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int sum = 0;
	
	public static void main(String[] args) {
		for(int i = 0; i < 5; i++) {
			int inputNum = scanner.nextInt();
			sum += (inputNum * inputNum);
		}
		
		int validNum = sum % 10;
		
		System.out.println(validNum);
	}
}
