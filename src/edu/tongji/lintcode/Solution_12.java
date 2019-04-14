package edu.tongji.lintcode;

import java.util.HashMap;
import java.util.Map;

/**
 * lintcode: 12.Longest Consecutive Sequence
 * Created by huang on 2019/4/11.
 */
public class Solution_12 {
    /**
     * @param num: A list of integers
     * @return: An integer
     */
    // 方法1： 每个数都存在hashmap中，需要占用较多的内存，因此不推荐采用该方法
    public int longestConsecutive(int[] num) {
        // write your code here
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int res = 0;
        for (int n : num) {
            if (map.containsKey(n - 1)) {
                map.put(n, map.get(n - 1) + 1);
            } else {
                map.put(n, 1);
            }

            // update num behind n
            int next = n + 1;
            while (map.containsKey(next)) {
                // map.put(next, map.get(next - 1) + 1);
                next = next + 1;
            }
            if (next - 1 > n) {
                map.put(next - 1, map.get(n) + next - 1 - n);
            }

            if (map.get(next - 1) > res) {
                res = map.get(next - 1);
            }
        }

        return res;
    }

    // 方法2
    public int longestConsecutive2(int[] num) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int n : num) {
            if (!map.containsKey(n)) {
                int left = (map.containsKey(n - 1)) ? map.get(n - 1) : 0;
                int right = (map.containsKey(n + 1)) ? map.get(n + 1) : 0;
                int sum = left + right + 1;
                map.put(n, sum);

                res = Math.max(res, sum);

                map.put(n - left, sum);
                map.put(n + right, sum);
            } else {
                continue;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] test = {100, 4, 200, 1, 3, 2};
        Solution_12 solution = new Solution_12();
        System.out.println(solution.longestConsecutive(test));
    }
}
