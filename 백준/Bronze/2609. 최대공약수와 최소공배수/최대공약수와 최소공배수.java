import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int num1, num2, gcd, lcm;
	
	public static void main(String[] args) {
		num1 = scanner.nextInt();
		num2 = scanner.nextInt();
		
		gcd = findGCD(num1, num2);
		lcm = findLCM(num1, num2, gcd);
		
		System.out.println(gcd);
		System.out.println(lcm);
	}

	static int findGCD(int n1, int n2) {
		int r = n1 % n2;
		
		while(r != 0) {
			n1 = n2;
			n2 = r;
			r = n1 % n2;
		}
		
		return n2;
	}
	
	static int findLCM(int n1, int n2, int gcd) {
		int lcm;
		
		lcm = n1 * n2 / gcd;
				
		return lcm;
	}
}
