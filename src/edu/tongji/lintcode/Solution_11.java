package edu.tongji.lintcode;

import java.util.Arrays;

/**
 * lintcode: 11.Longest Increasing Subsequence
 * Created by huang on 2019/4/11.
 */
public class Solution_11 {
    /**
     * @param nums: An integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        // write your code here
        int[] dp = new int[nums.length];
        int len = 0;

        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            // num dose not exist in dp
            if (i < 0) {
                i = -(i + 1);
            }

            dp[i] = num;

            if (i == len) {
                len++;
            }
        }

        return len;
    }


    public static void main(String[] args) {
        int[] test = {10, 9, 2, 5, 3, 7, 101, 18};
        Solution_11 solution = new Solution_11();
        System.out.println(solution.longestIncreasingSubsequence(test));
    }
}
