import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int n;
	static int x, y;
	static int coordinate[][];
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		n = scanner.nextInt();
		coordinate = new int[n][2];
		
		for(int i = 0; i < n; i++) {
			x = scanner.nextInt();
			y = scanner.nextInt();
			coordinate[i][0] = x;
			coordinate[i][1] = y;
		}
		
		Arrays.sort(coordinate, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] != o2[1]) // y좌표가 서로 다를 때
					return o1[1] - o2[1]; // y좌표 기준으로 오름차순 정렬
				else // o1[1] == o2[1] (y좌표가 서로 같을 때)
					return o1[0] - o2[0]; // x좌표를 기준으로 오름차순 정렬
			}
		});
		
		for(int i = 0; i < n; i++) {
			bw.write(coordinate[i][0] + " " + coordinate[i][1] + "\n");
		}
		bw.flush();
		bw.close();		
	}
}
