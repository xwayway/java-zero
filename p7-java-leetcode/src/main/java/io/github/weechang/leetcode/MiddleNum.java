package io.github.weechang.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 求中位数
 *
 * @author zhangwei
 * date 2020/5/15
 * time 22:51
 */
public class MiddleNum {

    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 4, 3, 4, 3};
        System.out.println(middle(arr));
    }

    public static Integer middle(int[] arr) {
        if (arr == null || arr.length == 0 || (arr.length & 1) == 0) {
            return null;
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>( new Comparator<Integer>() {
            @Override
            public int compare(Integer e1, Integer e2) {
                return e1 - e2;
            }
        });
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>( new Comparator<Integer>() {
            @Override
            public int compare(Integer e1, Integer e2) {
                return e1 - e2;
            }
        });
        for (int item : arr) {
            if (maxHeap.size() == 0) {
                maxHeap.add(item);
                continue;
            }
            if (maxHeap.size() == minHeap.size()) {
                if (item < maxHeap.peek()) {
                    maxHeap.add(item);
                } else {
                    minHeap.add(item);
                }
            } else if (maxHeap.size() < minHeap.size()) {
                if (item < maxHeap.peek()) {
                    maxHeap.add(item);
                } else {
                    maxHeap.add(minHeap.poll());
                    minHeap.add(item);
                }
            } else {
                minHeap.add(maxHeap.poll());
                maxHeap.add(item);
            }
        }
        if (minHeap.size() > maxHeap.size()) {
            return minHeap.peek();
        } else {
            return maxHeap.peek();
        }
    }
}
