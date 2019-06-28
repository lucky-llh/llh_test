package com.test.llh.Array;

import java.util.Map;

/**
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class GetUglyNumber {
    /**
     * 维护三个队列，分别存放*2,3,5的数，每次取出队列中最小的数放入丑数数组中，指针后移
     * @param index
     * @return
     */
    public static int getUglyNumber(int index) {
        //0-6丑数都是其本身
        if(index<7){
            return index;
        }
        int[]res=new int[index];
        //第一个元素记为1
        res[0]=1;
        //定义三个指针，分别代表乘以2,3,5的指针移动
        int p2=0,p3=0,p5=0;
        for(int i=1;i<index;i++){
            res[i]= Math.min(res[p2]*2,Math.min(res[p3]*3,res[p5]*5));
            if(res[p2]*2==res[i]){
                p2++;
            }
            if (res[p3]*3==res[i]){
                p3++;
            }
            if(res[p5]*5==res[i]){
                p5++;
            }
        }
        return res[index-1];
    }

    public static void main(String[] args) {
        System.out.println(getUglyNumber(8));
    }

}
