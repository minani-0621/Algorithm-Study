import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static boolean[] visited;
	static class Node {
		int x, calcCount;
		ArrayList<Integer> array;
		public Node(int x, int calcCount, ArrayList<Integer> array) {
			this.x = x;
			this.calcCount = calcCount;
			this.array = array;
		}
	}
	
	public static void main(String[] args) {
		int N = scanner.nextInt();
		visited = new boolean[N + 1];
		
		Node answerNode = bfs(N);
		System.out.println(answerNode.calcCount);
		
		for(int num: answerNode.array) {
			System.out.print(num + " ");
		}
	}
	
	static Node bfs(int x) {
		Queue<Node> queue = new LinkedList<>();
		ArrayList<Integer> array = new ArrayList<>();
		array.add(x);
		queue.offer(new Node(x, 0, array));
		visited[x] = true;
		
		
		while(!queue.isEmpty()) {
			Node checkNode = queue.poll();
			
			if(checkNode.x == 1) {
				return checkNode;
			}
			
			if(checkNode.x % 3 == 0 && !visited[checkNode.x / 3]) {
				ArrayList<Integer> newArray = new ArrayList<>(checkNode.array);
				newArray.add(checkNode.x / 3);
				queue.offer(new Node(checkNode.x / 3, checkNode.calcCount + 1, newArray));
				visited[checkNode.x / 3] = true;
			}
			
			if(checkNode.x % 2 == 0 && !visited[checkNode.x / 2]) {
				ArrayList<Integer> newArray = new ArrayList<>(checkNode.array);
				newArray.add(checkNode.x / 2);
				queue.offer(new Node(checkNode.x / 2, checkNode.calcCount + 1, newArray));
				visited[checkNode.x / 2] = true;
			}
			
			if(!visited[checkNode.x - 1]) {
				ArrayList<Integer> newArray = new ArrayList<>(checkNode.array);
				newArray.add(checkNode.x - 1);
				queue.offer(new Node(checkNode.x - 1, checkNode.calcCount + 1, newArray));
				visited[checkNode.x - 1] = true;
			}
		}
		
		return null;
	}
}
