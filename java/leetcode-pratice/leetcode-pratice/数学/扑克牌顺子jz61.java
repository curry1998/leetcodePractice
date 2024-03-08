package com.boshrong.leetcode.数学;

import java.util.Arrays;
import java.util.Collections;

public class 扑克牌顺子jz61 {
    public  boolean isContinuous(int [] numbers) {
        int lens=numbers.length;
        Arrays.sort(numbers);
        int k=0;
        for(int i=0;i<lens;i++){
            if(numbers[i]==0){
                k++;
                continue;
            }
            if(i!=0 && numbers[i]==numbers[i-1]){
                return false;
            }
        }
        return numbers[lens-1]-numbers[k]<=4;
    }


}
