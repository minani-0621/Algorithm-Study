import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int n, k, answer;
	public static void main(String[] args) {
		n = scanner.nextInt();
		k = scanner.nextInt();
		
		int tmp1 = 1;
		int tmp2 = 1;
		int tmp3 = 1;
		
		for(int i = 1; i < n + 1; i++) {
			tmp1 *= i; // tmp1 = tmp1 * i
		}
		
		for(int i = 1; i < k + 1; i++) {
			tmp2 *= i;
		}
		
		for(int i = 1; i < n - k + 1; i++) {
			tmp3 *= i;
		}
		
		answer = tmp1 / (tmp2 * tmp3);
		
		System.out.printf("%d", answer);
	}
}
