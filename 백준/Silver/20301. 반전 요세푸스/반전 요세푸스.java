import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		int N = scanner.nextInt();
		int K = scanner.nextInt();
		int M = scanner.nextInt();
		
		Deque<Integer> deque = new ArrayDeque<>();
		ArrayList<Integer> array = new ArrayList<>();
		
		for(int i = 1; i <= N; i++) {
			deque.add(i);
		}
		
		int removeCount = 0;
		boolean isReverse = false;
		
		while(!deque.isEmpty()) {
			if(removeCount == M) {
				isReverse = !isReverse;
				removeCount = 0;
			}
			
			if(isReverse) {
				for(int i = 0; i < K; i++) {
					deque.addFirst(deque.pollLast());
				}
				
				array.add(deque.pollFirst());
				removeCount++;
			}else {
				for(int i = 0; i < K - 1; i++) {
					deque.addLast(deque.pollFirst());
				}
				
				array.add(deque.pollFirst());
				removeCount++;
			}
		}
		
		for(int num: array) {
			System.out.println(num);
		}
	}
}
