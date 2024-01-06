import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static String input;
	static String array[];
	static ArrayList<String> answer = new ArrayList<String>();
	
	public static void main(String[] args) {
		
		loop2:
		while(true) {
			input = scanner.nextLine();
			if(input.equals("0")) {
				break loop2;
			}
			loop:
			for(int i = 0; i < input.length(); i++) {
				if(input.charAt(i) != input.charAt(input.length() - 1 - i)) {
					answer.add("no");
					break loop;
				}
				else if((input.charAt(i) == input.charAt(input.length() - 1 - i)) && (i == input.length() - 1)) {
					answer.add("yes");
				}
			}
		}
		for(String str: answer) {
			System.out.println(str);
		}
	}
}
