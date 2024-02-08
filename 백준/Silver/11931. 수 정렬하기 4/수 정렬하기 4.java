import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int n;
	static ArrayList<Integer> array = new ArrayList<>();
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		n = scanner.nextInt();
		
		for(int i = 0; i < n; i++) {
			array.add(scanner.nextInt());
		}
		
		//내림차순은 두 번째 인자값으로 Collections.reverseOrder() 넣기
		Collections.sort(array, Collections.reverseOrder());
		
		for(Integer num: array) {
			bw.write(num + "\n");
		}
		
		bw.flush();
		bw.close();
	}
}
