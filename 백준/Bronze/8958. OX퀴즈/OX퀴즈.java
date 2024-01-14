import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int caseNum;
	static int scoreList[], caseScoreList[];
	static String quiz;
	
	public static void main(String[] args) {
		caseNum = scanner.nextInt();
		caseScoreList = new int [caseNum];
		
		for(int i = 0; i < caseNum; i++) {
			quiz = scanner.next();
			scoreList = new int [quiz.length()];
			int totalScore = 0;
			int score = 1;
			
			for(int j = 0; j < quiz.length(); j++) {
				if(String.valueOf(quiz.charAt(j)).equals("O")) {
					scoreList[j] = score;
					score++;
				}else if(String.valueOf(quiz.charAt(j)).equals("X")) {
					scoreList[j] = 0;
					score = 1;
				}
			}
			
			for(int k = 0; k < quiz.length(); k++) {
				totalScore += scoreList[k];
			}
			
			caseScoreList[i] = totalScore;
		}
		
		for(int score: caseScoreList) {
			System.out.println(score);
		}
	}
}
