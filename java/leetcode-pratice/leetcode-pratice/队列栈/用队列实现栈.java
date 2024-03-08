package com.boshrong.leetcode.队列栈;

import javax.sound.sampled.Line;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class 用队列实现栈 {
}
class MyStack {
    Queue<Integer> queue;
    public MyStack() {
        queue = new LinkedList<>();

    }

    public void push(int x) {
        queue.offer(x);
        for (int i = 0; i < queue.size() - 1; i++) {
            queue.offer(queue.poll());
        }
    }

    public int pop() {
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}

