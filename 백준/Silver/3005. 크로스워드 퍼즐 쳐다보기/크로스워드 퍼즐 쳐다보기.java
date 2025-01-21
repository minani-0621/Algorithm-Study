import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int R, C;
	static char[][] puzzle;
	static char[][] verticalPuzzle;
	static HashSet<String> hashset = new HashSet<>();
	
	public static void main(String[] args) throws IOException {
		String[] size = br.readLine().split(" ");
		R = Integer.parseInt(size[0]);
		C = Integer.parseInt(size[1]);
		puzzle = new char[R][C];
		verticalPuzzle = new char[C][R];
		
		for(int i = 0; i < R; i++) {
			String oneLine = br.readLine();
			
			for(int j = 0; j < C; j++) {
				puzzle[i][j] = oneLine.charAt(j);
			}
		}
		
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				verticalPuzzle[j][i] = puzzle[i][j];
			}
		}
		
		for(char[] row: puzzle) {
			String rowString = new String(row);
			String[] temp = rowString.split("#");
			
			for(int i = 0; i < temp.length; i++) {
				if(temp[i].length() >= 2) {
					hashset.add(temp[i]);
				}
			}
		}
		
		for(char[] col: verticalPuzzle) {
			String colString = new String(col);
			String[] temp = colString.split("#");
			
			for(int i = 0; i < temp.length; i++) {
				if(temp[i].length() >= 2) {
					hashset.add(temp[i]);
				}
			}
		}
		
		List<String> sortedList = new ArrayList<>(hashset);
		Collections.sort(sortedList);
		System.out.println(sortedList.get(0));
	}
}
