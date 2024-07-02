import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		int x = scanner.nextInt();
		int y = scanner.nextInt();
		
		if(x < 0 && y > 0) {
			System.out.println(2);
		}else if(x < 0 && y < 0) {
			System.out.println(3);
		}else if(x > 0 && y > 0) {
			System.out.println(1);
		}else {
			System.out.println(4);
		}
	}
}
