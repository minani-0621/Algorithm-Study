import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int X;
	static int total = 64;
	static int Length = 64;
	static int count = 1;
	
	public static void main(String[] args) {
		X = scanner.nextInt();
		while(total >= X) {
			if(X == 64 || total == X) {
				break;
			}
			Length = Length / 2;
			if((total - Length) >= X) {
				total = total - Length;
			}else if((total - Length) < X) {
				count++;
			}			
		}
		System.out.printf("%d", count);
	}
}
