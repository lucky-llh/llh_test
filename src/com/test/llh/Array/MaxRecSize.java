package com.test.llh.Array;

import java.util.Stack;

/**
 * 最大子矩阵的大小：矩阵中元素只有0和1，求其中全是1的所有矩形区域中，最大的矩形区域为1的数量
 */
public class MaxRecSize {
    /**
     *1.先以每一行元素分割，统计以当前为底的情况下，每个位置往上1的数量，记录在height数组中
     *2.对每一次的分割，求出以每一行为底的情况下，最大的矩形是什么，最大的就是结果。
     *   可以把height数组理解为直方图，求出最大的直方图的面积，就是找出每一个柱子往左右能扩的边界
     *   可以借助栈实现每一个位置左右能扩的位置，让栈从栈低往栈顶保持递增的顺序，
     *    如果遇到当前元素i,比栈顶元素大直接入栈，
     *    如果比栈顶元素小，就不断弹出栈中元素，知道该元素可以入栈，在弹出的过程中，计算每个弹出的元素左右扩的面积，即要弹出的栈顶元素为j,最新栈顶元素为k,则j位置往左右扩的边界为（k+1,i-1)
     *    所以j的面积为（i-k-1)*height[j]
     *    因为k是比j元素小的，在(k+1,j-1)之间不可能存在比k小等于的元素，如果有，k和j不会相邻，k早就会从栈中弹出，也不会有大于等于k,并且小于j的元素，如果有k与j不会相邻
     * @param rec
     * @return
     */
    public static int maxRecSize(int[][]rec){
        if(rec==null||rec.length==0||rec[0].length==0){
            return 0;
        }
        int maxArea=0;
        int[]height=new int[rec[0].length];
        for(int i=0;i<rec.length;i++){
            for (int j=0;j<rec[0].length;j++){
                height[j]=rec[i][j]==0?0:height[j]+1;
            }
            maxArea=Math.max(maxArea,maxRecFromBottom(height));
        }
        return maxArea;
    }
    public static int maxRecFromBottom(int[]arr){
        if (arr==null||arr.length==0){
            return 0;
        }
        int maxArea=0;
        Stack<Integer>stack=new Stack<>();
        for (int i=0;i<arr.length;i++){
            while (!stack.isEmpty()&&arr[stack.peek()]>=arr[i]){
                int j=stack.pop();
                int k=stack.isEmpty()?-1:stack.peek();
                int curArea=(i-k-1)*arr[j];
                maxArea=Math.max(curArea,maxArea);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()){
            int j=stack.pop();
            int k=stack.isEmpty()?-1:stack.peek();
            int curArea=(arr.length-k-1)*arr[j];
            maxArea=Math.max(curArea,maxArea);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[][]rec={
                {1,0,1,1},
                {1,1,1,1},
                {1,1,1,0}
        };
        int size=maxRecSize(rec);
        System.out.println(size);
    }
}
