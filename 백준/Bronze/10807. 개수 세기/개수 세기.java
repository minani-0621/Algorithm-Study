import java.util.Scanner;

public class  Main {
	static Scanner scanner = new Scanner(System.in);
	static int n, v;
	static int count = 0;
	static int array[];
	
	public static void main(String[] args) {
		n = scanner.nextInt();
		array = new int[n];
		
		for(int i = 0; i < n; i++) {
			array[i] = scanner.nextInt();
		}
		
		v = scanner.nextInt();
		
		for(int i = 0; i < n; i++) {
			if(v == array[i]) {
				count++;
			}
		}
		
		System.out.printf("%d", count);
	}
}
