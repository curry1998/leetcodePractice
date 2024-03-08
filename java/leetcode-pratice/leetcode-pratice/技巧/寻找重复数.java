package com.boshrong.leetcode.技巧;

import java.util.Scanner;

public class 寻找重复数 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();

        findDuplicate(new int[]{3,1,3,4,2});
    }
    public static int findDuplicate(int[] nums) {
        // 思想： 要求不修改数组 nums, 只使用常量级o(1)空间,时间复杂度为o(n)
        //  快慢指针，因为取值到 1-n+1 之间，所以可以通过值跳转到相应的下标。跳转时判断有无环，
        //  有  环则找到环的入口地址，可以通过快慢指针。
        // 这道题就可以转化为环的入口地址。

        int slow=0,fast=0;
        int lens=nums.length;
        if(lens==1){
            return nums[0];
        }
        fast=nums[fast];
        fast=nums[fast];
        while(nums[slow]!=nums[fast]){
            slow=nums[slow];
            // fast 多走两步
            fast = nums[fast];
            fast = nums[fast];
        };
        slow=0;
        System.out.println(fast);
        while(nums[slow]!=nums[fast]){
            slow=nums[slow];
            fast=nums[fast];
        }

        return nums[slow];
    }
}
