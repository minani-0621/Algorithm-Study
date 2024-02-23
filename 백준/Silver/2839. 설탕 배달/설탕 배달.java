import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/*
 * 주어진 킬로그램의 설탕을 3킬로그램 봉지와 5킬로그램 봉지로 나눠 담을 때, 두 종류의 봉지의 수의 합이 최소가 되는 것을 찾기 위해서
 * ArrayList를 이용해 모든 가능한 케이스들의 두 종류 봉지 개수의 합을 저장한다. 그리고 ArrayList를 오름차순으로 정렬해서 두 종류의
 * 봉지의 개수 합이 가장 작은 ArrayList의 첫번째 요소를 출력한다.
*/
public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int n, cnt5, cnt3;
	static ArrayList<Integer> possibleCase = new ArrayList<>(); // 배달 가능한 모든 케이스들의 3킬로그램 봉지 개수와 5킬로그램 봉지 개수의 합
	
	public static void main(String[] args) {
		n = scanner.nextInt();
		
		cnt5 = n / 5; // 5킬로그램 봉지의 개수를 일단 구한다
		
		while(cnt5 >= 0) { // 5킬로그램 봉지의 개수가 최대일때무터 최소가 될때까지의 오든 경우를 확인한다
			if((n - cnt5 * 5) % 3 == 0) { // 임의의 5킬로그램 봉지의 개수가 정해졌을 때 남은 설탕을 3킬로그램 봉지로 딱 나누어 떨어지게 담을 수 있으면
				cnt3 = (n - cnt5 * 5) / 3;
				possibleCase.add(cnt5 + cnt3); // 5킬로그램 봉지의 개수와 3킬로그램 봉지의 개수의 합을 ArrayList에 저장
			}
			
			cnt5--; // 5킬로그램 봉지의 개수를 한개 줄이고 그 다음 케이스를 살펴본다
		}
		
		Collections.sort(possibleCase); // 가능한 모든 케이스들의 두 종류의 봉지 개수의 합을 작은것부터 나오게 오름차순 정렬
		
		if(possibleCase.size() == 0) { // 가능한 케이스가 하나도 없으면 -1을 출력
			System.out.println("-1");
		}else { // 가능한 케이스가 최소 1개 이상 있으면, 가장 적은 봉지 개수의 합 출력
			System.out.println(possibleCase.get(0));
		}
	}
}
