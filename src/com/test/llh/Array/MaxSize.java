package com.test.llh.Array;

/**
 * 边界都是1的最大正方形的大小：N X N的矩阵
 * 矩阵中只有0和1，
 * 遍历矩阵的每一个位置O(NXN)
 * 对每一个位置看是否能够成边长为N-1的左上角
 * 先生成两个矩阵：
 * 1.right表示每个位置往右连续的1的个数
 * 2.down表示每个位置往下连续的1的个数
 * 利用这两个矩阵加速判断过程，只需判断四个点
 */
public class MaxSize {
    public void setBorderMap(int[][]arr,int[][]right,int down[][]){
        if (arr==null||arr.length==0||arr[0]==null||arr[0].length==0){
            return;
        }
        int row=arr.length;
        int col=arr[0].length;
        if (arr[row-1][col-1]==1){
            right[row-1][col-1]=1;
            down[row-1][col-1]=1;
        }
        for (int i=row-2;i>-1;i--){
            if (arr[i][col-1]==1){
                right[i][col-1]=1;
                down[i][col-1]=down[i+1][col-1]+1;
            }
        }
        for (int i=col-2;i>-1;i--){
            if (arr[row-1][i]==1){
                right[row-1][i]=right[row-1][i+1]+1;
                down[row-1][i]=1;
            }
        }
        for (int i=row-2;i!=-1;i--){
            for (int j=col-2;j!=-1;j--){
                if (arr[i][j]==1){
                    right[i][j]=right[i][j+1]+1;
                    down[i][j]=down[i+1][j]+1;
                }
            }
        }
    }
    public int getMaxSize(int[][]arr){
        int[][]right=new int[arr.length][arr[0].length];
        int[][]down=new int[arr.length][arr[0].length];
        setBorderMap(arr,right,down);
        for (int i=Math.min(arr.length,arr[0].length);i!=0;i--){
            if(hasSizeOfBorder(i,right,down)){
                return i;
            }
        }
        return 0;
    }
    public boolean hasSizeOfBorder(int size,int[][]right,int[][]down){
        for (int i=0;i<right.length;i++){
            for (int j=0;j<right[0].length;j++){
                if (right[i][j]>=size&&down[i][j]>=size&&down[i][j+size-1]>=size&&right[i+size-1][j]>=size){
                    return true;
                }
            }
        }
        return false;
    }
}
