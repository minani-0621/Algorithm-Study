import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		
		ArrayList<Integer> array1 = new ArrayList<>();
		ArrayList<Integer> array2 = new ArrayList<>();
		ArrayList<Integer> mergeArray = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			array1.add(scanner.nextInt());
		}
		
		for(int i = 0; i < m; i++) {
			array2.add(scanner.nextInt());
		}
		
		int index1 = 0;
		int index2 = 0;
		
		while(index1 != n || index2 != m) {
			if(index1 == n) {
				mergeArray.add(array2.get(index2));
				index2++;
			}else if(index2 == m) {
				mergeArray.add(array1.get(index1));
				index1++;
			}else {
				if(array1.get(index1) <= array2.get(index2)) {
					mergeArray.add(array1.get(index1));
					index1++;
				}else if(array2.get(index2) <= array1.get(index1)) {
					mergeArray.add(array2.get(index2));
					index2++;
				}
			}
		}
		
		for(int num: mergeArray) {
			bw.write(num + " ");
		}
		
		bw.flush();
		bw.close();
	}
}
