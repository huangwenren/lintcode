package edu.tongji.lintcode;

import java.util.List;

/**
 * lintcode: 09.Majority Element
 * Created by huang on 2019/4/6.
 */
public class Solution_9 {
    /*
    * @param nums: a list of integers
    * @return: find a  majority number
    */
    public int majorityNumber(List<Integer> nums) {
        // write your code here
        int times = 1;
        int curNum = nums.get(0);

        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) == curNum) {
                times++;
            } else {
                times--;

                if (times == 0) {
                    curNum = nums.get(i);
                    times = 1;
                }
            }
        }

        int count = 0;
        for (Integer num : nums) {
            if (num == curNum) {
                count++;
            }
        }

        return count > nums.size() / 2 ? curNum : -1;
    }
}
