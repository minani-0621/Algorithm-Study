import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		int n = scanner.nextInt();
		int a[] = new int[n];
		int x = scanner.nextInt();
		
		for(int i = 0; i < n; i++) {
			a[i] = scanner.nextInt();
			if(a[i] < x) {
				bw.write(a[i] + " ");
			}
		}
		
		bw.flush();
		bw.close();
	}
}
