package com.test.llh.Array;

/**
 * 转圈打印矩阵
 */
public class OrderPrintMatrix {
    public static void orderPrint(int[][]matrix){
        int tr=0;
        int tc=0;
        int dr=matrix.length-1;
        int dc=matrix[0].length-1;
        while (tr<=dr&&tc<=dc){
            print(matrix,tr++,tc++,dr--,dc--);
        }
    }
    public static void print(int[][]arr,int tr,int tc,int dr,int dc){
        //只有一行
        if (tr==dr){
            for (int i=tc;i<=dc;i++){
                System.out.print(arr[tr][i]+" ");
            }
        }else if (tc==dc){
            //只有一列
            for(int i=tr;i<=dr;i++){
                System.out.print(arr[i][tc]+" ");
            }
        }else{
            //一般情况
            int temptr=tr;
            int temptc=tc;
            while (temptc!=dc){
                System.out.print(arr[tr][temptc]+" ");
                temptc++;
            }
            while (temptr!=dr){
                System.out.print(arr[temptr][dc]+" ");
                temptr++;
            }
            while (temptc!=tc){
                System.out.print(arr[dr][temptc]+" ");
                temptc--;
            }
            while (temptr!=tr){
                System.out.print(arr[temptr][tc]+" ");
                temptr--;
            }
        }
    }

    /**
     * 将正方形矩阵顺时针旋转90度
     * @param arr
     */
    public void rotate(int[][]arr){
        int tr=0;
        int tc=0;
        int dr=arr.length-1;
        int dc=arr[0].length-1;
        while (tr<=dr&&tc<=dc){
            rotateRange(arr,tr,tc,dr,dc);
        }
    }
    public void rotateRange(int[][]arr,int tr,int tc,int dr,int dc){
        int times=dc-tc;//每个子矩阵应该旋转的次数
        int temp=0;
        for (int i=0;i<times;i++){
            temp=arr[tr+i][tc];
            arr[tr+i][tc]=arr[dr-i][tc];
            arr[dr-i][tc]=arr[dr][tc-i];
            arr[dr][tc-i]=arr[tr+i][tc];
            arr[tr+i][tc]=temp;
        }
    }

    /**
     * 之子性打印矩阵
     * @param arr
     */
    public void printMatrixZigZag(int[][]arr){
        int tr=0;
        int tc=0;
        int dr=0;
        int dc=0;
        //从左下往右上打印true时
        boolean flag=false;
        int endR=arr.length-1;
        int endC=arr[0].length-1;
        while (tr!=endR+1){
            print(arr,tr,tc,dr,dc,flag);
            tr=tc==endC?tr+1:tr;
            tc=tc==endC?tc:tc+1;
            dr=dr==endR?dr:dr+1;
            dc=dr==endR?dc+1:dc;
        }
    }
    public void print(int[][]arr,int tr,int tc,int dr,int dc,boolean f){
        if (f){
            while (tr!=dr+1){
                System.out.print(arr[tr++][tc--]+" ");
            }
        }else{
            //从下往上
            while (dr!=tr-1){
                System.out.print(arr[dr--][dc++]+" ");
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
        orderPrint(arr);
    }
}
