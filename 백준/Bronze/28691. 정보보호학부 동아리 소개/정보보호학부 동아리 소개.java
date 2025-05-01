import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		String input = scanner.next();
		
		if(input.equals("M")) {
			System.out.println("MatKor");
		}else if(input.equals("W")) {
			System.out.println("WiCys");
		}else if(input.equals("C")) {
			System.out.println("CyKor");
		}else if(input.equals("A")) {
			System.out.println("AlKor");
		}else if(input.equals("$")) {
			System.out.println("$clear");
		}
	}
}
