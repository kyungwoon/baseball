package 숫자야구게임;

public class Main {
	/*
	 * 메소드 리스트 1. 1부터 9까지 중복없는 3개의 랜덤 숫자 생성 기능 : makeRandNum
	 */
	public static int[] makeRandNum() {
		int[] randNum = new int[3];

		for (int i = 0; i < randNum.length; i++) {
			randNum[i] = (int) (Math.random() * 9 + 1);
			for (int j = 0; j < i; j++) {
				if (randNum[i] == randNum[j]) {
					i--;
				}
			}
		}
		return randNum;
	}

	public static void main(String[] args) {
		// makeRandNum(중복 숫자) 테스트
		int[] arr = makeRandNum();
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

	}

}
