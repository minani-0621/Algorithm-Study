import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		long N = scanner.nextLong();
		
		if(N >= -32768 && N <= 32767) {
            System.out.println("short");
        }else if (N >= -2147483648L && N <= 2147483647L) {
            System.out.println("int");
        }else {
        	System.out.println("long long");
        }
	}
}
