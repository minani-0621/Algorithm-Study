import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		int total = scanner.nextInt();
		
		for(int i = 0; i < 9; i++) {
			int bookPrice = scanner.nextInt();
			total -= bookPrice;
		}
		
		System.out.println(total);
	}
}
