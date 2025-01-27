import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		int K = scanner.nextInt();
		int N = scanner.nextInt();
		int M = scanner.nextInt();
		
		if(K * N > M) {
			System.out.println(K * N - M);
		}else {
			System.out.println(0);
		}
	}
}
