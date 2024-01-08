import java.io.IOException;
import java.util.Scanner;
/*
재귀호출로 하노이탑 구현. 하나의 원판을 옮길때마다 count의 값을 1씩 증가시키는데, 총 이동 횟수를 먼저 출력하고 그 다음에 이동한 내용을 출력해야 되기 때문에
이동한 내용은 StringBuilder에 저장해놓고, count 출력 후 StringBuilder에 있는 이동한 내용을 모두 출력한다.
*/
public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int n;
	static long count = 0;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		n = scanner.nextInt();
		
		Hanoi(n, 1, 3, 2);
		System.out.println(count);
		System.out.println(sb);
	}
	
	static void Hanoi(int n, int src, int dst, int tmp) throws IOException {
		if(n > 0) {
			Hanoi(n - 1, src, tmp, dst);
			sb.append(src + " ");
			sb.append(dst + "\n");
			count++;
			Hanoi(n - 1, tmp, dst, src);
		}
	}
}
