import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		int n = scanner.nextInt();
		int count = 0;
		int checkNum = 666;
		
		while(n != count) {
			String checkNumStr = Integer.toString(checkNum);
			
			if(checkNumStr.contains("666")) {
				count++;
			}
			
			if(n == count) {
				System.out.println(checkNum);
			}
			
			checkNum++;
		}
		
	}
}
