package laoYueHan;

//СA �� СB ��������֡�СB ÿ�δ� 1, 2, 3 �����ѡ��һ����СA ÿ��Ҳ�� 1, 2, 3 ��ѡ��һ���¡�����һ���������������Ϸ���뷵�� СA �¶��˼��Σ�
//�����guess����Ϊ СA ÿ�εĲ²⣬answer����Ϊ СB ÿ�ε�ѡ��guess��answer�ĳ��ȶ�����3��
public class N5 {
	public int game(int[] guess, int[] answer) {
		int result=0;
		for(int i=0;i<3;i++) {
			if(guess[i]==answer[i]) {
				result+=1;
			}
		}
		return result;

	}
}
