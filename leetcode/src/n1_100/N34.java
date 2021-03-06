package n1_100;
/*给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
你的算法时间复杂度必须是 O(log n) 级别。
如果数组中不存在目标值，返回 [-1, -1]。*/

public class N34 {
	//从左往右遍历,找出左边界,然后从右往左遍历,找出右边界
	public int[] searchRange(int[] nums, int target) {
		int[] result = { -1, -1 };
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == target) {
				result[0] = i;
				for (int j = nums.length - 1; j >= 0; j--) {
					if (nums[j] == target) {
						result[1] = j;
						return result;
					}
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 3, 6 };
		int target = 2;
		int[] result = new N34().searchRange(nums, target);
		System.out.println(result[0] + "," + result[1]);

	}
}
