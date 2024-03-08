package com.boshrong.leetcode.设计题;

import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.util.*;

public class LRU缓存146 {
    //定义双向链表的结构
    class LinkedList extends TimerTask {
        int key;
        int value;
        Timer timer;
        LinkedList pre;
        LinkedList next;
        public LinkedList(int key,int value){
            this.key=key;
            this.value=value;
            timer=new Timer();
        }

        @Override
        public void run() {
            //超过时间后的操作
            timer.cancel();
            deleteNode(this);
        }
    }
    //思考之后双端队列就不用虚拟的头了
    private int size;
    private int capacity;
    // 需要保存链表的尾节点和头节点
    private LinkedList rearNode;
    private LinkedList firstNode;
    // map 从key 到node 的映射
    private HashMap<Integer,LinkedList> map;

    public void LRUCache(int capacity) {
        this.size=0;
        this.capacity=capacity;
        map=new HashMap<>(capacity);
    }

    public int get(int key) {
        if(map.containsKey(key)){
            LinkedList linkedList = map.get(key);
            if(key==rearNode.key){
                rearNode=linkedList.pre;
            }
            //将其断开
            leave(linkedList);
            // 将其插入到头部
            moveToHead(linkedList);
            return map.get(key).value;
        }else{
            return -1;
        }
    }

    public void put(int key, int value) {
        //已经存在了
        if(map.containsKey(key)  ){
            // 进行更新
            LinkedList linkedList = map.get(key);
            // 更新时间
            linkedList.timer.schedule(linkedList,30000);
            linkedList.value=value;
            moveToHead(linkedList);
        }else if(this.size<this.capacity){
            //删除链表最后一位元素
            LinkedList linkedList = map.get(rearNode);
            deleteNode(linkedList);
            LinkedList linkedList1 = new LinkedList(key, value);
            moveToHead(linkedList1);
            map.put(key,linkedList1);
            this.size++;
        }


    }
    // 将常用模块抽象成函数

    public void leave(LinkedList linkedList){
        //保证双端队列
        linkedList.next.pre=linkedList.pre;
        linkedList.pre.next=linkedList.next;
    }
    public void  moveToHead(LinkedList linkedList){
        if(linkedList==firstNode){
            return;
        }
        // 该节点成为头节点, 双链表进行插入(笔上模拟)
        linkedList.pre=firstNode.pre;
        firstNode.pre.next=linkedList;
        firstNode.pre=linkedList;
        linkedList.next=firstNode;
        //更新firstNode 为插入节点
        firstNode=linkedList;
    }
    public void deleteNode(LinkedList linkedList){

        if(linkedList.pre!=null) {
            // 更新rearkey
            rearNode = linkedList.pre;
            //进行删除
            linkedList.next.pre = linkedList.pre;
            linkedList.pre.next = linkedList.next;
        }else{
            this.size=0;
        }
        // 删除map 该node 相关信息
        map.remove(linkedList.key);

    }

}
