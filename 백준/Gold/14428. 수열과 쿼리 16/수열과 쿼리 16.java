import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N, M;
	static long[] array;
	static Node[] tree;
	
	static class Node {
		int index;
		long value;
		public Node(int index, long value) {
			 this.index = index;
			 this.value = value;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		array = new long[N];
		tree = new Node[getTreeSize()];
		String[] arrayStr = br.readLine().split(" ");
		
		for(int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(arrayStr[i]);
		}
		
			
		init(0, N - 1, 1);
		M = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < M; i++) {
			String[] input = br.readLine().split(" ");
			int command = Integer.parseInt(input[0]);
			
			if(command == 1) {
				int index = Integer.parseInt(input[1]) - 1;
				int changeValue = Integer.parseInt(input[2]);
				update(0, N - 1, 1, index, changeValue);
			}else if(command == 2) {
				int startIndex = Integer.parseInt(input[1]) - 1;
				int endIndex = Integer.parseInt(input[2]) - 1;
				Node answerNode = partMin(0, N - 1, 1, startIndex, endIndex);
				bw.write(answerNode.index + 1 + "\n");
			}
		}
		
		bw.flush();
		bw.close();
	}
	
	static int getTreeSize() {
		int h = (int)Math.ceil(Math.log(N) / Math.log(2));
		return (int)Math.pow(2, h + 1);
	}
	
	static Node init(int start, int end, int treeIdx) {
		if(start == end) {
			return tree[treeIdx] = new Node(start, array[start]);
		}
		
		int mid = (start + end) / 2;
		
		Node leftNode = init(start, mid, treeIdx * 2);
		Node rightNode = init(mid + 1, end, treeIdx * 2 + 1);
		
		if(leftNode.value < rightNode.value) {
			return tree[treeIdx] = leftNode;
		}else if(rightNode.value < leftNode.value) {
			return tree[treeIdx] = rightNode;
		}else {
			if(leftNode.index < rightNode.index) {
				return tree[treeIdx] = leftNode;
			}else {
				return tree[treeIdx] = rightNode;
			}
		}
	}
	
	static void update(int start, int end, int treeIdx, int arrayIdx, int changeValue) {
		if(arrayIdx < start || arrayIdx > end) {
			return;
		}
		
		if(start == end) {
			tree[treeIdx] = new Node(arrayIdx, changeValue);
			return;
		}
		
		int mid = (start + end) / 2;
		
		update(start, mid, treeIdx * 2, arrayIdx, changeValue);
		update(mid + 1, end, treeIdx * 2 + 1, arrayIdx, changeValue);
		
		Node leftNode = tree[treeIdx * 2];
		Node rightNode = tree[treeIdx * 2 + 1];
		
		if(leftNode.value < rightNode.value) {
			tree[treeIdx] = leftNode;
			return;
		}else if(rightNode.value < leftNode.value) {
			tree[treeIdx] = rightNode;
			return;
		}else {
			if(leftNode.index < rightNode.index) {
				tree[treeIdx] = leftNode;
				return;
			}else {
				tree[treeIdx] = rightNode;
				return;
			}
		}
	}
	
	static Node partMin(int start, int end, int treeIdx, int l, int r) {
		if(start > r || end < l) {
			return null;
		}
		
		if(l <= start && end <= r) {
			return tree[treeIdx];
		}
		
		int mid = (start + end) / 2;
		
		Node leftNode = partMin(start, mid, treeIdx * 2, l, r);
		Node rightNode = partMin(mid + 1, end, treeIdx * 2 + 1, l, r);
		
		if(leftNode == null) {
			return rightNode;
		}
		
		if(rightNode == null) {
			return leftNode;
		}
		
		if(leftNode.value < rightNode.value) {
			return leftNode;
		}else if(rightNode.value < leftNode.value) {
			return rightNode;
		}else {
			if(leftNode.index < rightNode.index) {
				return leftNode;
			}else {
				return rightNode;
			}
		}
	}
}
