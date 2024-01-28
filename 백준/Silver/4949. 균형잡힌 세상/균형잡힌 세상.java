import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static String input;
	
	public static void main(String[] args) throws IOException {
		input = scanner.nextLine();
		
		while(!input.equals(".")) {
			Stack<String> stack = new Stack<>();
			
			for(int i = 0; i < input.length(); i++) {
				if(String.valueOf(input.charAt(i)).equals("(")) {
					stack.push("(");
				}else if(String.valueOf(input.charAt(i)).equals(")")) {
					if(!stack.isEmpty() && stack.peek().equals("(")) {
						stack.pop();
					}else {
						bw.write("no\n");
						break;
					}
				}else if(String.valueOf(input.charAt(i)).equals("[")) {
					stack.push("[");
				}else if(String.valueOf(input.charAt(i)).equals("]")) {
					if(!stack.isEmpty() && stack.peek().equals("[")) {
						stack.pop();
					}else {
						bw.write("no\n");
						break;
					}
				}
				
				if(stack.empty() && i == input.length() - 1) {
					bw.write("yes\n");
				}else if(!stack.empty() && i == input.length() - 1){
					bw.write("no\n");
				}
			}
			input = scanner.nextLine();
		}
		
		bw.flush();
		bw.close();
	}
}
