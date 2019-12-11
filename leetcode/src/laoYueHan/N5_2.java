package laoYueHan;

public class N5_2 {
	public int game(int[] guess, int[] answer) {
		int result=0;
		if(guess[0]==answer[0]) {
			result+=1;
		}
		if(guess[1]==answer[1]) {
			result+=1;
		}
		if(guess[2]==answer[2]) {
			result+=1;
		}
		
		return result;
	}
}
