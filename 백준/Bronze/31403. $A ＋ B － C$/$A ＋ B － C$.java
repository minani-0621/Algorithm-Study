import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int c = scanner.nextInt();
		
		System.out.println(a + b - c);
		
		String aString = Integer.toString(a);
		String bString = Integer.toString(b);
		
		String tmp = aString.concat(bString);
		System.out.println(Integer.parseInt(tmp) - c);
	}
}
