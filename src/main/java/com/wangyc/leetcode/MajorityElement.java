package com.wangyc.leetcode;

/**
 * leetcode 169
 *
 * @author wangyc
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer crowd = null;
        for (int num : nums) {
            if (count == 0) {
                crowd = num;
            }
            count += (num == crowd) ? 1 : -1;
        }
        return crowd;
    }
}
