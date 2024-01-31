import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static LinkedList<Integer> deque = new LinkedList<>();
	static int n, m, key;
	static int count = 0;
	
	public static void main(String[] args) {
		n = scanner.nextInt();
		m = scanner.nextInt();
		
		for(int i = 1; i <= n; i++) {
			deque.add(i);
		}
		
		for(int i = 0; i < m; i++) {
			key = scanner.nextInt();
			
			if(deque.getFirst() == key) {
				deque.removeFirst();
			}else {
				if(deque.size() / 2 >= deque.indexOf(key)) {
					int cnt = moveLeft(deque, key);
					count += cnt;
				}else { // deque.size() / 2 < deque.indexOf(key)
					int cnt = moveRight(deque, key);
					count += cnt;
				}
			}
		}
		
		System.out.println(count);
	}
	
	public static int moveLeft(Deque<Integer> deque, int key) {
		int cnt = 0;
		
		while(deque.peekFirst() != key) {
			deque.addLast(deque.peekFirst());
			deque.removeFirst();
			cnt++;
		}
		
		deque.removeFirst();
		return cnt;
	}
	
	public static int moveRight(Deque<Integer> deque, int key) {
		int cnt = 0;
		
		while(deque.peekFirst() != key) {
			deque.addFirst(deque.peekLast());
			deque.removeLast();
			cnt++;
		}
		
		deque.removeFirst();
		return cnt;
	}
}
