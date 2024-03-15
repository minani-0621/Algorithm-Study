import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		int n = scanner.nextInt();
		int count = 0;
		// 브루트포스 방식으로 1부터 n까지 한수인지 일일이 체크
		for(int i = 1; i <= n; i++) {
			String str = Integer.toString(i); // 검사대상 숫자를 String으로 임시 변경
			
			if(str.length() == 1) { // 한자리 숫자는 그 자체로 한수에 해당
				count++;
			}else { // 두자리 이상의 숫자는 한수인지 확인
				int diff = Character.getNumericValue(str.charAt(1)) - Character.getNumericValue(str.charAt(0)); // 검사하고 있는 숫자의 첫째 숫자와 둘째 숫자의 차이를 계산
				
				for(int j = 0; j < str.length() - 1; j++) { // 이후 뒷자리의 숫자가 등차수열로 증가하는지 확인하는 과정
					if(diff != Character.getNumericValue(str.charAt(j + 1)) - Character.getNumericValue(str.charAt(j))) {
						break;
					}else if(j == str.length() - 2) { // 검사하고 있는 숫자 끝까지 등차수열인 경우
						count++;
					}
				}
			}
		}
		
		bw.write(Integer.toString(count));
		bw.flush();
		bw.close();
	}
}
