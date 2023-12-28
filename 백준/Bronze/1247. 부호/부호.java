import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	static int N;
	static Scanner scanner = new Scanner(System.in);
	static BigInteger zero = new BigInteger("0");
	static String answer[] = new String[3];
	// 입력된 수들을 합하는 과정에서 int와 long의 범위를 벗어나는 오버플로우 및 언더플로우를 막기 위해서 BigInteger를 사용한다.
	public static void main(String[] args) {
		for(int j = 0; j < 3; j++) {
			N = scanner.nextInt();
			if((N < 1) || (N > 100000)) {
				N = scanner.nextInt();
			}
			
			BigInteger list[] = new BigInteger [N];
			
			for(int i = 0; i < N; i++) {
				list[i] = scanner.nextBigInteger();
			}
			
			BigInteger total = new BigInteger("0");
			
			for(int i = 0; i < N; i++) {
				total = total.add((BigInteger)list[i]);  // total = total + list[i]
			}
			
			if(total.compareTo(zero) == 0) {
				answer[j] = "0";
			}else if(total.compareTo(zero) > 0) {
				answer[j] = "+";
			}else if(total.compareTo(zero) < 0) {
				answer[j] = "-";
			}
		}
		for(int k = 0; k < 3; k++) {
			System.out.printf("%s\n", answer[k]);
		}
		
	}
}
