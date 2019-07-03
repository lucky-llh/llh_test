package com.test.llh.Array;

/**
 * 构建乘积数组：
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 */
public class Multiply {
    public static int[]multiply(int[]arr){
        if (arr==null||arr.length==0){
            return null;
        }
        int[]res=new int[arr.length];
        res[0]=arr[0];
        for (int i=1;i<arr.length;i++){
            res[i]=res[i-1]*arr[i];
        }
        int temp=1;
        for (int i=arr.length-1;i>0;i--){
            res[i]=res[i-1]*temp;
            temp*=arr[i];
        }
        res[0]=temp;
        return res;
    }

    public static void main(String[] args) {
        int[]arr={1,2,3,4,5};
        int[]res=multiply(arr);
        for(int num:res){
            System.out.print(num+" ");
        }
    }
}
