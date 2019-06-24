package com.test.llh.Array;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变
 */
public class ReOrderArray {
    public static void reOrderArray(int[]arr){
        if(arr==null||arr.length==0){
            return ;
        }
        for(int i=0;i<arr.length;i++){
            int target=arr[i];
            //当前元素为奇数时
            if(arr[i]%2==1){
                int j=i;
                //一次与他前面的偶数元素交换
                while (j>=1&&arr[j-1]%2==0){
                    int temp=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
                    j--;
                }
                arr[j]=target;
            }
        }
    }

    public static void main(String[] args) {
        int []arr={1,2,3,4,5,6,7};
        reOrderArray(arr);
        for(int i:arr){
            System.out.print(i+" ");
        }
    }
}
