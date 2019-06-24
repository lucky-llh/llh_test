package com.test.llh.Recursion;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class PrintMatrix {

    public static ArrayList<Integer> printMatrix(int [][] matrix){
        ArrayList<Integer>list=new ArrayList<>();
        if(matrix==null||matrix[0]==null||matrix.length==0||matrix[0].length==0){
            return list;
        }
        int tr=0;
        int tc=0;
        int dr=matrix.length-1;
        int dc=matrix[0].length-1;
        while (tr<=dr&&tc<=dc){
            process(matrix,tr++,tc++,dr--,dc--,list);
        }
        return list;
    }

    public static void process(int[][]arr,int tr,int tc,int dr,int dc,ArrayList<Integer>list){
        if(tr==dr){
            //说明只有一行
            for(int i=tc;i<=dc;i++){
                list.add(arr[tr][i]);
            }
        }else if(tc==dc){
            //只有一列
            for(int i=tr;i<=dr;i++){
                list.add(arr[i][tc]);
            }
        }else{
            int tempr=tr;
            int tempc=tc;
            while (tempc!=dc){
                list.add(arr[tr][tempc]);
                tempc++;
            }
            while (tempr!=dr){
                list.add(arr[tempr][dc]);
                tempr++;
            }
            while (tempc!=tc){
                list.add(arr[dr][tempc]);
                tempc--;
            }
            while (tempr!=tr){
                list.add(arr[tempr][tc]);
                tempr--;
            }
        }
    }

    public static void main(String[] args) {
        int[][]arr={
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        ArrayList list=printMatrix(arr);
        Iterator iterator=list.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next()+" ");
        }
    }

}
