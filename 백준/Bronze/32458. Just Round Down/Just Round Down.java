import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		String input = scanner.next();
		String[] tmp = input.split("\\.");
		System.out.println(tmp[0]);
	}
}
