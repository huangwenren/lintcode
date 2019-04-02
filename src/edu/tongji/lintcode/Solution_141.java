package edu.tongji.lintcode;

/**
 * lintcode: 141. Sqrt(x)
 * Created by huang on 2019/4/2.
 */
public class Solution_141 {
    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    // 方法1： 不断逼近上边界
    public int sqrt(int x) {
        // write your code here
        int left = 1;
        int right = x;
        int ans = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (mid <= x / mid) {
                left = mid + 1;
                ans = mid;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }

    // 方法2： 二分查找
    public int sqrt2(int x) {
        if (x == 0 || x == 1) {
            return x;
        }

        int left = 1;
        int right = x / 2;
        int mid;

        while (left + 1 < right) {
            mid = left + (right - left) / 2;

            if (mid > x / mid) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }

        return right > x / right ? right - 1 : right;
    }

    public static void main(String[] args) {
        Solution_141 solution = new Solution_141();
        System.out.println(solution.sqrt2(4187));
    }
}
