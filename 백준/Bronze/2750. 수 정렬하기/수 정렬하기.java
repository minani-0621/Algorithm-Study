import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int n;
	static int list[];
	
	public static void main(String[] args) {
		n = scanner.nextInt();
		list = new int[n];
		for(int i = 0; i < n; i++) {
			int input = scanner.nextInt();
			list[i] = input;
		}
		
		int least, tmp;
		for(int i = 0; i < n - 1; i++) {
			least = i;
			for(int j = i + 1; j < n; j++) {
				if(list[least] >= list[j]) {
					least = j;
				}
			}
			tmp = list[least];
			list[least] = list[i];
			list[i] = tmp;
		}
		
		for(int i = 0; i < n; i++) {
			System.out.printf("%d\n", list[i]);
		}
	}
}