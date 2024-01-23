import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int x;
	static int count = 1;
	static int sum = 3;
	static int row, col;
	
	public static void main(String[] args) {
		x = scanner.nextInt();
		
		if(x == 1) {
			System.out.printf("%d/%d", 1, 1);
		}else {
			loop:
			while(true) {
				if(sum % 2 == 1) {
					for(int i = 0; i < sum - 1; i++) {
						row = i + 1;
						col = sum - 1 - i;
						count++;
						if(count == x) {
							System.out.printf("%d/%d", row, col);
							break loop;
						}
					}
				}else if(sum % 2 == 0) {
					for(int i = 0; i < sum - 1; i++) {
						row = sum - 1 - i;
						col = i + 1;
						count++;
						if(count == x) {
							System.out.printf("%d/%d", row, col);
							break loop;
						}
					}
				}
				sum++;
			}
		}
	}
}
