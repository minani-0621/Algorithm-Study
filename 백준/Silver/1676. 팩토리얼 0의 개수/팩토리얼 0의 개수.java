import java.math.BigInteger;
import java.util.Scanner;
/*
 * 이 문제는 팩토리얼의 실제 수를 계산했을 때, int형이나 long형으로 값을 저장하게 되면 오버플로우가 발생하여
 * 뒷자리부터의 연속된 0의 개수를 정확히 카운트 할 수 없다. 그러므로 저장할 수 있는 범위가 무한인 BigInteger를
 * 사용하여 어던 팩토리얼의 수의 실제값을 계산하여야 한다.
*/
public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int n;
	static BigInteger num = new BigInteger("1");
	static String numString;
	static int count = 0;
	
	public static void main(String[] args) {
		n = scanner.nextInt();
		
		for(int i = 1; i <= n; i++) {
			BigInteger tmp = new BigInteger(String.valueOf(i));
			num = num.multiply(tmp);
		}
		
		numString = num.toString();
		
		for(int i = numString.length() - 1; i >= 0; i--) {
			if(String.valueOf(numString.charAt(i)).equals("0")) {
				count++;
			}else {
				break;
			}
		}
		
		System.out.println(count);
	}
}
