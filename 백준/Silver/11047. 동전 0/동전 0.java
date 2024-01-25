import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int n, k, input;
	static int count = 0;
	static ArrayList<Integer> array = new ArrayList<>();
	
	public static void main(String[] args) {
		n = scanner.nextInt();
		k = scanner.nextInt();
		
		for(int i = 0; i < n; i++) {
			input = scanner.nextInt();
			array.add(input);
		}
		
		for(int i = array.size() - 1; i >= 0; i--) {
			int groupCount = k / array.get(i);
			
			if(groupCount >= 1) {
				k = k - array.get(i) * groupCount;
				count += groupCount;
			}
			
			if(k == 0) {
				break;
			}
		}
		
		System.out.println(count);
	}
}
