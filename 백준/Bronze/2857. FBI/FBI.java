import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		int agentCount = 0;
		
		for(int i = 0; i < 5; i++) {
			String agent = scanner.next();
			
			if(agent.contains("FBI")) {
				bw.write(i + 1 + " ");
				agentCount++;
			}
		}
		
		if(agentCount != 0) {
			bw.flush();
			bw.close();
		}else {
			bw.write("HE GOT AWAY!");
			bw.flush();
			bw.close();
		}
		
	}
}
