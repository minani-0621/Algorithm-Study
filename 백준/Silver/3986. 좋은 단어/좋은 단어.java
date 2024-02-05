import java.util.Scanner;
import java.util.Stack;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int n;
	static int count = 0;
	
	public static void main(String[] args) {
		n = scanner.nextInt();
		
		for(int i = 0; i < n; i++) {
			Stack<String> stack = new Stack<>();
			
			String input = scanner.next();
			
			if(input.length() % 2 == 1) {
				continue;
			}else {
				 for(int j = 0; j < input.length(); j++) {
					 if(stack.isEmpty()) {
						 stack.push(Character.toString(input.charAt(j)));
					 }else if(stack.peek().equals(Character.toString(input.charAt(j)))) {
						 stack.pop();
					 }else if(!stack.peek().equals(Character.toString(input.charAt(j)))){
						 stack.push(String.valueOf(input.charAt(j)));
					 }
				 }
				 
				 if(stack.isEmpty()) {
					 count++;
				}
			}
		}
		
		System.out.println(count);
	}
}
