package com.wangyc.leetcode;

/**
 * leetcode 146
 *
 * @author wangyc
 */
public class TwoSum2 {
    public int[] twoSum(int[] numbers, int target) {
        int j = numbers.length - 1;
        for (int i = 0; i < numbers.length; i++) {
            while (i < j && numbers[i] + numbers[j] > target) {
                j--;
            }
            if (i < j && numbers[i] + numbers[j] == target) {
                return new int[]{i, j};
            }
        }
        return new int[]{};
    }
}
