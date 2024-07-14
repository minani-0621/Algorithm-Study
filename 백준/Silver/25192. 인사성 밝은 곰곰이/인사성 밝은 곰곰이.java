import java.util.HashSet;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		int n = scanner.nextInt();
		HashSet<String> hashset = new HashSet<>();
		int count = 0;
		
		for(int i = 0; i < n; i++) {
			String input = scanner.next();
			
			if(input.equals("ENTER")) {
				hashset.removeAll(hashset);
			}else if(!hashset.contains(input)) {
				hashset.add(input);
				count++;
			}
		}
		
		System.out.println(count);
	}
}
