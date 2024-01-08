import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static ArrayList<String> array = new ArrayList<>(Arrays.asList("black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"));
	static String input1, input2, input3;
	static long value1, value2, value3, result;
	
	public static void main(String[] args) {
		input1 = scanner.next();
		value1 = array.indexOf(input1);
		
		input2 = scanner.next();
		value2 = array.indexOf(input2);
		
		input3 = scanner.next();
		value3 = (long)Math.pow(10, array.indexOf(input3));
		
		result = Integer.parseInt(Long.toString(value1).concat(Long.toString(value2))) * value3;
		
		System.out.printf("%d", result);
	}
}
