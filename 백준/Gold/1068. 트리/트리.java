import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static LinkedList<Integer>[] tree;
	static int countLeafNode = 0;
	
	public static void main(String[] args) {
		int N = scanner.nextInt();
		tree = new LinkedList[N];
		int[] parentNode = new int[N];
		int top = -1;
		
		for(int i = 0; i < N; i++) {
			tree[i] = new LinkedList<Integer>();
		}
		
		for(int i = 0; i < N; i++) {
			parentNode[i] = scanner.nextInt();
			
			if(parentNode[i] != -1) {
				tree[parentNode[i]].add(i);
			}else {
				top = i;
			}
		}
		
		int removeNode = scanner.nextInt();
		
		if(removeNode == top) {
			System.out.println(0);
		}else {
			Iterator<Integer> iter = tree[parentNode[removeNode]].iterator();
			int index = 0;
			
			while(iter.hasNext()) {
				int childNode = iter.next();
				
				if(childNode == removeNode) {
					tree[parentNode[removeNode]].remove(index);
					break;
				}
				
				index++;
			}
			
			findLeafNode(top);
			System.out.println(countLeafNode);
		}
	}
	
	static void findLeafNode(int node) {
		if(tree[node].size() == 0) {
			countLeafNode++;
			return;
		}else {
			Iterator<Integer> iter = tree[node].iterator();
			
			while(iter.hasNext()) {
				int childNode = iter.next();
				findLeafNode(childNode);
			}
		}
	}
}
