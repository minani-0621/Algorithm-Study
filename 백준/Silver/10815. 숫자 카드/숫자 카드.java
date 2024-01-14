import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
/* 
 * 상근이가 가지고 있는 숫자 카드 n개 배열을 오름차순으로 정렬한 후, 비교 대상인 m개의 카드 배열에서 한 카드마다 
 * 상근이가 가지고 있는 숫자 카드 n개에 존재하는지 이진탐색으로 탐색한 후 존재하면 "1"을, 존재하지 않으면 "0"을
 * 리턴한다. 그 결과를 비교 대상인 m개의 카드 배열 각 요소마다 (배열 요소 값, 결과)의 키와 값의 쌍으로
 * HashMap에 저장하고 출력한다.
*/
public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int n, m;
	static int array1[], array2[];
	static HashMap<Integer, String> answer = new HashMap<>();
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		n = scanner.nextInt();
		array1 = new int[n];
		
		for(int i = 0; i < n; i++) {
			array1[i] = scanner.nextInt();
		}
		
		m = scanner.nextInt();
		array2 = new int[m];
		
		for(int i = 0; i < m; i++) {
			array2[i] = scanner.nextInt();
		}
		
		Arrays.sort(array1);
		
		for(int i = 0; i < m ; i++) {
			answer.put(i, binary_search(array1, array2[i], n));
		}
		
		for(int i = 0; i < m; i++) {
			bw.write(answer.get(i) + " ");
		}
		
		bw.flush();
		bw.close();
	}

	static String binary_search(int arr[], int key, int n) {
		int low = 0;
		int high = n - 1;
		
		while(low <= high) {
			int mid = (low + high) / 2;
			
			if(arr[mid] == key) {
				return "1";
			}else if(arr[mid] < key) {
				low = mid + 1;
			}else { // arr[mid] > key
				high = mid - 1;
			}
		}
		return "0";
	}
}
