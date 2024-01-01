import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static String reverse = "";
	public static void main(String[] args) {
		String input = scanner.next();
		int inputLength = input.length();
		
		for(int i = inputLength - 1; i > -1; i--) {
			char word = input.charAt(i);
			String tmp = String.valueOf(word);
			reverse += tmp;
		}
		
		if(reverse.equals(input)) {
			System.out.printf("%d", 1);
		}else if(reverse.equals(input) == false) {
			System.out.printf("%d", 0);
		}
		
	}
}