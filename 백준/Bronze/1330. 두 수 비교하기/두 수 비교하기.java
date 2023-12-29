import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		int a;
		int b;
		
		a = scanner.nextInt();
		b = scanner.nextInt();
		
		if(a > b) {
			System.out.printf("%s", ">");
		}else if(a < b) {
			System.out.printf("%s", "<");
		}else if(a == b){
			System.out.printf("%s", "==");
		}
	}
}
