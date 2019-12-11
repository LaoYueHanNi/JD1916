package n1_100;

public class N34_3 {
	// ��ȫ���ַ�
	public int[] searchRange(int[] nums, int target) {
		int[] result = { -1, -1 };
		int mid = 0, left = 0, right = nums.length - 1;
		int supLeft = left, supRight = right, supMid = mid;
		if ((supMid = findTarget(nums, supLeft, supRight, target)) == -1) {
			return result;
		} else {
			result[0] = supMid;
			result[1] = supMid;
			supLeft = left;
			supRight = right;
			while (supMid > left) {
				if ((supMid = findTarget(nums, left, supMid - 1, target)) == -1) {
					break;
				} else {
					result[0] = supMid;
				}
			}
			while (supMid < right) {
				if ((supMid = findTarget(nums, supMid + 1, right, target)) == -1) {
					break;
				} else {
					result[1] = supMid;
				}
			}
			return result;
		}
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
		int[] nums = { 5, 7, 7, 8, 8, 10 };
		int target = 8;
		int[] result = new N34_3().searchRange(nums, target);
		System.out.println(result[0] + "," + result[1]);
//		System.out.println(new N34_2().findTarget(nums, 0, nums.length-1, target));

	}
}