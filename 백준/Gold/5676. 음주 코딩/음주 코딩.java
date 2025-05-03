import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N, K;
	static long[] array, tree;
	
	public static void main(String[] args) throws IOException {
		String line;
		while((line = br.readLine()) != null) {			
			String[] input = line.split(" ");
			N = Integer.parseInt(input[0]);
			K = Integer.parseInt(input[1]);
			array = new long[N];
			tree = new long[getTreeSize()];
			
			String[] arrString = br.readLine().split(" ");
			for(int i = 0; i < N; i++) {
				array[i] = Long.parseLong(arrString[i]);
			}
			
			init(0, N - 1, 1);
			
			for(int i = 0; i < K; i++) {
				String[] info = br.readLine().split(" ");
				String command = info[0];
				
				if(command.equals("C")) {
					int I = Integer.parseInt(info[1]) - 1;
					int V = Integer.parseInt(info[2]);
					update(0, N - 1, 1, I, V);
				}else if(command.equals("P")) {
					int from = Integer.parseInt(info[1]) - 1;
					int to = Integer.parseInt(info[2]) - 1;
					long result = partMultiply(0, N - 1, 1, from, to);
					
					if(result < 0) {
						bw.write("-");
					}else if(result > 0) {
						bw.write("+");
					}else {
						bw.write("0");
					}
				}
			}
			
			bw.write("\n");
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
			if(array[start] > 0) {
				return tree[treeIdx] = 1;
			}else if(array[start] < 0) {
				return tree[treeIdx] = -1;
			}else {
				return tree[treeIdx] = 0;
			}
		}
		
		int mid = (start + end) / 2;
		
		return tree[treeIdx] = init(start, mid, treeIdx * 2) * init(mid + 1, end, treeIdx * 2 + 1);
	}
	
	static void update(int start, int end, int treeIdx, int arrayIdx, long change) {		
		if(start == end) {
			if(change > 0) {
				tree[treeIdx] = 1;
			}else if(change < 0) {
				tree[treeIdx] = -1;
			}else {
				tree[treeIdx] = 0;
			}
			return;
		}
		
		int mid = (start + end) / 2;
		
		if(arrayIdx <= mid) {
			update(start, mid, treeIdx * 2, arrayIdx, change);
		}else {
			update(mid + 1, end, treeIdx * 2 + 1, arrayIdx, change);
		}
		
		tree[treeIdx] = tree[treeIdx * 2] * tree[treeIdx * 2 + 1];
	}
	
	static long partMultiply(int start, int end, int treeIdx, int l, int r) {
		if(start > r || end < l) {
			return 1;
		}
		
		if(l <= start && end <= r) {
			return tree[treeIdx];
		}
		
		int mid = (start + end) / 2;
		
		return partMultiply(start, mid, treeIdx * 2, l , r) * partMultiply(mid + 1, end, treeIdx * 2 + 1, l, r);
	}
}
