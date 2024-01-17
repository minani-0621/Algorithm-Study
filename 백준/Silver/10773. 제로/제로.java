import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int k, inputNum, sum;
	static ArrayList<Integer> list = new ArrayList<>();
	
	public static void main(String[] args) {
		k = scanner.nextInt();
		
		for(int i = 0; i < k; i++) {
			inputNum = scanner.nextInt();
			if(inputNum == 0) {
				list.remove(list.size() - 1);
			}else {
				list.add(inputNum);
			}
		}
		
		sum = 0;
		
		for(int i = 0; i < list.size(); i++) {
			sum += list.get(i);
		}
		
		System.out.println(sum);
	}
}
