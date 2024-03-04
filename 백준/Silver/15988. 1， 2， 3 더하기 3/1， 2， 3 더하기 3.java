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
 * 이다. 초기값인 F(1), F(2), F(3)를 이제 알았으므로 F(4)부터의 수를 구할 수 있게 된다. 처음에는 탑다운
 * 방식의 메모이제이션 DP를 활용해서 문제를 풀려고 했으나, 탑다운 방식은 n이 1,000,000 일때 처럼 입력된 수가
 * 클 때 재귀호출이 무수히 많이 발생하여 스택 오버플로우가 발생하게 된다. 이를 해결하기 위해선 탑다운 DP가 아니라
 * 바텀업 DP를 활용한 반복문을 사용하면 해결할 수 있다.
*/
public class Main {
	static Scanner scanner = new Scanner(System.in);
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		int testCase = scanner.nextInt();
		
		for(int i = 0; i < testCase; i++) {
			int n = scanner.nextInt();
			
			long array[] = new long[1000001];
			array[1] = 1;
			array[2] = 2;
			array[3] = 4;
			
			if(n > 3) {
				for(int j = 4; j < n + 1; j++) {
					array[j] = (array[j - 1] + array[j - 2] + array[j - 3]) % 1000000009;
				}
			}
			
			bw.write(array[n] + "\n");
		}
		
		bw.flush();
		bw.close();
	}
}
