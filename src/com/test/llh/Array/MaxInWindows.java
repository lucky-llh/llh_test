package com.test.llh.Array;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;

/**
 * 滑动窗口的最大值
 */
public class MaxInWindows {
    /**
     * 用队列实现：保持递减顺序
     * @param arr
     * @param size
     * @return
     */
    public static ArrayList<Integer> maxInWindows(int[]arr, int size){
        ArrayList<Integer>list=new ArrayList<>();
        if (arr==null||arr.length==0||size<1||size>arr.length){
            return list;
        }
        LinkedList<Integer>queue=new LinkedList<>();
        for (int i=0;i<arr.length;i++){
            while (!queue.isEmpty()&&(arr[queue.peekLast()]<arr[i])){
                queue.pollLast();
            }
            queue.addLast(i);
            //队头元素过期
            if (queue.peekFirst()==i-size){
                queue.pollFirst();
            }
            //取对头
            if (i>=size-1){
                list.add(arr[queue.peekFirst()]);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[]arr={2,3,4,2,6,2,5,1};
        int size=3;
        ArrayList<Integer>list=maxInWindows(arr,size);
        list.stream().forEach(System.out::println);
    }
}
