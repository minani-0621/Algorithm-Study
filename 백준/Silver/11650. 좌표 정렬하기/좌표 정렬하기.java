import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int n;
	static int coordinate[][];
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		n = scanner.nextInt();
		coordinate = new int[n][2];
		
		for(int i = 0; i < n; i++) {
			coordinate[i][0] = scanner.nextInt();
			coordinate[i][1] = scanner.nextInt();
		}
		
		Arrays.sort(coordinate, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] != o2[0]) { // x좌표가 서로 다를 때
					return o1[0] - o2[0]; // x좌표를 기준 오름차순으로
				}else { // x좌표가 서로 같을 때
					return o1[1] - o2[1]; // y좌표를 기준 오름차순으로
				}
			}
		});
		
		for(int i = 0; i < n; i++) {
			bw.write(coordinate[i][0] + " " + coordinate[i][1] + "\n");
		}
		
		bw.flush();
		bw.close();
	}
}
