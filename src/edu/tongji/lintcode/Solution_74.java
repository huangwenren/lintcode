package edu.tongji.lintcode;

/**
 * lintcode: 74. First Bad Version
 * Created by huang on 2019/3/31.
 */
public class Solution_74 {
    /*
    这边只是为了防止本地报错而简单定义了方法。
     */
    public static class SVNRepo {
        public static boolean isBadVersion(int k) {
            return true;
        }
    }

    /**
     * @param n: An integer
     * @return: An integer which is the first bad version.
     */
    public int findFirstBadVersion(int n) {
        // write your code here
        int left = 1;
        int right = n;
        int mid;

        while (left < right) {
            mid = left + (right - left) / 2;

            if (SVNRepo.isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
