import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int list[] = new int[9];
	static int most;
	static int tmp;
	
	public static void main(String[] args) {
		for(int i = 0; i < 9; i++) {
			list[i] = Integer.parseInt(scanner.nextLine());
		}
		int most = 0;
		for(int i = 1; i < 9; i++) {
			if(list[most] <= list[i]) {
				 most = i;
			}
		}
		System.out.printf("%d\n%d", list[most], most + 1);		

	}
}