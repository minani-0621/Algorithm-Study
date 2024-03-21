import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		int exceptPeople = (int)Math.round(n * 0.15);
		int levelArray[] = new int[n];
		
		for(int i = 0; i < n; i++) {
			levelArray[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(levelArray);
		
		int sum = 0;
		for(int i = exceptPeople; i < n - exceptPeople; i++) {
			sum += levelArray[i];
		}
		
		int finalLevel = (int)Math.round((double)sum / (double)(n - exceptPeople * 2));
		
		bw.write(Integer.toString(finalLevel));
		bw.flush();
		bw.close();
	}
}
