import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int n;
	static Queue<Integer> queue = new LinkedList<>();
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		n = scanner.nextInt();
		
		for(int i = 1; i <= n; i++) {
			queue.add(i);
		}
		
		while(queue.size() > 0) {
			bw.write(queue.peek() + " ");
			queue.poll();
			queue.add(queue.peek());
			queue.poll();
		}
		
		bw.flush();
		bw.close();
	}
}
