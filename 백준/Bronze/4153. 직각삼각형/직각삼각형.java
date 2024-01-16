import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int a, b, c;
	static ArrayList<String> answer = new ArrayList<>();
	
	public static void main(String[] args) {
		while(true) {
			a = scanner.nextInt();
			b = scanner.nextInt();
			c = scanner.nextInt();
			if(a == 0 && b == 0 && c == 0) {
				break;
			}else {
				answer.add(isItRightAngledTriangle(a, b, c));
			}
		}
		
		for(String str: answer) {
			System.out.println(str);
		}
	}
	
	static String isItRightAngledTriangle(int a, int b, int c) {
		int most, least1, least2;
		
		if(a > b && a > c) {
			most = a;
			least1 = b;
			least2 = c;
		}else if(b > a && b > c) {
			most = b;
			least1 = a;
			least2 = c;
		}else {
			most = c;
			least1 = a;
			least2 = b;
		}
		
		if(most * most == least1 * least1 + least2 * least2) {
			return "right";
		}
		else {
			return "wrong";
		}
	}
}
