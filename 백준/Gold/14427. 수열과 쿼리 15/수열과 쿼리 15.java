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
		long value; 
		int index;
		public Node(long value, int index) {
			this.value = value;
			this.index = index;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		array = new long[N];
		tree = new Node[getTreeSize()];
		String[] arrString = br.readLine().split(" ");
		
		for(int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(arrString[i]);
		}
		
		init(0, N - 1, 1);
		M = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < M; i++) {
			String[] command = br.readLine().split(" ");
			
			if(command.length == 3) {
				update(0, N - 1, 1, Integer.parseInt(command[1]) - 1, Integer.parseInt(command[2]));
			}else {
				bw.write(tree[1].index + 1 + "\n");
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
			return tree[treeIdx] = new Node(array[start], start);
		}
		
		int mid = (start + end) / 2;
		
		Node leftNode = init(start, mid, treeIdx * 2);
		Node rightNode = init(mid + 1, end, treeIdx * 2 + 1);
		Node nextNode;
		
		if(leftNode.value < rightNode.value) {
			nextNode = leftNode;
		}else if(rightNode.value < leftNode.value) {
			nextNode = rightNode;
		}else {
			if(leftNode.index < rightNode.index) {
				nextNode = leftNode;
			}else {
				nextNode = rightNode;
			}
		}
		
		return tree[treeIdx] = nextNode;
	}
	
	static void update(int start, int end, int treeIdx, int arrayIdx, int change) {
		if(arrayIdx < start || arrayIdx > end) {
			return;
		}
		
		if(start == end) {
			tree[treeIdx] = new Node(change, arrayIdx);
			return;
		}
		
		int mid = (start + end) / 2;
		
		update(start, mid, treeIdx * 2, arrayIdx, change);
		update(mid + 1, end, treeIdx * 2 + 1, arrayIdx, change);
		
		Node leftNode = tree[treeIdx * 2];
		Node rightNode = tree[treeIdx * 2 + 1];

		if(leftNode.value < rightNode.value) {
			tree[treeIdx] = leftNode;
		}else if(rightNode.value < leftNode.value) {
			tree[treeIdx] = rightNode;
		}else {
			if(leftNode.index < rightNode.index) {
				tree[treeIdx] = leftNode;
			}else {
				tree[treeIdx] = rightNode;
			}
		}
	}
}
