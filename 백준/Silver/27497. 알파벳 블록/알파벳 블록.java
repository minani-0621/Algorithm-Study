import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		Deque<Character> deque = new LinkedList<>();
		Stack<Integer> stack = new Stack<>();
		
		int n = scanner.nextInt();
		
		for(int i = 0; i < n; i++) {
			int command = scanner.nextInt();
			
			if(command == 1) {
				String token = scanner.next();
				deque.addLast(token.charAt(0));
				stack.add(command);
			}else if(command == 2) {
				char token = scanner.next().charAt(0);
				deque.addFirst(token);
				stack.add(command);
			}else if(command == 3) {
				if(!stack.isEmpty()) {
					int beforeCommand = stack.pop();
				
					if(beforeCommand == 1) {
						deque.removeLast();
					}else if(beforeCommand == 2) {
						deque.removeFirst();
					}
				}
			}
		}
		
		if(deque.isEmpty()) {
			System.out.println(0);
		}else {
			StringBuilder sb = new StringBuilder();
			
			for(char ch: deque) {
				sb.append(ch);
			}
			
			System.out.print(sb);
		}
	}
}
