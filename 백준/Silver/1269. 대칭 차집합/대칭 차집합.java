import java.util.HashSet;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int a, b;
	static HashSet<Integer> hashsetA = new HashSet<>();
	static HashSet<Integer> hashsetB = new HashSet<>();
	static HashSet<Integer> hashsetCopyA = new HashSet<>();
	
	public static void main(String[] args) {
		a = scanner.nextInt();
		b = scanner.nextInt();
		
		for(int i = 0; i < a; i++) {
			int input = scanner.nextInt();
			hashsetA.add(input);
			hashsetCopyA.add(input);
		}
		
		for(int i = 0; i < b; i++) {
			hashsetB.add(scanner.nextInt());
		}
		
		hashsetA.removeAll(hashsetB);
		int result1 = hashsetA.size();
		
		hashsetB.removeAll(hashsetCopyA);
		int result2 = hashsetB.size();
		
		int total = result1 + result2;
		
		System.out.println(total);
	}
}
