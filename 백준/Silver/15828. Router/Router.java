import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		int N = scanner.nextInt();
		Queue<Integer> queue = new LinkedList<>();
		
		while(true) {
			int data = scanner.nextInt();
			
			if(data == -1) {
				break;
			}
			
			if(data == 0) {
				queue.poll();
			}else {
				if(queue.size() < N) {
					queue.add(data);
				}
			}
		}
		
		if(queue.isEmpty()) {
			System.out.println("empty");
		}else { 
			for(int num: queue) {
				System.out.print(num + " ");
			}
		}
	}
}
