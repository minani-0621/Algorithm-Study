import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		String[] input = scanner.next().split(":");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		int gcd;
		
		if(n > m) {
			gcd = gcd(n, m);			
		}else {
			gcd = gcd(m, n);
		}
		
		System.out.println(n / gcd + ":" + m / gcd);
	}
	
	static int gcd(int bigger, int smaller) {
		while(smaller != 0) {
			int tmp = bigger % smaller;
			bigger = smaller;
			smaller = tmp;
		}
		
		return bigger;
	}
}
