import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int n;
	static int count = 0;
	static String s;
	static String array[];
	static ArrayList<String> word = new ArrayList<String>();
	
	public static void main(String[] args) {
		n = scanner.nextInt();
		
		for(int i = 0 ; i < n; i++) {
			word.clear();
			
			s = scanner.next();
			array = new String[s.length()];
			
			for(int j = 0; j < s.length(); j++) {
				array[j] = s.substring(j, j + 1);
			}
			
			int index = 0;
			loop:
			while(index < array.length) {
				word.add(array[index]);
				
				if(index == array.length - 1) {
					break loop;
				}
				
				while(index < array.length - 1 && array[index].equals(array[index + 1])) {
					index++;
				}
				index++;
			}
			loop:
			for(String str: word) {
				int total = 0;
				int frequency = Collections.frequency(word, str);
				if(frequency >= 2) {
					count++;
					break loop;
				}
			}		
		}
		System.out.printf("%d", n - count);
	}
}
