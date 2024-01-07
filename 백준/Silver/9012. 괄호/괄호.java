import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int t;
	static String string;
	static ArrayList<String> answer = new ArrayList<String>();
	
	public static void main(String[] args) {
		t = scanner.nextInt();
		
		for(int i = 0; i < t; i++) {
			string = scanner.next();
			String array[] = new String[string.length()];
			
			for(int k = 0; k < string.length(); k++) {
				array[k] = string.substring(k, k + 1);
			}
			int state = 0;
			
			loop:
			for(int j = 0; j < array.length; j++) {
				if(array[j].equals("(")) {
					state--;
				}else if(array[j].equals(")")) {
					state++;
					if(state == 1) {
						answer.add("NO");
						break loop;
					}
				}
				if(j == array.length - 1) {
					if(state == 0) {
						answer.add("YES");
					}
					else if(state != 0) {
						answer.add("NO");
					}
				}
			}
		}
		
		for(String str: answer) {
			System.out.println(str);
		}
	}
}
