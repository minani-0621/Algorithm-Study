import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static ArrayList<Integer> sanggeunCards = new ArrayList<>(); // 상근이가 가지고 있는 카드 리스트
	static HashMap<Integer, Integer> sanggeunFreq = new HashMap<>(); // 상근이가 기지고 있는 카드의 숫자별 갯수 관리 hashmap
	static int n, m;
	
	
	public static void main(String[] args) throws IOException {
		n = scanner.nextInt();
		
		// 상근이가 가지고 있는 숫자카드 n개를 sanggeunCards에 모두 추가한다
		for(int i = 0; i < n; i++) {
			sanggeunCards.add(scanner.nextInt());
		}
		
		// n개의 숫자들 중에서 차례대로 한 숫자에 대해서 그 숫자를 상근이가 몇 개 가지고 있는지 저장하는 sanggeunFreq 구현한다.
		for(int i = 0; i < n; i++) {
			if(!sanggeunFreq.containsKey(sanggeunCards.get(i))) { // sanggeunFreq에 들어있지 않은 숫자이면
				sanggeunFreq.put(sanggeunCards.get(i), 1); // (해당 숫자, 1)의 쌍 값 sanggeunFreq에 추가
			}else if(sanggeunFreq.containsKey(sanggeunCards.get(i))) { // sanggeunFreq에 이미 들어있는 숫자라면
				sanggeunFreq.replace(sanggeunCards.get(i), sanggeunFreq.get(sanggeunCards.get(i)) + 1); // 해당 숫자의 hashmap 값을 1 증가시켜 업데이트 
			}
		}
		
		m = scanner.nextInt();
		
		for(int i = 0; i < m; i++) {
			int checkNum = scanner.nextInt();
			if(!sanggeunFreq.containsKey(checkNum)) { // 체크하는 숫자가 sanggeunFreq에 없으면 0 출력
				bw.write(0 + " ");
			}else if(sanggeunFreq.containsKey(checkNum)) { // 체크하는 숫자가 sanggeunFreq에 있으면 체크숫자에 대응되는 값 출력
				bw.write(sanggeunFreq.get(checkNum) + " ");
			}
		}
		
		bw.flush();
		bw.close();
	}
}
