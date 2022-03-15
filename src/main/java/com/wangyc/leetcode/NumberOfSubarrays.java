package com.wangyc.leetcode;

/**
 * leetcode 1248
 *
 * @author wangyc
 */
public class NumberOfSubarrays {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] cnt = new int[n + 1];
        int odd = 0;
        int ans = 0;
        cnt[0] = 1;
        for (int i = 0; i < n; ++i) {
            odd += nums[i] & 1;
            ans += odd >= k ? cnt[odd -k] : 0;
            cnt[odd] += 1;
        }
        return ans;
    }
}
