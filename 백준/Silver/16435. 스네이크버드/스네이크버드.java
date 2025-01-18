import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		int N = scanner.nextInt();
		int L = scanner.nextInt();
		ArrayList<Integer> fruits = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			int fruit = scanner.nextInt();
			fruits.add(fruit);
		}
		
		Collections.sort(fruits);
		
		for(int i = 0; i < fruits.size(); i++) {
			if(fruits.get(i) <= L) {
				L++;
			}else {
				break;
			}
		}
		
		System.out.println(L);
	}
}