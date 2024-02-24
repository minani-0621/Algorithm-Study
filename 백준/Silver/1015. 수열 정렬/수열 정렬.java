import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		int n = scanner.nextInt();
		
		int a[] = new int[n]; // 입력받는 배열
		int b[] = new int[n]; // a배열을 비내림차순으로 정렬한 배열
		int p[] = new int[n]; // a배열을 b배열처럼 비내림차순으로 만드는
		
		// a배열에 차례대로 입력받고 b배열에 그대로 복사
		for(int i = 0; i < n; i++) {
			a[i] = scanner.nextInt();
			b[i] = a[i];
		}
		
		Arrays.sort(b); // b배열을 비내림차순(오름차순)으로 정렬
		
		/* 
		 * 비내림차순으로 정렬된 b배열의 요소를 차례대로 a배열에서 어느부분에 있는지 순차적으로 찾아낸 후, 그 때
		 *  찾아낸 인덱스 위치 j를 이용해서 p배열의 인덱스가 j인 자리에 b의 인덱스인 i를 저장하고, 이후 뒤에 
		 *  나오는 배열요소 중에 앞서 나왔던 숫자와 동일한 것이 나왔을 때도 비교 작업이 가능하도록 a[j] 자리에 
		 *  의미없는 값으로 바꾸어 저장한다. 이 문제에서는 배열의 요소가 1000 보다 작거나 같은 자연수라고 
		 *  하였으므로 의미없는 값은 -1을 이용하기로 하였다. a배열의 j인덱스 위치에 의미없는값 -1을 저장하고 
		 *  다음 b배열 요소 탐색 과정으로 넘어간다. 이 과정을 b배열 요소 끝까지 반복해서 수행하면 된다.
		 */
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(b[i] == a[j]) {
					p[j] = i;
					a[j] = -1;
					break;
				}
			}
		}
		
		for(int i = 0; i < n; i++) {
			bw.write(p[i] + " ");
		}
		
		bw.flush();
		bw.close();
	}
}
