package n1_100;

public class N34_2 {
	// 局部二分法
	public int[] searchRange(int[] nums, int target) {
		int[] result = { -1, -1 };
		int mid = 0;
		int m = 0;
		if ((mid = findTarget(nums, 0, nums.length - 1, target)) == -1) {
			return result;
		} else {
			result[0] = mid;
			result[0] = mid;
			m = mid;
			while (mid <= nums.length - 1 && nums[mid] == target) {
				result[1] = mid;
				mid++;
			}
			while (m >= 0 && nums[m] == target) {
				result[0] = m;
				m--;
			}
		}
		return result;

	}

	public int findTarget(int[] nums, int left, int right, int target) {
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

	public static void main(String[] args) {
		int[] nums = { 1 };
		int target = 1;
		int[] result = new N34().searchRange(nums, target);
		System.out.println(result[0] + "," + result[1]);
//		System.out.println(new N34_2().findTarget(nums, 0, nums.length-1, target));

	}
}
