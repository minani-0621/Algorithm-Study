import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static char[][] grid;
	static int n;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		n = scanner.nextInt();
		grid = new char[n][n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				grid[i][j] = scanner.next().charAt(0);
			}
		}

		dfs(0, 0, 0, grid[0][0] - 48, Integer.MAX_VALUE, ' ');
		
		System.out.println(max + " " + min);
	}
	
	static void dfs(int x, int y, int calcTemp, int operand1, int operand2, char operator) {
		if(x == n - 1 && y == n - 1) {
			calcTemp = calculator(operand1, operand2, operator);
			max = Math.max(max, calcTemp);
			min = Math.min(min, calcTemp);
			return;
		}
		
		if(operand1 != Integer.MAX_VALUE && operand2 != Integer.MAX_VALUE && operator != ' ') {
			calcTemp = calculator(operand1, operand2, operator);
			operand1 = calcTemp;
		}
		
		int[] mr = {0, 1};
		int[] mc = {1, 0};
		
		for(int i = 0; i < 2; i++) { 
			int nextX = x + mr[i];
			int nextY = y + mc[i];
			
			if(nextX >= 0 && nextX < n && nextY >= 0 && nextY < n) {
				if(grid[nextX][nextY] >= 48 && grid[nextX][nextY] <= 57) {
					if(operand1 == Integer.MAX_VALUE && operand2 == Integer.MAX_VALUE) {
						dfs(nextX, nextY, calcTemp, grid[nextX][nextY] - 48, Integer.MAX_VALUE, ' ');
					}else if(operand1 != Integer.MAX_VALUE && operand2 == Integer.MAX_VALUE) {
						dfs(nextX, nextY, calcTemp, operand1, grid[nextX][nextY] - 48, operator);
					}
					
				}else {
					dfs(nextX, nextY, calcTemp, operand1, Integer.MAX_VALUE, grid[nextX][nextY]);
				}
			}
		}
	}
	
	static int calculator(int operand1, int operand2, char operator) {
		if(operator == '+') {
			return operand1 + operand2;
		}else if(operator == '-') {
			return operand1 - operand2;
		}else if(operator == '*') {
			return operand1 * operand2;
		}else {
			throw new IllegalArgumentException("Invalid operator: " + operator);
		}
	}
}
