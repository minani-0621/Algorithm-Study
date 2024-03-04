import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;
/*
 * 이 문제의 점화식은 F(n) = F(n - 1) + F(n - 2) + F(n - 3)이다. 어떤 수 n을 1, 2, 3만의 합을
 * 가지고 만들 수 있는 경우의 수는 n의 경우, n - 1을 만드는 모든 경우 각각에 대해 그 뒤에 1을 더하는 것과,
 * n - 2을 만드는 모든 경우 각각에 대해 그 뒤에 2을 뒤하는 것과, n - 3을 만드는 모든 경우 각각에 대해 그
 * 뒤에 3을 더하는 것의 모든 경우의 수의 합이기 때문이다. 점화식을 구했으니 F(1), F(2), F(3)를 구할 차례다.
 * 1을 만드는 경우는 (1), 단 하나 뿐이므로 F(1) = 1이고, 2를 만드는 경우는 (2), (1 + 1), 두 가지 이므로
 * F(2) = 2이고, 3을 만드는 경우는 (3), (2 + 1), (1 + 2), (1 + 1 + 1), 네 가지 이므로 F(3) = 4
 * 이다. 초기값인 F(1), F(2), F(3)를 이제 알았으므로 F(4)부터의 수를 구할 수 있게 된다. 그리고 F(n)을
 * 계산할 때 DP를 사용하여 이미 한 번 구한 F(n)은 배열에 저장해둠으로써 시간을 단축시킬 수 있다.
*/
public class Main {
	static Scanner scanner = new Scanner(System.in);
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		int testCase = scanner.nextInt();
		
		for(int i = 0; i < testCase; i++) {
			int n = scanner.nextInt();
			
			int array[] = new int[11];
			array[1] = 1;
			array[2] = 2;
			array[3] = 4;
			
			bw.write(F(n, array) + "\n");
		}
		
		bw.flush();
		bw.close();
	}
	
	static int F(int n, int array[]) {
		if(n == 1) {
			return 1;
		}else if(n == 2) {
			return 2;
		}else if(n == 3) {
			return 4;
		}else{ // n >= 4
			if(array[n] != 0) {
				return array[n];
			}else {
				return array[n] = F(n - 1, array) + F(n - 2, array) + F(n - 3, array);
			}
		}
	}
}
