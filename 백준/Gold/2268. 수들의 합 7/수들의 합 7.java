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
	
	public static void main(String[] args) throws IOException {
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		array = new long[N];
		tree = new long[getTreeSize()];
		
		init(0, N - 1, 1);
		
		for(int i = 0; i < M; i++) {
			String[] info = br.readLine().split(" ");
			int mode = Integer.parseInt(info[0]);
			int a = Integer.parseInt(info[1]);
			int b = Integer.parseInt(info[2]);
			
			if(mode == 0) {
				if(a < b) {
					bw.write(partSum(0, N - 1, 1, a - 1, b - 1) + "\n");
				}else {
					bw.write(partSum(0, N - 1, 1, b - 1, a - 1) + "\n");
				}
			}else if(mode == 1) {
				long dif = b - array[a - 1];
				update(0, N - 1, 1, a - 1, dif);
				array[a - 1] = b;
			}
		}
		
		bw.flush();
		bw.close();
	}
	
	static int getTreeSize() {
		int h = (int)Math.ceil(Math.log(N) / Math.log(2)) + 1;
		return (int)Math.pow(2, h);
	}
	
	static long init(int start, int end, int treeIdx) {
		if(start == end) {
			return tree[treeIdx] = array[start];
		}
		
		int mid = (start + end) / 2;
		
		return tree[treeIdx] = init(start, mid, treeIdx * 2) + init(mid + 1, end, treeIdx * 2 + 1);
	}
	
	static void update(int start, int end, int treeIdx, int arrayIdx, long dif) {
		if(start <= arrayIdx && arrayIdx <= end) {
			tree[treeIdx] += dif;
		}else {
			return;
		}
		
		if(start == end)  {
			return;
		}
		
		int mid = (start + end) / 2;
		
		update(start, mid, treeIdx * 2, arrayIdx, dif);
		update(mid + 1, end, treeIdx * 2 + 1, arrayIdx, dif);
	}
	
	static long partSum(int start, int end, int treeIdx, int l, int r) {
		if(start > r || end < l) {
			return 0;
		}
		
		if(l <= start && end <= r) {
			return tree[treeIdx];
		}
		
		int mid = (start + end) / 2;
		
		return partSum(start, mid, treeIdx * 2, l, r) + partSum(mid + 1, end, treeIdx * 2 + 1, l, r);
	}
}
