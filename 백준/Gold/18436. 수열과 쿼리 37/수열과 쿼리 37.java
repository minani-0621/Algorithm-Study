import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N, M;
	static long[] array, tree;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		array = new long[N];
		tree = new long[getTreeSize()];
		
		String[] arrString = br.readLine().split(" ");
		
		for(int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(arrString[i]);
		}
		
		initOdd(0, N - 1, 1);
		M = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < M; i++) {
			String[] query = br.readLine().split(" ");
			int command = Integer.parseInt(query[0]);
			
			if(command == 1) {
				int target = Integer.parseInt(query[1]);
				int x = Integer.parseInt(query[2]);
				updateOdd(0, N - 1, 1, target - 1, x);
				array[target - 1] = x;
			}else if(command == 2) {
				int l = Integer.parseInt(query[1]);
				int r = Integer.parseInt(query[2]);
				bw.write((r - l + 1) - partOddCount(0, N - 1, 1, l - 1, r - 1) + "\n");
			}else if(command == 3) {
				int l = Integer.parseInt(query[1]);
				int r = Integer.parseInt(query[2]);
				bw.write(partOddCount(0, N - 1, 1, l - 1, r - 1) + "\n");
			}
		}
		
		bw.flush();
		bw.close();
	}
	
	static int getTreeSize() {
		int h = (int)Math.ceil(Math.log(N) / Math.log(2));
		return (int)Math.pow(2, h + 1);
	}
	
	static long initOdd(int start, int end, int treeIdx) {
		if(start == end) {
			if(array[start] % 2 == 1) {
				return tree[treeIdx] = 1;
			}else {
				return tree[treeIdx] = 0;
			}
		}
		
		int mid = (start + end) / 2;
		
		return tree[treeIdx] = initOdd(start, mid, treeIdx * 2) + initOdd(mid + 1, end, treeIdx * 2 + 1);
	}
	
	static long updateOdd(int start, int end, int treeIdx, int arrayIdx, int change) {
		if(arrayIdx < start || arrayIdx > end) {
			return tree[treeIdx];
		}
		
		if(start == end) {			
			if(change % 2 == 0) {
				return tree[treeIdx] = 0;
			}else {
				return tree[treeIdx] = 1;
			}
		}
		
		int mid = (start + end) / 2;
		
		return tree[treeIdx] = updateOdd(start, mid, treeIdx * 2, arrayIdx, change) + updateOdd(mid + 1, end, treeIdx * 2 + 1, arrayIdx, change);
	}
	
	static long partOddCount(int start, int end, int treeIdx, int l, int r) {
		if(start > r || end < l) {
			return 0;
		}
		
		if(l <= start && end <= r) {
			return tree[treeIdx];
		}
		
		int mid = (start + end) / 2;
		
		return partOddCount(start, mid, treeIdx * 2, l, r) + partOddCount(mid + 1, end, treeIdx * 2 + 1, l, r);
	}
}
