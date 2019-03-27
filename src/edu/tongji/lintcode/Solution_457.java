package edu.tongji.lintcode;

/**
 * lintcode: 457. Classical Binary Search
 * Created by huang on 2019/3/27.
 */
public class Solution_457 {
    /**
     * @param nums:   An integer array sorted in ascending order
     * @param target: An integer
     * @return: An integer
     */
    public int findPosition(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;
        int mid = (left + right) / 2;

        int index = -1;
        while (left <= right) {
            if (nums[mid] == target) {
                index = mid;
                break;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            mid = (left + right) / 2;
        }

        return index;
    }
}
