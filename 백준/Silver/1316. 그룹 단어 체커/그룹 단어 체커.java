import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/*
이 문제 전략 -> 그룹단어인지 아닌지 확인하는 방법으로, 한 단어를 String array[]에 한 단어씩 저장 후, 연달아서 나오는 단어는 한 단어로 취급되도록 새로운 문자열을 ArrayList<String> word에 저장.
그리고 어레이리스트에 있는 한 단어의 빈도 수를 체크할 수 있는 Collections.frequency()를 사용해서 어레이리스트의 저장된 모든 단어들의 빈도 수를 확인한다. 단 하나의 단어라도 빈도수가 2 이상이 나오면
그룹단어가 아님을 의미하므로 그룹단어가 아닌 단어갯수를 세는 count 변수를 1씩 증가시킨다. 최종적으로, 전체 입력 단어 수(변수 n) - 그룹 단어가 아닌 단어(변수 count)를 출력하면 된다.
*/
public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int n;
	static int count = 0;
	static String s;
	static String array[];
	static ArrayList<String> word = new ArrayList<String>();
	
	public static void main(String[] args) {
		n = scanner.nextInt();
		
		for(int i = 0 ; i < n; i++) {
			word.clear();
			
			s = scanner.next();
			array = new String[s.length()];
			
			for(int j = 0; j < s.length(); j++) {
				array[j] = s.substring(j, j + 1);
			}
			
			int index = 0;
			loop:
			while(index < array.length) {
				word.add(array[index]);
				
				if(index == array.length - 1) {
					break loop;
				}
				
				while(index < array.length - 1 && array[index].equals(array[index + 1])) {
					index++;
				}
				index++;
			}
			loop:
			for(String str: word) {
				int frequency = Collections.frequency(word, str);
				if(frequency >= 2) {
					count++;
					break loop;
				}
			}		
		}
		System.out.printf("%d", n - count);
	}
}
