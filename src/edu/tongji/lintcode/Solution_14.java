package edu.tongji.lintcode;

/**
 * lintcode: 14. First Position of Target
 * Created by huang on 2019/3/28.
 */
public class Solution_14 {
    /**
     * @param nums:   The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
        // write your code here
        int left = 0;
        int right = nums.length - 1;
        int mid = left + (right - left) / 2;
        int res = -1;

        while (left <= right) {
            if (nums[mid] == target) {
                if (mid > 0 && nums[mid - 1] == target) {
                    right = mid - 1;
                } else {
                    res = mid;
                    break;
                }
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            mid = left + (right - left) / 2;
        }

        return res;
    }
}
