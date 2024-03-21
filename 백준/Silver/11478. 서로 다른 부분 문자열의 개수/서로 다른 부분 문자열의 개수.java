import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		String input = scanner.next();
		
		int length = input.length();
		
		HashSet<String> hashset = new HashSet<>();
		
		for(int i = 1; i <= length; i++) { // 1 ~ 5
			for(int j = 0; j < length; j++) { // 
				if(j + i >= length) {
					if(!hashset.contains(input.substring(j))) {
						hashset.add(input.substring(j));
					}
				}else {
					if(!hashset.contains(input.substring(j, j + i))) {
						hashset.add(input.substring(j , j + i));
					}
				}
			}
		}
		
		bw.write(Integer.toString(hashset.size()));
		bw.flush();
		bw.close();
	}
}
