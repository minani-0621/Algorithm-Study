import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Queue<Integer> queue = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		int lastPush = 0;
		
		for(int i = 0; i < n; i++) {
			String command = br.readLine();
			
			if(command.length() >= 4) {
				if(command.substring(0, 4).equals("push")) {
					queue.add(Integer.parseInt(command.substring(5)));
					lastPush = Integer.parseInt(command.substring(5));
				}else if(command.equals("size")) {
					bw.write(queue.size() + "\n");
				}else if(command.equals("empty")) {
					if(queue.isEmpty()) {
						bw.write("1\n");
					}else {
						bw.write("0\n");
					}
				}else if(command.equals("front")) {
					if(queue.isEmpty()) {
						bw.write("-1\n");
					}else {
						bw.write(queue.peek() + "\n");
					}
				}else if(command.equals("back")) {
					if(queue.isEmpty()) {
						bw.write("-1\n");
					}else {
						bw.write(lastPush + "\n");
					}
				}
			}else {
				if(command.equals("pop")) {
					if(queue.isEmpty()) {
						bw.write("-1\n");
					}else {
						bw.write(queue.peek() + "\n");
						queue.poll();
					}
				}
			}
		}
		
		bw.flush();
		bw.close();
	}
}
