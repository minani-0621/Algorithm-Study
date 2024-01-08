import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int n;
	static int input, most, least;
	static int array[];
	
	public static void main(String[] args) {
		n = scanner.nextInt();
		array = new int[n];
		
		for(int i = 0; i < n; i++) {
			input = scanner.nextInt();
			array[i] = input;
		}
		
		most = array[0];
		least = array[0];
		
		for(int i = 1; i < n; i++) {
			if(most <= array[i]) {
				most = array[i];
			}
			if(least >= array[i]) {
				least = array[i];
			}
		}
		
		System.out.printf("%d %d", least, most);
	}
}
