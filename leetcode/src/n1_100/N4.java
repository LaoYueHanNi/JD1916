package n1_100;

import java.util.Arrays;

/*给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
你可以假设 nums1 和 nums2 不会同时为空。*/
public class N4 {
	//最简单直观的思路,合并排序
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		//数据定义备用
		int length1 = nums1.length;
		int length2 = nums2.length;
		int[] arr = new int[length1 + length2];
		int length3 = length1 + length2;
		
		//数组的合并(通过拷贝实现),数组的排序
		System.arraycopy(nums1, 0, arr, 0, length1);
		System.arraycopy(nums2, 0, arr, length1, length2);
		Arrays.sort(arr);
		
		//分奇偶数两种情况判断
		if (length3 % 2 == 0) {
			return (arr[length3 / 2] + (double) arr[length3 / 2 - 1]) / 2;
		} else {
			return (arr[length3 / 2]);
		}
	}

	public static void main(String[] args) {
		int[] nums1 = { 1, 2, 5, 6, 9, 11 };
		int[] nums2 = { 4, 7, 11,19 };
		System.out.println(new N4().findMedianSortedArrays(nums1, nums2));
	}
}
