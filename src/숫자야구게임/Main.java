package 숫자야구게임;

import java.util.Scanner;

public class Main {
	/*
	 * 메소드 리스트 
	 * 1. 1부터 9까지 중복없는 3개의 랜덤 숫자 생성 기능 : makeRandNum 
	 * 2. 스트라이크, 볼 판별 하는 기능 : isStrike,isBall
	 * 3. 스트라이크, 볼 갯수에 맞는 세부 힌트 : Hint
	 * 4. 유저가 입력한 수에 따라 볼과 스트라이크를 판단하고 힌트 반환 : compare
	 * 
	 */
	private static String randNum = "";
	private static String userNum = "";

	public static String makeRandNum() {
		int[] randNum = new int[3];
		String randNumSplit = "";
		String str_randNum = "";

		for (int i = 0; i < randNum.length; i++) {
			randNum[i] = (int) (Math.random() * 9 + 1);
			for (int j = 0; j < i; j++) {
				if (randNum[i] == randNum[j]) {
					i--;
				}
			}
		}
		// int형 배열 값(randNum)을 String으로 형 변환
		for (int i = 0; i < randNum.length; i++) {
			randNumSplit = Integer.toString(randNum[i]);
			str_randNum += randNumSplit;
		}
		return str_randNum;
	}

	public void comRand() {
		randNum = makeRandNum();
	}

	// 스트라이크 판별
	public static boolean isStrike(char userNum, int index) {
		for (int i = 0; i < 3; i++) {
			if (userNum == randNum.charAt(i) && index == i) {
				return true;
			}
		}
		return false;
	}

	// 볼 판별
	public static boolean isBall(char userNum) {
		for (int i = 0; i < 3; i++) {
			if (userNum == randNum.charAt(i)) {
				return true;
			}
		}
		return false;
	}

	// 스트라이크,볼 수의 힌트
	private String Hint(int strikeNum, int ballNum) {
		if (strikeNum == 3) {
			return "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
		} else if (ballNum == 0 && strikeNum == 0) {
			return "낫싱";
		} else if (ballNum == 0) {
			return strikeNum + " 스트라이크";
		} else if (strikeNum == 0) {
			return ballNum + " 볼";
		}
		return ballNum + "볼 " + strikeNum + " 스트라이크";
	}

	// 유저가 입력한 수에 따라 볼과 스트라이크를 판단하고 힌트 반환
	private String compare() {
		int ballNum = 0;
		int strikeNum = 0;
		Scanner sc = new Scanner(System.in);
		userNum = sc.next();

		for (int i = 0; i < 3; i++) {
			char input = userNum.charAt(i);

			if (isStrike(input, i)) {
				strikeNum++;
			} else if (isBall(input)) {
				ballNum++;
			}
		}
		return Hint(ballNum, strikeNum);
	}

	public static void main(String[] args) {
		// makeRandNum(중복 숫자) 테스트
		System.out.println(makeRandNum());

	}

}
