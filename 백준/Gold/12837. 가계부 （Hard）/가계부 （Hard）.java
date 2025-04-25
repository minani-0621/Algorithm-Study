import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N, Q;
	static long[] tree;
	
	public static void main(String[] args) throws IOException {
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		Q = Integer.parseInt(input[1]);
		tree = new long[getTreeSize()];
		
		for(int i = 0; i < Q; i++) {
			String[] info = br.readLine().split(" ");
			int command = Integer.parseInt(info[0]);
			
			if(command == 1) {
				int p = Integer.parseInt(info[1]);
				int x = Integer.parseInt(info[2]);
				update(0, N - 1, 1, p - 1, x);
			}else if(command == 2) {
				int p = Integer.parseInt(info[1]);
				int q = Integer.parseInt(info[2]);
				bw.write(partSum(0, N - 1, 1, p - 1, q - 1) + "\n");
			}
		}
		
		bw.flush();
		bw.close();
	}
	
	static int getTreeSize() {
		int h = (int)Math.ceil(Math.log(N) / Math.log(2));
		return (int)Math.pow(2, h + 1);
	}
	
	static void update(int start, int end, int treeIdx, int arrayIdx, long dif) {
		if(start <= arrayIdx && arrayIdx <= end) {
			tree[treeIdx] += dif;
		}else {
			return;
		}
		
		if(start == end) {
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
