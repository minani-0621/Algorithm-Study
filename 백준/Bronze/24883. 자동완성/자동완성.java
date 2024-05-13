import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		String input = scanner.next();
		
		if(input.equals("N") || input.equals("n")) {
			System.out.println("Naver D2");
		}else {
			System.out.println("Naver Whale");
		}
	}
}
