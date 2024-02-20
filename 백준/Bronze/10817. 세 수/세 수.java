import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static ArrayList<Integer> array = new ArrayList<>();
	
	public static void main(String[] args) {
		int a, b, c;
		
		a = scanner.nextInt();
		array.add(a);
		
		b = scanner.nextInt();
		array.add(b);
		
		c = scanner.nextInt();
		array.add(c);
		
		Collections.sort(array);
		
		System.out.println(array.get(1));
	}
}
