import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	static public void main(String[] args) {
		int a, b, c;
		
		a = scanner.nextInt();
		b = scanner.nextInt();
		c = scanner.nextInt();
		
		if(a == b && b == c) {
			System.out.println(10000 + a * 1000);
		}else if((a == b && a != c) || (a == c && a != b) || (b == c && b != a)) {
			if(a == b) {
				System.out.println(1000 + a * 100);
			}else if(a == c) {
				System.out.println(1000 + a * 100);
			}else if(b == c) {
				System.out.println(1000 + b * 100);
			}
		}else if(a != b && b != c && a != c) {
			if(a > b && a > c) {
				System.out.println(a * 100);
			}else if(b > a && b > c) {
				System.out.println(b * 100);
			}else if(c > a && c > b) {
				System.out.println(c * 100);
			}
		}
	}
}
