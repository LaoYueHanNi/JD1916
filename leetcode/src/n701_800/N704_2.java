package n701_800;

class N704_2 {
	public int search(int[] nums, int target) {
		int len = nums.length;
		int right = len - 1;
		int left = 0;
		
		//���������е��Ѿ��жϹ������+1,��-1,���ֻ��һ��Ԫ��,ֱ�Ӳ��ڽ���ѭ��
		//�������Ԫ�����ȥ���Ѿ��ж��˵����,
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