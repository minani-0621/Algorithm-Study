import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		int A = scanner.nextInt();
		int B = scanner.nextInt();
		
		String reverseA = new StringBuilder(Integer.toString(A)).reverse().toString();
		String reverseB = new StringBuilder(Integer.toString(B)).reverse().toString();
		
		int reverseIntA = Integer.parseInt(reverseA);
		int reverseIntB = Integer.parseInt(reverseB);
		
		if(reverseIntA > reverseIntB) {
			System.out.println(reverseIntA);
		}else {
			System.out.println(reverseIntB);
		}
	}
}
