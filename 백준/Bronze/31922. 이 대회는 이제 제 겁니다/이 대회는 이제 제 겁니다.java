import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		int A = scanner.nextInt();
		int P = scanner.nextInt();
		int C = scanner.nextInt();
		
		if(A + C > P) {
			System.out.println(A + C);
		}else {
			System.out.println(P);
		}
	}
}
