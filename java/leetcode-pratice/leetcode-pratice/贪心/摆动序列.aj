package com.boshrong.leetcode.贪心;

public aspect 摆动序列 {
    public int wiggleMaxLength(int[] nums) {
        // 思路: 贪心，统计在峰值的和谷底的数，并且对两个值中的元素删除
        // pre 之前两个数的差 curr 现在两个数的差
        int n = nums.length;
        int pre = 0;
        int curr = 0;
        int res = 1;
        for(int i = 0; i<n-1;i++){
            curr = nums[i+1] - nums[i];
            if((curr>0 && pre<=0) ||(curr< 0 && pre>=0)){
                res++;
                pre = curr;
            }
        }
        return res;
    }
}
