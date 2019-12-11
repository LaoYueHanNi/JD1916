package n1_100;

/*����һ�����������һ��Ŀ��ֵ�����������ҵ�Ŀ��ֵ�������������������Ŀ��ֵ�������������У����������ᱻ��˳������λ�á�
����Լ������������ظ�Ԫ�ء�*/
public class N35 {
	//�޸Ĺ��Ķ��� �ҵ��û��ͷ����±�,�Ҳ����ͷ���left��ֵ,��Ϊ���ַ����һ��Ҫô��left+1.������right-1,left���Ǳ�right��1
	//����Ŀ��ֵӦ����right��left֮��,�����±�Ӧ����left��ֵ
	public int searchInsert(int[] nums, int target) {
		int left = 0;
		int right = nums.length-1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] > target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}
 
	public static void main(String[] args) {
		int[] nums = { 5};
		int target = 5;
		System.out.println(new N35().searchInsert(nums, target));
	}
}
