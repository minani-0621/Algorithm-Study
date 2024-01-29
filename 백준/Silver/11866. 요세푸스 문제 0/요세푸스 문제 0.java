import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int n, k;
	static Queue<Integer> queue = new LinkedList<>();
	static ArrayList<Integer> result = new ArrayList<>();
	
	public static void main(String[] args) {
		n = scanner.nextInt();
		k = scanner.nextInt();
		
		for(int i = 1; i <= n; i++) {
			queue.add(i);
		}
		
		while(queue.size() != 0) {
			if(k == 1) {
				result.add(queue.peek());
				queue.remove();
			}else {
				for(int i = 0; i < k - 1; i++) {
					queue.add(queue.peek());
					queue.remove();
				}
				
				result.add(queue.peek());
				queue.remove();
			}
			
		}
		
		System.out.printf("<");
		
		for(int i = 0; i < result.size() - 1; i++) {
			System.out.printf("%d", result.get(i));
			System.out.print(", ");
		}
		
		System.out.printf("%d>", result.get(result.size() - 1));
	}
}
