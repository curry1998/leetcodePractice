package com.boshrong.leetcode.技巧;

import java.util.ArrayList;

public class 寻找两个正序数组的中位数4 {

    public static void main(String[] args) {
        int [] nums1 = {1};
        int [] nums2={2,3,4};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }
    // 归并排序合并的思想的思想
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1 + n2;
        int[] nums = new int[n];
        int left = 0, right = 0;
        int i;
        for(i = 0; i<n; i++) {
            if(left < n1 && right < n2) {
                if(nums1[left] < nums2[right]) {
                    nums[i] = nums1[left];
                    left ++;
                } else {
                    nums[i] = nums2[right];
                    right ++;
                }
            } else {
                break;
            }
        }

        while(left < n1) {
            nums[i] = nums1[left];
            i++;
            left++;
        }

        while(right < n2) {
            nums[i] = nums2[right];
            i++;
            right++;
        }

        double result = n % 2 == 0? (((double)nums[n/2 - 1] + (double)nums[n/2]) / 2) : nums[n/2];
        return result;
    }

}
