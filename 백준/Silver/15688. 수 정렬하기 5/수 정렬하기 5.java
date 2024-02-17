import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int n;
	
	public static void main(String[] args) throws IOException {
		/* 숫자를 저장할 자료를 처음에는 ArrayList<Integer>로 다뤘는데 시간초과가 발생하였다.
		 * ArrayList를 사용하지 않고 int형 배열을 사용하면 시간초과를 해결할 수 있는데, 그 이유는
		 * int형 배열보다 Integer나 ArrayList라는 Object를 사용할 때 훨씬 무겁기 때문이다.
		 * 그리고 요소에 접근할 때도 array[i]로 접근하는 할때 보다 array.get(i)로 접근할 때 
		 * 시간이 더 걸리게 된다. */
		n = Integer.parseInt(br.readLine());
		int array[] = new int [n];
		
		for(int i = 0; i < n; i++) {
			array[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(array);
		
		for(int i = 0; i < n; i++) {
			/* sb.append(array[i] + "\n"); -> 느림
			 * 위의 코드처럼 array[i]와 개행문자를 +로 연결해서 작성하는 것이 아래 코드처럼
			 * 이어서 append()로 연결하는것 보다 처리속도가 느리다. array[i]와 \n를 합치는 과정에서
			 * 새 문자열을 다시 생성하게 되므로 시간이 더 오래걸리는 것 같다.. */
			sb.append(array[i]).append("\n");
		}
		
		System.out.println(sb);
	}
}
