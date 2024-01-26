import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int n;
	static int numList[];
	static ArrayList<Integer> maxFrequency = new ArrayList<>();
	static HashMap<Integer, Integer> hashmap = new HashMap<>();
	
	public static void main(String[] args) {
		n = scanner.nextInt();
		numList = new int[n];
		
		for(int i = 0; i < n; i++) {
			numList[i] = scanner.nextInt();
		}
		
		Arrays.sort(numList); // 오름차순으로 정렬
		
		System.out.println(findArithmeticMean(numList));
		System.out.println(findMedian(numList));
		System.out.println(findMode(numList));
		System.out.println(findRange(numList));
	}
	
	static int findArithmeticMean(int numList[]) { // 산술평균 구하는 함수
		double sum = 0;
		
		for(int i = 0; i < numList.length; i++) {
			sum += numList[i];
		}
		
		sum = sum / numList.length;
		int arithmeticMean = (int)Math.round(sum);
		
		return arithmeticMean;
	}
	
	static int findMedian(int numList[]) { // 중앙값을 구하는 함수
		int median, index;
		index = numList.length / 2;
		median = numList[index];
		
		return median;
	}
	
	static int findMode(int numList[]) { // 최빈값을 구하는 함수
		for(int i = 0; i < numList.length; i++) {
			if(!hashmap.containsKey(numList[i])) {
				hashmap.put(numList[i], 1);
			}else {
				hashmap.replace(numList[i], hashmap.get(numList[i]) + 1);
			}
		}
		
		int biggerFreq = 0;
		for(Entry<Integer, Integer> entry: hashmap.entrySet()) {
			if(entry.getValue() > biggerFreq) {
				maxFrequency.clear();
				maxFrequency.add(entry.getKey());
				biggerFreq = entry.getValue();
			}else if(entry.getValue() == biggerFreq){
				maxFrequency.add(entry.getKey());
			}
		}
		
		Collections.sort(maxFrequency);
		
		if(maxFrequency.size() >= 2) {
			return maxFrequency.get(1);
		}else {
			return maxFrequency.get(0);
		}
	}
	
	static int findRange(int numList[]) { // 범위를 구하는 함수
		int range, least, most;
		least = numList[0];
		most = numList[numList.length - 1];
		range = most - least;
		
		return range;
	}
}
