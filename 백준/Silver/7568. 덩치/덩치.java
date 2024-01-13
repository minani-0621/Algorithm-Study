import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int n, x, y;
	static int list[][];
	
	public static void main(String[] args) {
		n = scanner.nextInt();
		list = new int[n][3];
		
		for(int i = 0; i < n; i++) {
			x = scanner.nextInt();
			y = scanner.nextInt();
			
			list[i][0] = x;
			list[i][1] = y;
		}
		
		for(int i = 0; i < n; i++) {
			list[i][2] = checkBigger(list, i);
		}
		
		for(int i = 0; i < n; i++) {
			System.out.printf("%d ", list[i][2] + 1);
		}
	}

	static int checkBigger(int list[][], int i) {
		int count = 0;
		
		for(int j = 0; j < n; j++) {
			if(list[i][0] < list[j][0] && list[i][1] < list[j][1]) {
				count += 1;
			}
		}
		
		return count;
	}
}
