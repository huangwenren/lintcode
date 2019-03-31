package edu.tongji.lintcode;

/**
 * lintcode: 75. Find Peak Element
 * Created by huang on 2019/3/28.
 */
public class Solution_75 {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    private int res = -1;

    public int findPeak(int[] A) {
        // write your code here
        findPeak(A, 0, A.length - 1);

        return res;
    }

    private void findPeak(int[] A, int left, int right) {
        if (left > right || res != -1) {
            return;
        }

        int mid = left + (right - left) / 2;

        if (mid > 0 && mid < A.length - 1) {
            if (A[mid - 1] < A[mid] && A[mid] > A[mid + 1]) {
                res = mid;
                return;
            } else if (A[mid - 1] > A[mid] && A[mid] < A[mid + 1]) {
                findPeak(A, left, mid - 1);
                findPeak(A, mid + 1, right);
            } else if (A[mid - 1] > A[mid] && A[mid] > A[mid + 1]) {
                findPeak(A, left, mid - 1);
            } else if (A[mid - 1] < A[mid] && A[mid] < A[mid + 1]) {
                findPeak(A, mid + 1, right);
            }
        }
    }

    // 解法2： 非递归解法
    public int findPeak2(int[] A) {
        // write your code here
        int left = 0;
        int right = A.length - 1;
        int mid;

        while (left < right) {
            mid = (left + right) / 2;

            if (A[mid] < A[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return right;
    }

    public static void main(String[] args) {
        int[] test = {1, 2, 1, 3, 4, 5, 7, 6};

        Solution_75 solution = new Solution_75();

        System.out.println(solution.findPeak(test));
    }
}
