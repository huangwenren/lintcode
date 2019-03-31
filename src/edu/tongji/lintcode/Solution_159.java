package edu.tongji.lintcode;

/**
 * lintcode: 159. Find Minimum in Rotated Sorted Array
 * Created by huang on 2019/3/31.
 */
public class Solution_159 {
    /**
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] nums) {
        // write your code here
        int left = 0;
        int right = nums.length - 1;
        int mid;

        while (left < right) {
            mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[left];
    }
}
