package laoYueHan;

//原理,从(0,0)开始走,设f()函数可以算出所需步数,f(i,j)=f(i-1,j)+f(i,j-1),所以累加可以得到结果
public class N9 {
	public int uniquePaths(int m, int n) {
		int[][] array = new int[m][n];//设定一个长为m,宽为n的`二维数组,模拟表格
		for (int i = 0; i < m; i++) {
			//给长边的第一行赋值为1
			array[i][0] = 1;
			
		}
		for (int i = 0; i < n; i++) {
			//给宽边的第一列赋值为1
			array[0][i] = 1;
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				//循环累加至最后一格
				array[i][j] = array[i][j - 1] + array[i - 1][j];
			}
		}
		//返回最后一个所需的步数
		return array[m - 1][n - 1];
	}

	public static void main(String[] args) {
		System.out.println(new N9().uniquePaths(3, 7));
	}
}
