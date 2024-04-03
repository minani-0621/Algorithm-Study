import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		int n = scanner.nextInt();
		int count = 0;
		
		ArrayList<Integer> array = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			int point = scanner.nextInt();
			array.add(point);
		}
		
		for(int i = n - 2; i >= 0; i--) {
			int previousLevel = array.get(i);
			int nextLevel = array.get(i + 1);
			
			if(previousLevel >= nextLevel) {
				array.set(i, nextLevel - 1);
				count += previousLevel - nextLevel + 1;
			}
		}
		
		System.out.println(count);
	}
}
