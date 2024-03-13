import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		int t = scanner.nextInt();
		
		for(int i = 0; i < t; i++) {
			int x1, y1, r1, x2, y2, r2;
			
			x1 = scanner.nextInt();
			y1 = scanner.nextInt();
			r1 = scanner.nextInt();
			x2 = scanner.nextInt();
			y2 = scanner.nextInt();
			r2 = scanner.nextInt();
			
			double d = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2)); // 두 점 사이의 거리
			
			if(x1 == x2 && y1 == y2) { // 두 점이 같으면
				if(r1 == r2) {
					bw.write("-1\n");
				}else if(r1 != r2){
					bw.write("0\n");
				}
			}else if(x1 != x2 || y1 != y2) { // 두 점이 다르면
				if(r1 + r2 < d || Math.abs(r1 - r2) > d) {
					bw.write("0\n");
				}else if(r1 + r2 == d || Math.abs(r1 - r2) == d) {
					bw.write("1\n");
				}else if(r1 + r2 > d || Math.abs(r1 - r2) < d) {
					bw.write("2\n");
				}
			}
		}
		
		bw.flush();
		bw.close();
	}
}
