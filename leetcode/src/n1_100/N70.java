package n1_100;
//������������¥�ݡ���Ҫ n ������ܵ���¥����
//ÿ��������� 1 �� 2 ��̨�ס����ж����ֲ�ͬ�ķ�����������¥���أ�
//ע�⣺���� n ��һ����������
public class N70 {
	
	public int climbStairs(int n) {
         int step_1 = 1;//һ����Ҫһ��
         int step_2 = 2;//������Ҫ����
         int result = 0;//���
         if(n==1)return step_1;
         if(n==2)return step_2;
         for(int i =3;i<=n;i++) {
        	 //�ۼ�,n��̨����Ҫ�Ĳ�����n-1���n-2��̨����Ҫ�����ĺ�
        	 result=step_1+step_2;//n����Ҫ��
        	 //��ֵ
        	 step_1=step_2;
        	 step_2=result;
         }
		return result;
    }
}
