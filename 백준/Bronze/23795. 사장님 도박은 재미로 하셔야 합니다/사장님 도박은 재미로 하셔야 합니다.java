import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		int sum = 0;
		
		while(true) {
			int input = scanner.nextInt();
			
			if(input == -1) {
				break;
			}else {
				sum += input;
			}
		}
		
		System.out.println(sum);
	}
}
