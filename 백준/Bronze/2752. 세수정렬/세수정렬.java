import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		ArrayList<Integer> array = new ArrayList<>();
		
		for(int i = 0; i < 3; i++) {
			array.add(scanner.nextInt());
		}
		
		Collections.sort(array);
		for(int num: array) {
			System.out.print(num + " ");
		}
	}
}
