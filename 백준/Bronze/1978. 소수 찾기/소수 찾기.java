import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int count = 0;
	
	public static void main(String[] args) throws IOException {
		int n = scanner.nextInt();
		
		for(int i = 0; i < n; i++) {
			int num = scanner.nextInt();
			
			if(num == 2) {
				count++;
			}else {
				for(int j = 2; j < num; j++) {
					if(num % j == 0) {
						break;
					}
					
					if(j == num - 1) {
						count++;
					}
				}
			}
			
		}
		
		bw.write(Integer.toString(count));
		
		bw.flush();
		bw.close();
	}
}
