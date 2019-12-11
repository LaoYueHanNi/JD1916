package laoYueHan;

//ԭ��,��(0,0)��ʼ��,��f()��������������貽��,f(i,j)=f(i-1,j)+f(i,j-1),�����ۼӿ��Եõ����
public class N9 {
	public int uniquePaths(int m, int n) {
		int[][] array = new int[m][n];//�趨һ����Ϊm,��Ϊn��`��ά����,ģ����
		for (int i = 0; i < m; i++) {
			//�����ߵĵ�һ�и�ֵΪ1
			array[i][0] = 1;
			
		}
		for (int i = 0; i < n; i++) {
			//����ߵĵ�һ�и�ֵΪ1
			array[0][i] = 1;
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				//ѭ���ۼ������һ��
				array[i][j] = array[i][j - 1] + array[i - 1][j];
			}
		}
		//�������һ������Ĳ���
		return array[m - 1][n - 1];
	}

	public static void main(String[] args) {
		System.out.println(new N9().uniquePaths(3, 7));
	}
}
