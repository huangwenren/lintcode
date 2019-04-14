package edu.tongji.lintcode;

/**
 * lintcode: 10.Quick Sort
 * Created by huang on 2019/4/11.
 */
public class Solution_10 {
    /**
     * @param A: an integer array
     * @return: nothing
     */
    public void sortIntegers2(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return;
        }
        quickSort(A, 0, A.length - 1);
    }

    private void quickSort(int[] A, int left, int right) {
        if (left >= right) {
            return;
        }
        int index = partition(A, left, right);
        quickSort(A, left, index - 1);
        quickSort(A, index + 1, right);
    }

    private int partition(int[] A, int left, int right) {
        int pivotKey = A[left];
        int pivotPointer = left;

        while (left < right) {
            while (left < right && A[right] >= pivotKey) {
                right--;
            }

            while (left < right && A[left] <= pivotKey) {
                left++;
            }

            swap(A, left, right);
        }
        swap(A, left, pivotPointer);

        return left;
    }

    private void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    public static void main(String[] args) {
        int[] test = {2, 3, 1};
        Solution_10 solution = new Solution_10();
        solution.sortIntegers2(test);
        for (int num : test) {
            System.out.println(num);
        }
    }
}
