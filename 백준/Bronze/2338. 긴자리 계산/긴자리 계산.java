import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		BigInteger a = new BigInteger(scanner.next());
		BigInteger b = new BigInteger(scanner.next());
		
		BigInteger sum = a.add(b);
		BigInteger dif = a.subtract(b);
		BigInteger mul = a.multiply(b);
		
		System.out.println(sum);
		System.out.println(dif);
		System.out.println(mul);
	}
}
