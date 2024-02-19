import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int x, n;
	static int total = 0;
	
	public static void main(String[] args) {
		x = scanner.nextInt();
		n = scanner.nextInt();
		
		for(int i = 0; i < n; i++) {
			int price = scanner.nextInt();
			int count = scanner.nextInt();
			total += (price * count);
		}
		
		if(total == x) {
			System.out.println("Yes");
		}else {
			System.out.println("No");
		}
	}
}
