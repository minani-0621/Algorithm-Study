import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static long sorted[];
	
	public static void main(String[] args) throws IOException {
		int n;
		int m;
		
		n = scanner.nextInt();
		long A[] = new long[n];
		sorted = new long[n];
		for(int i = 0; i < n; i++) {
			A[i] = scanner.nextLong();
		}
		
		m = scanner.nextInt();
		long B[] = new long[m];
		for(int j = 0; j < m; j++) {
			B[j] = scanner.nextLong();
		}
		
		merge_sort(A, 0, A.length - 1);
		
		for(int i = 0; i < B.length; i++) {
			int answer;
			answer = binary_search(A, A.length, B[i]);
			bw.write(Integer.toString(answer));
			bw.flush();
			bw.newLine();
		}
		
	}
	
	static void merge(long list[], int left, int mid, int right) {
		int i, j, k, l;
		i = left;
		j = mid + 1;
		k = left;
		
		while(i <= mid && j<= right) {
			if(list[i] <= list[j]) {
				sorted[k++] = list[i++];
			}else {
				sorted[k++] = list[j++];
			}
		}
		if(i > mid) {
			for(l = j; l <= right; l++) {
				sorted[k++] = list[l];
			}
		}else {
			for(l = i; l <= mid; l++) {
				sorted[k++] = list[l];
			}
		}
		for(l = left; l <= right; l++) {
			list[l] = sorted[l];
		}
	}
	
	static void merge_sort(long list[], int left, int right) {
		int mid;
		if(left < right) {
			mid = (left + right) / 2;
			merge_sort(list, left, mid);
			merge_sort(list, mid + 1, right);
			merge(list, left, mid, right);
		}
	}
	
	static int binary_search(long list[], int n, long key) {
		int low, middle, high;
		low = 0;
		high = n - 1;
		
		while(low <= high) {
			middle = (low + high) / 2;
			if(key == list[middle]) {
				return 1;
			}
			else if(key > list[middle]) {
				low = middle + 1;
			}
			else {
				high = middle - 1;
			}
		}
		return 0;
	}
}
