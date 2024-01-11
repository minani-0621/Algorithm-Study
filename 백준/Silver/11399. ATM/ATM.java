import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int n;
	static ArrayList<Integer> array = new ArrayList<>();
	static int totalTime = 0;
	
	public static void main(String[] args) {
		n = scanner.nextInt();
		
		for(int i = 0; i < n; i++) {
			int time = scanner.nextInt();
			array.add(time);
		}
		
		Collections.sort(array);
		
		for(int i = 0; i < array.size(); i++) {
			int personTime = 0;
			for(int j = 0; j < i + 1; j++) {
				personTime += array.get(j);
			}
			totalTime += personTime;
		}
		
		System.out.printf("%d", totalTime);
	}
}
