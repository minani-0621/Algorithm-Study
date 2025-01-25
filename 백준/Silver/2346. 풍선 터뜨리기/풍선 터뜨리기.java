import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static HashMap<Integer, Integer> hashmap = new HashMap<>();
	
	public static void main(String[] args) throws IOException {
		int N = scanner.nextInt();
		Deque<Integer> deque = new ArrayDeque<>();
		
		for(int i = 1; i <= N; i++) {
			hashmap.put(i, scanner.nextInt());
			deque.add(i);
		}
		
		while(true) {
			int current = deque.pollFirst();
			int move = hashmap.get(current);
			
			bw.write(current + " ");
			
			if(deque.isEmpty()) break;
			
			if(move > 0) {
				for(int i = 0; i < move - 1; i++) {
					deque.addLast(deque.pollFirst());
				}
			}else {
				for(int i = 0; i < Math.abs(move); i++) {
					deque.addFirst(deque.pollLast());
				}
			}
		}
		
		bw.flush();
		bw.close();
	}
}
