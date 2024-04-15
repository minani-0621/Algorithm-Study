import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int n;
	static char inputMap[][], resultMap[][];
	
	public static void main(String[] args) throws IOException {
		n = scanner.nextInt();
		inputMap = new char[n][n];
		resultMap = new char[n][n];
		
		for(int i = 0; i < n; i++) {
			String inputLine = scanner.next();
			for(int j = 0; j < n; j++) {
				inputMap[i][j] = inputLine.charAt(j);
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				// 지뢰가 없는 블록은 주변 8개 블록의 지뢰 개수를 카운팅.
				if(inputMap[i][j] == '.') {
					int mineCount = calcMine(i, j);
					if(mineCount >= 10) {
						resultMap[i][j] = 'M';
					}else {
						resultMap[i][j] = Character.forDigit(mineCount, 10);
					}
				// 지뢰가 있는 블록은 * 표시.
				}else {
					resultMap[i][j] = '*';
				}
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				bw.write(resultMap[i][j]);
			}
			bw.write("\n");
		}
		
		bw.flush();
		bw.close();
	}
	
	static int calcMine(int i, int j) {
		int mine = 0;
		for(int k = -1; k <= 1; k++) {
			for(int l = -1; l <= 1; l++) {
				// 확인하고 있는 블록의 주변 8개 블록 각각의 위치가 맵의 범위를 벗어나면 안되고, 지뢰가 있는 부분만 검사 후 카운팅하면 된다.
				if(i + k >= 0 && i + k < n && j + l >= 0 && j + l < n && inputMap[i + k][j + l] != '.') {
					// inputMAp[i + k][j - l]은 char형 이므로 char인 '0'을 빼줘야 해당하는 int값이 나온다.
					mine += (inputMap[i + k][j + l] - '0');
				}
			}
		}
		return mine;
	}
}
