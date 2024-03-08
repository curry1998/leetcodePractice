package com.boshrong.leetcode.链表;

import java.util.HashMap;
import java.util.Map;

public class 复杂链表的复制jz35 {

    public RandomListNode Clone(RandomListNode pHead)
    {
        //遍历两次
        if(pHead==null){
            return pHead;
        }

        //map中存的是(原节点，拷贝节点)的一个映射
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        for (RandomListNode cur = pHead; cur != null; cur = cur.next) {
            map.put(cur, new RandomListNode(cur.label));
        }
        //将拷贝的新的节点组织成一个链表
        for (RandomListNode cur = pHead; cur != null; cur = cur.next) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            // 获得 key 和value map.entryset();
        }


        return map.get(pHead);

    }

}


class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
