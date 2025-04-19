import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N, M;
	static long[] array, treeMin, treeMax;
	
	public static void main(String[] args) throws IOException {
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		array = new long[N];
		treeMin = new long[getTreeSize()];
		treeMax = new long[getTreeSize()];
		
		for(int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(br.readLine());
		}
		
		initMin(0, N - 1, 1);
		initMax(0, N - 1, 1);
		
		for(int i = 0; i < M; i++) {
			String[] info = br.readLine().split(" ");
			int a = Integer.parseInt(info[0]);
			int b = Integer.parseInt(info[1]);
			
			bw.write(partMin(0, N - 1, 1, a - 1, b - 1) + " ");		
			bw.write(partMax(0, N - 1, 1, a - 1, b - 1) + "\n");
		}
		
		bw.flush();
		bw.close();
	}
	
	static int getTreeSize() {
		int h = (int)Math.ceil(Math.log(N) / Math.log(2));
		return (int)Math.pow(2, h + 1);
	}
	
	static long initMin(int start, int end, int treeIdx) {
		if(start == end) {
			return treeMin[treeIdx] = array[start];
		}
		
		int mid = (start + end) / 2;
		
		return treeMin[treeIdx] = Math.min(initMin(start, mid, treeIdx * 2), initMin(mid + 1, end, treeIdx * 2 + 1));
	}
	
	static long initMax(int start, int end, int treeIdx) {
		if(start == end) {
			return treeMax[treeIdx] = array[start];
		}
		
		int mid = (start + end) / 2;
		
		return treeMax[treeIdx] = Math.max(initMax(start, mid, treeIdx * 2), initMax(mid + 1, end, treeIdx * 2 + 1));
	}
	
	static long partMin(int start, int end, int treeIdx, int l, int r) {
		if(start > r || end < l) {
			return Long.MAX_VALUE;
		}
		
		if(l <= start && end <= r) {
			return treeMin[treeIdx];
		}
		
		int mid = (start + end) / 2;
		
		return Math.min(partMin(start, mid, treeIdx * 2, l, r), partMin(mid + 1, end, treeIdx * 2 + 1, l, r));
	}
	
	static long partMax(int start, int end, int treeIdx, int l, int r) {
		if(start > r || end < l) {
			return Long.MIN_VALUE;
		}
		
		if(l <= start && end <= r) {
			return treeMax[treeIdx];
		}
		
		int mid = (start + end) / 2;
		
		return Math.max(partMax(start, mid, treeIdx * 2, l, r), partMax(mid + 1, end, treeIdx * 2 + 1, l, r));
	}
}
