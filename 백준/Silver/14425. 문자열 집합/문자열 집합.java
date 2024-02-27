import java.util.HashSet;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int n, m;
	static HashSet<String> set = new HashSet<>();
	static int count = 0;
	
	public static void main(String[] args) {
		n = scanner.nextInt();
		m = scanner.nextInt();
		
		for(int i = 0; i < n; i++) {
			set.add(scanner.next());
		}
		
		for(int i = 0; i < m; i++ ) {
			if(set.contains(scanner.next())) {
				count++;
			}
		}
		
		System.out.println(count);
	}
}
