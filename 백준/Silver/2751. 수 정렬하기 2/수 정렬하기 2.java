import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
// 선택정렬 사용하면 시간복잡도 너무 커져서 시간초과 오류 남. 그래서 합병 절렬 사용해야 함.
public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int n;
	static int list[];
	static int sorted[];
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		n = scanner.nextInt();
		list = new int[n];
		sorted = new int[n];
		
		for(int i = 0; i < n; i++) {
			int input = scanner.nextInt();
			list[i] = input;
		}
		
		merge_sort(list, 0, n - 1);		
		
		for(int i = 0; i < n; i++) {
			bw.write(list[i]+"\n");
//			System.out.printf("%d\n", list[i]);
		}
		bw.flush();
		bw.close();
	}
	
	static void merge_sort(int list[], int left, int right) {
		int mid;
		
		if(left < right) {
			mid = (left + right) / 2;
			merge_sort(list, left, mid);
			merge_sort(list, mid + 1, right);
			merge(list, left, mid, right);
		}
	}

	static void merge(int list[], int left, int mid, int right) {
		int i, j, k, l;
		
		i = left;
		j = mid + 1;
		k = left;
		
		while(i <= mid && j <= right) {
			if(list[i] <= list[j]) {
				sorted[k++] = list[i++];
			}
			else {// list[i] >= list[j]
				sorted[k++] = list[j++];
			}
		}
		
		if(i > mid) {
			for(l = j; l <= right; l++) {
				sorted[k++] = list[l];
			}
		}else {// j > right
			for(l = i; l <= mid; l++) {
				sorted[k++] = list[l];
			}
		}
		
		for(l = left; l <= right; l++) {
			list[l] = sorted[l];
		}
	}
}
