import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int n;
	static long count = 0;
//	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		n = scanner.nextInt();
		
		Hanoi(n, 1, 3, 2);
		System.out.println(count);
		System.out.println(sb);
//		bw.flush();
//		bw.close();
	}
	
	static void Hanoi(int n, int src, int dst, int tmp) throws IOException {
		if(n > 0) {
			Hanoi(n - 1, src, tmp, dst);
			sb.append(src + " ");
			sb.append(dst + "\n");
//			bw.write(Integer.toString(src).concat(" "));
//			bw.write(Integer.toString(dst).concat("\n"));
			count++;
			Hanoi(n - 1, tmp, dst, src);
		}
		
	}
}
