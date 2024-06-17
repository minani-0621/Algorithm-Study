import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		int l = scanner.nextInt();
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int c = scanner.nextInt();
		int d = scanner.nextInt();
		
		double korean = (double)a / (double)c;
		double math = (double)b / (double)d;
	
		if(Math.ceil(korean) >= Math.ceil(math)) {
			System.out.println((int)(l - Math.ceil(korean)));
		}else {
			System.out.println((int)(l - Math.ceil(math)));
		}
	}
}
