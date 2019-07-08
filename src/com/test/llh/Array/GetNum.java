package com.test.llh.Array;

import java.util.LinkedList;

/**
 * 最大值减去最小值小于或等于num的子数组数量:时间复杂度为O(n)
 */
public class GetNum {
    /**
     * 使用类似生成最大窗口值的方法实现
     * 用两个双端队列，一个维护最小值的更新，一个维护最大值的更新，
     * 生成两个变量i和j,
     * j不断往右移动（j++),并且不断更新qmax,qmin,一旦出现不满足的情况，就停止右移，结算，也就是必须以i开头的子数组元素的个数为j-i个
     * 然后让i右移动一位，继续更新
     * 最后求出分别以，0,1,2，...n-1为开头的情况下满足条件的子数组有多少个
     * @param arr
     * @return
     */
    public static int getNum(int[]arr,int num){
        if (arr==null||arr.length==0){
            return 0;
        }
        LinkedList<Integer>qMin=new LinkedList<>();
        LinkedList<Integer>qMax=new LinkedList<>();
        int i=0;
        int j=0;
        int res=0;
        while (i<arr.length){
            while (j<arr.length){
                while (!qMax.isEmpty()&&arr[qMax.peekLast()]<=arr[j]){
                    qMax.pollLast();
                }
                qMax.addLast(j);
                while (!qMin.isEmpty()&&arr[qMin.peekLast()]>=arr[j]){
                    qMin.pollLast();
                }
                qMin.addLast(j);
                if (arr[qMax.peekFirst()]-arr[qMin.peekFirst()]>num){
                    break;
                }
                j++;
            }
            //过期元素
            if (qMax.peekFirst()==i){
                qMax.pollFirst();
            }
            if (qMin.peekFirst()==i){
                qMax.pollFirst();
            }
            res+=j-i;
            i++;
        }
        return res;

    }

    public static void main(String[] args) {
        int[]arr={10,3,20};
        int num=10;
        int res=getNum(arr,num);
        System.out.println(res);
    }
}
