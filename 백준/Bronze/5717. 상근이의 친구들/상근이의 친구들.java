import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		while(true) {
			String input = br.readLine();
			String[] inputArr = input.split(" ");
			
			int boyfriend = Integer.parseInt(inputArr[0]);
			int girlfriend = Integer.parseInt(inputArr[1]);
			
			if(boyfriend == 0 && girlfriend == 0) {
				break;
			}else {
				System.out.println(boyfriend + girlfriend);
			}		
		}
	}
}
