import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static ArrayList<String> array =  new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		int n = scanner.nextInt();
		
		for(int i = 0; i < n; i++) {
			String input = scanner.next();
			array.add(input);
		}
		
		Collections.sort(array, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// 정렬 첫번째 기준(길이가 다르면 짧은 것을 앞으로 정렬)
				if(o1.length() != o2.length()) {
					return o1.length() - o2.length();
				}else { // (o1.length() == o2.length())
					int sumO1 = 0;
					int sumO2 = 0;
					
					for(int i = 0; i < o1.length(); i++) {
						if(o1.charAt(i) >= 48 && o1.charAt(i) <= 57) { // 정수 0~9까지에 해당하는 아스키 모드는 48~57 이다.
							sumO1 += Character.getNumericValue(o1.charAt(i));
						}
						
						if(o2.charAt(i) >= 48 && o2.charAt(i) <= 57) {
							sumO2 += Character.getNumericValue(o2.charAt(i));
						}
					}
					// 정렬 두번째 기준(숫자인 것만 더해서 합이 작은것부터 앞으로 정렬)
					if(sumO1 != sumO2) {
						return sumO1 - sumO2;
					}else { // (sumO1 == sumO2)
						//정렬 세번째 기준(첫번째, 두번째 기준으로도 우선순위를 못 매기면 사전순으로 정렬)
						if(o1.compareTo(o2) > 0) { // o1.compareTo(o2)가 양수이면 o1이 o2보다 사전적으로 앞선 경우
							return 1;
						}else if(o1.compareTo(o2) < 0) { // o1.compareTo(o2)가 음수이면 o2가 o1보다 사전적으로 앞선 경우
							return -1;
						}else { // o1.compareTo(o2)가 0이면 사전적으로 동등한 위치이므로 0을 반환하면 된다
							return 0;
						}
					}
				}
			}
		});
		
		for(int i = 0; i < n; i++) {
			bw.write(array.get(i) + "\n");
		}
		
		bw.flush();
		bw.close();
	}
}
