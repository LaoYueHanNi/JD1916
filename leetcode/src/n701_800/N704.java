package n701_800;

/*给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
你可以假设 nums 中的所有元素是不重复的。
n 将在 [1, 10000]之间。
nums 的每个元素都将在 [-9999, 9999]之间。*/
public class N704 {
	// 采用二分法,因为数组默认是有序的
	// 目标值直接用center下标元素对比,大则进入右区间,小则进入左区间,无限循环
	public int search(int[] nums, int target) {
		int left = 0;// 定义左点下标
		int right = nums.length - 1;// 定义右点下标
		// 采用无限循环
		while (true) {
			int center = (left + right) / 2;// 定义中心点等于左右点下标之和的一半
			// 只有一个元素的情况
			if (left == right && nums[center] != target)
				return -1;
			// 左右点已经相邻的情况
			if (left == (right - 1)) {
				if (nums[right] != target && nums[left] != target)
					return -1;
				if (nums[right] == target)
					return right;
				if (nums[left] == target)
					return left;
			}
			// 相等直接跳出
			if (nums[center] == target) {
				return center;
			} else if (target > nums[center]) {// 进入右区间,中点变为左点
				left = center;
			} else if (target < nums[center]) { // 进入左区间,中点变为右点
				right = center;
			}
		}
	}

	public static void main(String[] args) {
		int nums[] = { -1, 0, 5 ,7,11};
		int target = -1;
		int result = new N704().search(nums, target);
		System.out.println(result);
	}
}
