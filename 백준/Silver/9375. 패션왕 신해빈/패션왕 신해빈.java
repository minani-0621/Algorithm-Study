import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Scanner;
/*
 * 이 문제에서 입력으로 의상 이름과 의상 종류가 들어온다. 이 들어오는 입력을 의상 종류별로 카운팅한 데이터를 
 * HashMap에 저장한다. 의상 종류를 기준으로 해빈이가 입을 수 있는 의상들의 조합을 구하는 문제이기 때문에 의상
 * 이름은 이 문제에선 중요한지 않다. 어떤 한 의상 종류가 3개라고 했을 때, 이 의상 종류를 입는 방법으로는 이
 * 의상 종류는 아예 안 입거나, 3개의 의상 중 하나를 입을 수 있기 때문에 가능한 총 경우의 수는 4가지이다.
 * 모든 종류의 의상의 경우의 수를 모두 곱하면 전체 경우의 수가 나오게 되는데, 모든 의상 종류를 하나도 입지 않은
 * 벌거벗은 상태는 허용되지 않기 때문에 (전체 경우의 수 - 1)이 답이 되게 된다.
*/
public class Main {
	static Scanner scanner = new Scanner(System.in);
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		int testCase = scanner.nextInt();
		
		if(testCase == 0) { // 테스트케이스가 0일 경우
			bw.write("0");
		}else { // 테스트케이스가 1~100개일 경우
			for(int i = 0; i < testCase; i++) {
				int n = scanner.nextInt();

				HashMap<String, Integer> hashmap = new HashMap<>();
				
				for(int j = 0; j < n; j++) {
					scanner.next(); // 의상 이름
					String type = scanner.next(); // 의상 종류
					
					if(hashmap.containsKey(type)) { // hashmap에 이미 저장되어 있는 의상 종류이면
						hashmap.replace(type, hashmap.get(type) + 1); // value 값을 1 증가
					}else { // hashmap에 저장되어 있지 않은 의상 종류이면
						hashmap.put(type, 1); // 새로 추가
					}
				}
				
				int caseCount = 1;
				for(String key: hashmap.keySet()) {
					caseCount *= (hashmap.get(key) + 1);
				}
				
				bw.write(caseCount - 1 + "\n");
			}
		}
		
		bw.flush();
		bw.close();
	}
}
