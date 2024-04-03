import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		int n = scanner.nextInt();
		int jimin = scanner.nextInt();
		int hansoo = scanner.nextInt();
		int round = 0;
		
		double jiminDouble = (double)jimin;
		double hansooDouble = (double)hansoo;
		
		while(jiminDouble != hansooDouble) {			
			n = n / 2;
			jiminDouble = Math.ceil(jiminDouble / 2);
			hansooDouble = Math.ceil(hansooDouble / 2);
			round++;
		}
		
		System.out.println(round);
	}
}
