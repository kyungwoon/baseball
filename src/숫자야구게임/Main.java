package 숫자야구게임;

public class Main {
	/*
	 * 메소드 리스트 
	 * 1. 1부터 9까지 중복없는 3개의 랜덤 숫자 생성 기능 : makeRandNum
	 * 2. 스트라이크, 볼 판별 하는 기능 : isStrike,isBall
	 * 
	 */
	private static String randNum = "";

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

	public static void main(String[] args) {
		// makeRandNum(중복 숫자) 테스트
		System.out.println(makeRandNum());

	}

}
