import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		int n = scanner.nextInt();
		String strN = Integer.toString(n);
		int answer = 0;
		
		for(int i = 0; i < strN.length(); i++) {
			answer += Math.pow(Integer.parseInt(Character.toString(strN.charAt(i))), 5);
		}
		
		System.out.println(answer);
	}
}
