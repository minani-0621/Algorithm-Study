import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		int N = scanner.nextInt();
		int total = 0;
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = scanner.nextInt();
		}
		
		int M = scanner.nextInt();
		
		for(int i = 0; i < M; i++) {
			int idx = scanner.nextInt();
			total += arr[idx - 1];
		}
		
		System.out.println(total);
	}
}
