package com.test.llh.Array;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 最短通路的值：
 * 矩阵中1代表有路，0代表没路，每一个位置只要不越界，都有上下左右四个方向，求从左上角到右下角的最短通路：
 * 用一个map[i][j]表示从左上角0,0做到i,j位置的最短通路，同时把左上角位置的0,0，加入行，列队列中，
 * 不断从队列中弹出一个位置，看这个位置的上下左右在矩阵中为1，这些都是能走的位置，将这些位置加入队列中，不能重复走最后返回终点在map中的值
 * 如果队列为空都没有找到，则说明不存在这样的路径
 */
public class MinPatthValue {
    public int minPath(int[][]arr){
        if (arr==null||arr[0]==null||arr.length==0||arr[0].length==0||arr[0][0]==0||arr[arr.length-1][arr[0].length-1]==0){
            return 0;
        }
        int[][]map=new int[arr.length][arr[0].length];
        map[0][0]=1;
        Queue<Integer>rqueue=new LinkedList<>();
        Queue<Integer>cqueue=new LinkedList<>();
        ((LinkedList<Integer>) rqueue).add(0);
        ((LinkedList<Integer>) cqueue).add(0);
        int r=0;
        int c=0;
        while (!rqueue.isEmpty()){
            r=rqueue.poll();
            c=cqueue.poll();
            if (r==arr.length-1&&c==arr[0].length-1){
                return map[arr.length-1][arr[0].length-1];
            }
            walkTo(map[r][c],r-1,c,arr,map,rqueue,cqueue);//上
            walkTo(map[r][c],r+1,c,arr,map,rqueue,cqueue);//下
            walkTo(map[r][c],r,c-1,arr,map,rqueue,cqueue);//左
            walkTo(map[r][c],r,c+1,arr,map,rqueue,cqueue);//右
        }
        return 0;
    }
    public void walkTo(int pre,int row,int col,int[][]arr,int[][]map,Queue<Integer>rqueue,Queue<Integer>cqueue){
        //该位置走过即map中的值为1，或者该位置不为1，或者边界越界，说明都不能走
        if (row<0||row==arr.length||col<0||col==arr[0].length||arr[row][col]!=1||map[row][col]!=0){
            return;
        }
        map[row][col]=pre+1;
        cqueue.add(col);
        rqueue.add(row);
    }
}
