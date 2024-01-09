import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static HashMap<String, Integer> sellingList = new HashMap<>();
	static int n;
	static String bookName;
	static ArrayList<String> mostArray = new ArrayList<>();
	
	public static void main(String[] args) {
		n = scanner.nextInt();
		
		for(int i = 0; i < n; i++) {
			int count;
			bookName = scanner.next();
			if(sellingList.containsKey(bookName) == false) {
				sellingList.put(bookName, 1);
			}else if(sellingList.containsKey(bookName) == true){
				count = sellingList.get(bookName);
				count++;
				sellingList.replace(bookName, count);
			}
		}
		
		int most = 0;
		for(Integer value: sellingList.values()) {
			if(most <= value) {
				most = value;
			}
		}
		
		for(String str: sellingList.keySet()) {
			if(sellingList.get(str) == most) {
				mostArray.add(str);
			}
		}
		
		Collections.sort(mostArray);
		
		System.out.printf("%s", mostArray.get(0));
	}
}
