package com.boshrong.leetcode.双指针;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 四数之和18 {

    public static void main(String[] args){
        int [] nums={1,-2,-5,-4,-3,3,3,5};
        fourSum(nums,-11);
    }
        public static List<List<Integer>> fourSum(int[] nums, int target) {
            int n = nums.length;
            Arrays.sort(nums);
            List<List<Integer>> res = new ArrayList<>();
            for(int i=0;i<n;i++){
                if(nums[i]>0 && nums[i]>target){
                    break;
                }

                // 去重
                if(i>0 && nums[i]==nums[i-1]){
                    continue;
                }
                for(int j=i+1;j<n;j++){

                    if(j>i+1 && nums[j]== nums[j-1]){
                        continue;
                    }
                    if(nums[i]+nums[j]>target){
                        break;
                    }
                    int left = j+1,right = n-1;
                    while(left<right){
                        if(nums[i]+nums[j]+nums[left]+nums[right]==target){
                            res.add(new ArrayList<Integer>(Arrays.asList(nums[i],nums[j],nums[left],nums[right])));
                            //缩小left,right 寻找可能的结果,首先要去重
                            while(left<right && nums[left]==nums[left+1]){
                                left++;
                            }
                            while(left<right && nums[right]==nums[right-1]){
                                right--;
                            }
                            left++;
                            right--;
                        }else if(nums[i]+nums[j]+nums[left]+nums[right]>target){
                            right--;
                        }else{
                            left++;
                        }
                    }
                }
            }
            return res;
        }
    }
