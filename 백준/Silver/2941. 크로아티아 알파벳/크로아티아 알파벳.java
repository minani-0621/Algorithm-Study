import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static String string;
	static int count = 0;

	public static void main(String[] args) {
		string = scanner.next();
		int i = 0;
		
		while(i < string.length()) {			
			if (i + 1 < string.length() && string.substring(i, i + 2).equals("c=")) {
                count++;
                i += 2;
            } else if (i + 1 < string.length() && string.substring(i, i + 2).equals("c-")) {
                count++;
                i += 2;
            } else if (i + 2 < string.length() && string.substring(i, i + 3).equals("dz=")) {
                count++;
                i += 3;
            } else if (i + 1 < string.length() && string.substring(i, i + 2).equals("d-")) {
                count++;
                i += 2;
            } else if (i + 1 < string.length() && string.substring(i, i + 2).equals("lj")) {
                count++;
                i += 2;
            } else if (i + 1 < string.length() && string.substring(i, i + 2).equals("nj")) {
                count++;
                i += 2;
            } else if (i + 1 < string.length() && string.substring(i, i + 2).equals("s=")) {
                count++;
                i += 2;
            } else if (i + 1 < string.length() && string.substring(i, i + 2).equals("z=")) {
                count++;
                i += 2;
            } else {
                count++;
                i += 1;
            }
			
		}
		System.out.printf("%d", count);
	}
}
