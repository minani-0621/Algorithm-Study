import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static String word;
	static String alphabet[] = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
	static int firstUseAlphabet[] = new int[26];
	
	public static void main(String[] args) {
		word = scanner.next();
		
		for(int i = 0; i < alphabet.length; i++) {
			for(int j = 0; j < word.length(); j++) {
				if(alphabet[i].equals(String.valueOf(word.charAt(j)))) {
					firstUseAlphabet[i] = j;
					break;
				}else if(j == word.length() - 1  && !alphabet[i].equals(String.valueOf(word.charAt(j)))) {
					firstUseAlphabet[i] = -1;
				}
			}
		}
		
		for(int i = 0; i < firstUseAlphabet.length; i++) {
			System.out.printf("%d ", firstUseAlphabet[i]);
		}
	}
}
