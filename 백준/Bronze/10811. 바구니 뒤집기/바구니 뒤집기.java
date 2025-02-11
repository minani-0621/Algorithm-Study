import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		int N = scanner.nextInt();
		int M = scanner.nextInt();
		int[] array = new int[N];
		
		for(int i = 0; i < N; i++) {
			array[i] = i + 1;
		}
		
		for(int i = 0; i < M; i++) {
			int start = scanner.nextInt();
			int end = scanner.nextInt();
			int[] tmpArray = new int[end - start + 1];
			
			for(int j = 0; j < end - start + 1; j++) {
				tmpArray[j] = array[start + j - 1];
			}
			
			for(int j = tmpArray.length - 1; j >= 0; j--) {
				array[start - 1] = tmpArray[j];
				start++;
			}
		}
		
		for(int num: array) {
			System.out.print(num + " ");
		}
	}
}
