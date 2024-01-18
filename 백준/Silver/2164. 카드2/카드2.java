import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/*
 * 자바의 ArrayList를 사용하여 큐를 구현하게 되면 O(n^2)의 시간복잡도로 인해 실행시간이 매우 느려지게 된다.
 * 그래서 자바의 Queue 클래스를 사용해야 한다.
*/
public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int n;
	static Queue<Integer> queue = new LinkedList<>();
	
	public static void main(String[] args) {
		n = scanner.nextInt();
		
		for(int i = 1; i <= n; i++) {
			queue.add(i);
		}
		
		while(queue.size() > 1) {
			queue.poll();
			queue.offer(queue.peek());
			queue.poll();
		}
		
		System.out.println(queue.peek());
	}
}
