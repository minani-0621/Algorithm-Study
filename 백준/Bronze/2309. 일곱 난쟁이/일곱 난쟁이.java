import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		ArrayList<Integer> dwarfs = new ArrayList<>();
		
		for(int i = 0; i < 9; i++) {
			dwarfs.add(scanner.nextInt());
		}
		
		Collections.sort(dwarfs);
		int sum = 0;
		
		for(int i = 0; i < 9; i++) {
			sum += dwarfs.get(i);
		}
		
		int diff = sum - 100;
		int fake1 = 0, fake2 = 0;
		
		for(int i = 0; i < 8; i++) {
			for(int j = i + 1; j < 9; j++) {
				if(dwarfs.get(i) + dwarfs.get(j) == diff) {
					fake1 = i;
					fake2 = j;
					break;
				}
			}
		}
		
		for(int i = 0; i < 9; i++) {
			if(i != fake1 && i != fake2) {
				System.out.println(dwarfs.get(i));
			}
		}
	}
}
