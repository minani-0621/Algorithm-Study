import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		String inputDocument = scanner.nextLine();
		String findingWord = scanner.nextLine();
		
		int docLength = inputDocument.length();
		int wordLength = findingWord.length();
		
		int count = 0;
		int index = 0;
		
		while(index < docLength) {
			if(index + wordLength < docLength) {
				if(inputDocument.substring(index, (index + wordLength)).equals(findingWord)) {
					index += wordLength;
					count++;
				}else {
					index++;
				}
			}else if(index + wordLength == docLength) {
				if(inputDocument.substring(index).equals(findingWord)) {
					index += wordLength;
					count++;
				}else {
					index++;
				}
			}else {
				index++;
			}
			
		}
		
		System.out.println(count);
	}
}
