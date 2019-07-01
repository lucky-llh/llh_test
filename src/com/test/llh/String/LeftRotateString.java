package com.test.llh.String;

/**
 * 左旋转字符串：对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
 */
public class LeftRotateString {
    /**
     * yx=(x^ty^t)^t就是xy=(y的旋转*x的旋转）整体在进行反转
     * 所以根据n将字符串分为两部分，先把左边部分进行旋转，再把右半部分进行旋转，在整体进行旋转就得到最后左旋的结果
     * @param str
     * @param n
     * @return
     */
    public static String leftRotateString(String str,int n) {
        if(str==""||str.length()<n){
            return "";
        }
        char[]arr=str.toCharArray();
        //左半部分
        swap(arr,0,n-1);
        //有右半部分
        swap(arr,n,arr.length-1);
        //整体旋转
        swap(arr,0,arr.length-1);
        return String.valueOf(arr);
    }
    public static void swap(char[]arr,int start,int end){
        while (start<=end){
            char temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }
    public static void main(String[] args) {
        String str="abcXYZdef";
        int n=3;
        System.out.println(leftRotateString(str,n));
    }
}
