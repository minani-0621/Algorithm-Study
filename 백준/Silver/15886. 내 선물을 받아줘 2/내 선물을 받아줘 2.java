import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws Throwable, IOException {
		int N = Integer.parseInt(br.readLine());
		String map = br.readLine();
		
		int appleCount = 0;
		
		for(int i = 0; i < N - 1; i++) {
			if(map.charAt(i) == 'E' && map.charAt(i + 1) == 'W') {
				appleCount++;
			}
		}
		
		System.out.println(appleCount);
	}
	
}
