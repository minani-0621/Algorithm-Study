import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static HashSet<String> hashset = new HashSet<>();
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int n;
	
	public static void main(String[] args) throws IOException {
		n = scanner.nextInt();
		
		for(int i = 0; i < n; i++) {
			String name = scanner.next();
			String workingState = scanner.next();
			// HashSet은 이미 있는 값을 추가하면 중복으로 추가를 방지하고, set에 없는 값을 제거하려하면 제거가 안되기 때문에 workingState에 맞게 처리만 신경쓰면 됨.
			if(workingState.equals("enter")) {
				hashset.add(name);
			}else {
				hashset.remove(name);
			}
		}
		
		//HashSet은 Collectios.sort()가 불가능하므로 hashset 요소들을 ArrayList 변환
		ArrayList<String> array = new ArrayList<>(hashset);
		// 변환 후 reverseOrder()를 이용하여 사전 역순으로 정렬
		Collections.sort(array, Collections.reverseOrder());
		
		for(String name: array) {
			bw.write(name + "\n");
		}
		
		bw.flush();
		bw.close();
	}
}
