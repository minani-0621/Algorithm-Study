import java.util.Scanner;
import java.util.Stack;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static Stack<Integer> stack = new Stack<>();
	static int n;
	static int count = 0;
	static StringBuilder sb = new StringBuilder();
	static StringBuilder sb2 = new StringBuilder();
	
	public static void main(String[] args) {
		n = scanner.nextInt();
		
		for(int i = 1; i <= n; i++) {
			int input = scanner.nextInt();
			
			if(!stack.isEmpty() && stack.peek().equals(input)) {
				stack.pop();
				sb.append("-\n");
			}else if(stack.isEmpty() || !stack.peek().equals(input)) {
				if(input < count) {
					sb2.append("NO");
					break;
				}
				for(int j = count + 1; j <= input; j++) {
					stack.push(j);
					count++;
					sb.append("+\n");
				}
				stack.pop();
				sb.append("-\n");
			}
		}
		
		if(sb2.length() == 2) {
			System.out.println(sb2);
		}else {
			System.out.println(sb);
		}
	}
}
