import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int n;
	static Stack<Integer> stack = new Stack<>();
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		n = scanner.nextInt();
		
		for(int i = 0; i < n; i++) {
			int command = scanner.nextInt();
			if(command == 1) {
				int item = scanner.nextInt();
				stack.push(item);
			}else if(command == 2) {
				if(!stack.isEmpty()) {
					bw.write(stack.pop() + "\n");
				}else {
					bw.write("-1\n");
				}
			}else if(command == 3) {
				bw.write(stack.size() + "\n");
			}else if(command == 4) {
				if(stack.isEmpty()) {
					bw.write("1\n");
				}else {
					bw.write("0\n");
				}
			}else if(command == 5) {
				if(!stack.isEmpty()) {
					bw.write(stack.peek() + "\n");
				}else {
					bw.write("-1\n");
				}
			}
		}
		
		bw.flush();
		bw.close();
	}
}
