package exam;

public class monkey {

	public static void main(String args[]) {
		int M = 50000;// ��������
		int N = 3000;// �涨��̭�����ֱ��

		int monkeynum[] = new int[M];
		for (int i = 0; i < monkeynum.length; i++) {
			monkeynum[i] = i + 1;
		}

		int count = 1;// ѭ������
		int king = 0;// ���Ӵ����ı��
		int index = 0;// ������±�

		while (M != 0) {
			// �����Ȱѵ�������һ��ѭ�����飬����ѭ���������ĩβʱ����������±��Ƴ�����Ŀ�ʼ
			if (index == monkeynum.length) {
				index = 0;
			}
			// Ȼ���ж�ѭ�����������
			if (count == N && monkeynum[index] != 0) {
				monkeynum[index] = 0;
				M--;
				count = 1;
			}

			if (monkeynum[index] != 0) {
				count++;
			}
			index++;
		}
		king = index;
		System.out.println("���ӵĴ����ı����" + king);
	}
}
