import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int n, m;
	static String url, password;
	static HashMap<String, String> memo = new HashMap<>();
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		n = scanner.nextInt();
		m = scanner.nextInt();
		
		for(int i = 0; i < n; i++) {
			url = scanner.next();
			password = scanner.next();
			
			memo.put(url, password);
		}
		
		for(int i = 0; i < m; i++) {
			url = scanner.next();
			bw.write(memo.get(url) + "\n");
		}
		
		bw.flush();
		bw.close();
	}
}
