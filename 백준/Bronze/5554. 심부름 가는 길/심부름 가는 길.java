import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		int t1 = scanner.nextInt();
		int t2 = scanner.nextInt();
		int t3 = scanner.nextInt();
		int t4 = scanner.nextInt();
		
		int tSum = 0;
		
		tSum += t1;
		tSum += t2;
		tSum += t3;
		tSum += t4;
		
		System.out.println(tSum / 60);
		System.out.println(tSum % 60);
	}
}
