import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int n;
	static String inputArray[];
	static ArrayList<String> noDupArr = new ArrayList<>();
	
	public static void main(String[] args) {
		n = scanner.nextInt();
		inputArray = new String[n];
		
		for(int i = 0; i < n; i++) {
			String input = scanner.next();
			inputArray[i] = input;
		}
		
		Arrays.sort(inputArray, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				if(s1.length() - s2.length() == 0) {
					return s1.compareTo(s2);
				}
				return s1.length() - s2.length();
			}
			
		});
		
		for(int i = 0 ; i < n; i++) {
			if(!noDupArr.contains(inputArray[i])) {
				noDupArr.add(inputArray[i]);
			}
		}
		
		for(String str: noDupArr) {
			System.out.println(str);
		}		
	}
}
