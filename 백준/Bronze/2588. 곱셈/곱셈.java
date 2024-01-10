import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int num1, num2, one, ten, hundred, ans1, ans2, ans3, ans4;
	
	public static void main(String[] args) {
		num1 = scanner.nextInt();
		num2 = scanner.nextInt();
		
		String numStr2;
		
		numStr2 = Integer.toString(num2);
		
		one = Integer.parseInt(String.valueOf(numStr2.charAt(2)));
		ans1 = num1 * one;
		
		ten = Integer.parseInt(String.valueOf(numStr2.charAt(1)));
		ans2 = num1 * ten;
		
		hundred = Integer.parseInt(String.valueOf(numStr2.charAt(0)));
		ans3 = num1 * hundred;
		
		ans4 = ans1 + ans2 * 10 + ans3 * 100;
		
		System.out.println(ans1);
		System.out.println(ans2);
		System.out.println(ans3);
		System.out.println(ans4);
	}
}
