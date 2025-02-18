import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int N, M, result = Integer.MAX_VALUE;
	static int[][] grid;
	static class Pair{
		int x, y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static List<Pair> h = new ArrayList<>();
	static List<Pair> c = new ArrayList<>();
	static List<List<Integer>> cList = new ArrayList<>();
	
	
	public static void main(String[] args) {
		N = scanner.nextInt();
		M = scanner.nextInt();
		grid = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				grid[i][j] = scanner.nextInt();
				
				if(grid[i][j] == 1) {
					h.add(new Pair(i, j));
					
				}
				
				if(grid[i][j] == 2) {
					c.add(new Pair(i, j));
				}
			}
		}
		
		combi(-1, new ArrayList<>());
		
		for(List<Integer> target: cList) {
			int ret = 0;
			for(Pair hIdx : h) {
				int minNum = Integer.MAX_VALUE;
				for(int listNum : target) {
					int distance = Math.abs(hIdx.x - c.get(listNum).x) + Math.abs(hIdx.y - c.get(listNum).y);
					minNum = Math.min(minNum, distance);
				}
				ret += minNum;
			}
			result = Math.min(result, ret);
		}
		
		System.out.println(result);
		
	}
	
	static void combi(int s, List<Integer> v) {
		if(v.size() == M) {
			cList.add(new ArrayList<>(v));
			return;
		}
		
		for(int i = s + 1; i < c.size(); i++) {
			v.add(i);
			combi(i, v);
			v.remove(v.size() - 1);
		}
		
		return;
	}
}
