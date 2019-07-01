package com.test.llh.BitOperation;

/**
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class Sum {
    /**
     * 可以使用短路与进行运算
     * @param n
     * @return
     */
    public static int sum_Solution(int n) {
        int sum=n;
        //当n<0时就直接终止，不在进行递归
        boolean flag=(n>0)&&((sum+=sum_Solution(n-1))>0);
        return sum;
    }

    public static void main(String[] args) {
        int n=10;
        System.out.println(sum_Solution(n));
    }

}
