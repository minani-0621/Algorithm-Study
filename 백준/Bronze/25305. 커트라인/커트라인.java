import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		int N = scanner.nextInt();
		int k = scanner.nextInt();
		
		ArrayList<Integer> array = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			array.add(scanner.nextInt());
		}
		
		Collections.sort(array, Collections.reverseOrder());
		
		System.out.println(array.get(k - 1));
	}
}
