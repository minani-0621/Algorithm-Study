import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int n;
	static String command;
	static Deque<String> deque = new ArrayDeque<>();
	
	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < n; i++) {
			command = br.readLine();
			
			if(command.length() >= 10 && command.substring(0, 10).equals("push_front")) {
				deque.addFirst(command.substring(11));
			}else if(command.length() >= 11 && command.substring(0, 9).equals("push_back")) {
				deque.addLast(command.substring(10));
			}else if(command.equals("pop_front")) {
				if(deque.isEmpty()) {
					bw.write("-1\n");
				}else {
					bw.write(deque.pollFirst() + "\n");
				}
			}else if(command.equals("pop_back")) {
				if(deque.isEmpty()) {
					bw.write("-1\n");
				}else {
					bw.write(deque.pollLast() + "\n");
				}
			}else if(command.equals("size")) {
				bw.write(deque.size() + "\n");
			}else if(command.equals("empty")) {
				if(deque.isEmpty()) {
					bw.write("1\n");
				}else {
					bw.write("0\n");
				}
			}else if(command.equals("front")) {
				if(deque.isEmpty()) {
					bw.write("-1\n");
				}else {
					bw.write(deque.peekFirst() + "\n");
				}
			}else if(command.equals("back")) {
				if(deque.isEmpty()) {
					bw.write("-1\n");
				}else {
					bw.write(deque.peekLast() + "\n");
				}
			}
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
}
