import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int n;
	static ArrayList<Integer> inputArray = new ArrayList<>();
	static ArrayList<Integer> outputArray = new ArrayList<>();
	
	public static void main(String[] args) {
		n = scanner.nextInt();
		
		for(int i = 0; i < n; i++) {
			inputArray.add(scanner.nextInt());
		}
		
		Collections.sort(inputArray);
		
		for(int i = 0; i < inputArray.size(); i++) {
			if(outputArray.size() == 0) {
				outputArray.add(inputArray.get(0));
			}else {
				if(!outputArray.get(outputArray.size() - 1).equals(inputArray.get(i))) {
					outputArray.add(inputArray.get(i));
				}
			}
		}
		
		for(int num: outputArray) {
			System.out.printf("%d ", num);
		}
	}
}
