import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static ArrayList<Integer> hamburger = new ArrayList<>();
	static ArrayList<Integer> drink = new ArrayList<>();
	
	public static void main(String[] args) {
		for(int i = 0; i < 3; i++) {
			hamburger.add(scanner.nextInt());
		}
		
		for(int i = 0; i < 2; i++) {
			drink.add(scanner.nextInt());
		}
		
		Collections.sort(hamburger);
		Collections.sort(drink);
		
		int price = hamburger.get(0) + drink.get(0) - 50;
		
		System.out.println(price);
	}
}
