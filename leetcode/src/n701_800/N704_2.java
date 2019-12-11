package n701_800;

class N704_2 {
	public int search(int[] nums, int target) {
		int len = nums.length;
		int right = len - 1;
		int left = 0;
		
		//完美利用中点已经判断过的情况+1,或-1,如果只有一个元素,直接不在进入循环
		//如果两个元素则会去掉已经判定了的情况,
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
		return -1;
	}
}