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
		
		for(int i = 1; i <= length; i++) { // 문자열 길이가 1인것부터 input 스트링의 길이와 동일한 것까지
			for(int j = 0; j < length; j++) { // input 스트링을 substring()을 적용할 때, 시작 인덱스
				if(j + i >= length) { // (시작 인덱스 + 찾고자 하는 스트링의 길이) 가 input 스트링의 인덱스 범위를 벗어날 때
					if(!hashset.contains(input.substring(j))) {
						hashset.add(input.substring(j));
					}
				}else { // (시작 인덱스 + 찾고자 하는 스트링의 길이) 가 input 스트링의 인덱스 범위를 벗어나지 않을 때
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
