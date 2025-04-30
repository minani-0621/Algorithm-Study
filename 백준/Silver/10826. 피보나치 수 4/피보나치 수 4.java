import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static BigInteger[] dp;
	
	public static void main(String[] args) {
		int n = scanner.nextInt();
		dp = new BigInteger[n + 2];
		
		for(int i = 0; i <= n; i++) {
			dp[i] = BigInteger.ZERO;
		}
		
		System.out.println(fib(n));
	}
	
	static BigInteger fib(int x) {
		if(x == 0) {
			return BigInteger.ZERO;
		}
		
		if(x == 1) {
			return BigInteger.ONE;
		}
		
		if(dp[x].equals(BigInteger.ZERO)) {
			dp[x] = fib(x - 1).add(fib(x - 2));
		}
		
		return dp[x];
	}
}
