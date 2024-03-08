package com.boshrong.leetcode.队列栈;

import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;

import javax.sound.sampled.Line;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 圆圈中最后的数字jz62 {

    public  int lastRemaining(int n, int m) {
        // n 个数字 从0 到n-1
        ArrayList<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int idx = 0;
        while (n > 1) {
            idx = (idx + m - 1) % n;
            list.remove(idx);
            n--;
        }
        return list.get(0);

    }
}
