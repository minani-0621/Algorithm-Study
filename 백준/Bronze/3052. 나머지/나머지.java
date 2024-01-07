import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int b = 42;
	static ArrayList<Integer> array = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		int a;
		int r;
		
		for(int i = 0; i < 10; i++) {
			a = scanner.nextInt();
			r = a % b;
			
			if(!array.contains(r)) {
				array.add(r);
			}
		}
		System.out.printf("%d", array.size());
	}
}
