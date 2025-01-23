import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		int A = scanner.nextInt();
		int B = scanner.nextInt();
		int C = scanner.nextInt();
		
		if(B >= C) {
			System.out.println(-1);
		}else {
			System.out.println(A / (C - B) + 1);
		}
	}
}
