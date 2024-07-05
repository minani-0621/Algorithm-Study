import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		int n = scanner.nextInt();
		
		if(n == 0) {
			System.out.println("YONSEI");
		}else if(n == 1) {
			System.out.println("Leading the Way to the Future");
		}
	}
}
