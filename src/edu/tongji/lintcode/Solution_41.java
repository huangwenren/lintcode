package edu.tongji.lintcode;

/**
 * lintcode: 41. Maximum Subarray
 * Created by huang on 2019/4/15.
 */
public class Solution_41 {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        // write your code here
        int curSum = nums[0];
        int res = curSum;
        for (int i = 1; i < nums.length; i++) {
            if (curSum < 0) {
                curSum = nums[i];
            } else {
                curSum += nums[i];
            }

            res = Math.max(res, curSum);
        }

        return res;
    }
}
