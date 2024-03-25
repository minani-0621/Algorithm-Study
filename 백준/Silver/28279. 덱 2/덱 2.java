import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Deque<Integer> deque = new LinkedList<>();
	
	public static void main(String[] args) throws Exception, IOException {
		int n = scanner.nextInt();
		
		for(int i = 0; i < n; i++) {
			int command = scanner.nextInt();
			
			if(command == 1) {
				deque.addFirst(scanner.nextInt());
			}else if(command == 2) {
				deque.addLast(scanner.nextInt());
			}else if(command == 3) {
				if(deque.isEmpty()) {
					bw.write("-1\n");
				}else {
					bw.write(deque.getFirst() + "\n");
					deque.pollFirst();
				}
			}else if(command == 4) {
				if(deque.isEmpty()) {
					bw.write("-1\n");
				}else {
					bw.write(deque.getLast() + "\n");
					deque.pollLast();
				}
			}else if(command == 5) {
				bw.write(deque.size() + "\n");
			}else if(command == 6) {
				if(deque.isEmpty()) {
					bw.write("1\n");
				}else {
					bw.write("0\n");
				}
			}else if(command == 7) {
				if(deque.isEmpty()) {
					bw.write("-1\n");
				}else {
					bw.write(deque.peekFirst() + "\n");
				}
			}else if(command == 8) {
				if(deque.isEmpty()) {
					bw.write("-1\n");
				}else {
					bw.write(deque.peekLast() + "\n");
				}
			}
		}
		
		bw.flush();
		bw.close();
	}
}
