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
		
		init(0, N - 1, 1);
		
		M = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < M; i++) {
			String[] info = br.readLine().split(" ");
			int command = Integer.parseInt(info[0]);
			int a = Integer.parseInt(info[1]);
			int b = Integer.parseInt(info[2]);
			
			if(command == 1) {
				update(0, N - 1, 1, a - 1, b);
				array[a - 1] = b;
			}else if(command == 2) {
				bw.write(partMin(0, N - 1, 1, a - 1, b - 1) + "\n");
			}
		}
		
		bw.flush();
		bw.close();
	}
	
	static int getTreeSize() {
		int h = (int)Math.ceil(Math.log(N) / Math.log(2)) + 1;
		return (int)Math.pow(2, h) - 1;
	}
	
	static long init(int start, int end, int treeIdx) {
		if(start == end) {
			return tree[treeIdx] = array[start];
		}
		
		int mid = (start + end) / 2;
		
		return tree[treeIdx] = Math.min(init(start, mid, treeIdx * 2), init(mid + 1, end, treeIdx * 2 + 1));
	}
	
	static long update(int start, int end, int treeIdx, int arrayIdx, long value) {
		if(arrayIdx < start || arrayIdx > end) {
			return tree[treeIdx];
		}
		
		if(start == end) {
			return tree[treeIdx] = value;
		}
		
		int mid = (start + end) / 2;
		
		return tree[treeIdx] = Math.min(update(start, mid, treeIdx * 2, arrayIdx, value), update(mid + 1, end, treeIdx * 2 + 1, arrayIdx, value));		
	}
	
	static long partMin(int start, int end, int treeIdx, int l, int r) {
		if(start > r || end < l) {
			return Long.MAX_VALUE;
		}
		
		if(l <= start && end <= r) {
			return tree[treeIdx];
		}
		
		int mid = (start + end) / 2;
		
		return Math.min(partMin(start, mid, treeIdx * 2, l, r), partMin(mid + 1, end, treeIdx * 2 + 1, l, r));
	}
}
