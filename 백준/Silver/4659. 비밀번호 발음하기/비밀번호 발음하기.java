import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		while(true) {
			String password = scanner.next();
			
			if(password.equals("end")) {
				break;
			}
			
			if(checkVowel(password) && check3ConsonantOrVowel(password) && checkContinuousSameWord(password)) {
				bw.write("<" + password + "> is acceptable.\n");
			}else {
				bw.write("<" + password + "> is not acceptable.\n");
			}
		}
		
		bw.flush();
		bw.close();
	}
	
	static boolean checkVowel(String password) {
		HashSet<Character> vowels = new HashSet<>();
		vowels.add('a');
		vowels.add('e');
		vowels.add('i');
		vowels.add('o');
		vowels.add('u');
		
		for(int i = 0; i < password.length(); i++) {
			if(vowels.contains(password.charAt(i))) {
				return true;
			}
		}
		
		return false;
	}
	
	static boolean check3ConsonantOrVowel(String password) {
		HashSet<Character> vowels = new HashSet<>();
		vowels.add('a');
		vowels.add('e');
		vowels.add('i');
		vowels.add('o');
		vowels.add('u');
		
		int countStraight = 1;
		boolean isPrevVowel = vowels.contains(password.charAt(0));
		
		for(int i = 1; i < password.length(); i++) {
			if(vowels.contains(password.charAt(i))) {
				if(isPrevVowel) {
					countStraight++;
					
					if(countStraight >= 3) {
						return false;
					}
				}else {
					countStraight = 1;
				}
			}else {
				if(isPrevVowel) {
					countStraight = 1;
				}else {
					countStraight++;
					
					if(countStraight >= 3) {
						return false;
					}
				}
			}
			
			isPrevVowel = vowels.contains(password.charAt(i));
		}
		
		return true;
	}
	
	static boolean checkContinuousSameWord(String password) {
		boolean result = true;
		
		for(int i = 0; i < password.length() - 1; i++) {
			if(password.charAt(i) == password.charAt(i + 1)) {
				if(password.charAt(i) == 'e' || password.charAt(i) == 'o') {
					result = true;
				}else {
					result = false;
				}
			}
		}
		
		return result;
	}
}
