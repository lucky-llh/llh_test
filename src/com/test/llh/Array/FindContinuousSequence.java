package com.test.llh.Array;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 和为s的连续正数序列
 */
public class FindContinuousSequence {

    public static ArrayList<ArrayList<Integer>> findContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>>res=new ArrayList<>();
        if (sum<=0){
            return res;
        }
        int pl=1;
        int pr=1;
        while (pl<=pr){
            int cur=(pl+pr)*(pr-pl+1)/2;
            if (cur==sum){
                ArrayList<Integer>list=new ArrayList<>();
                for (int i=pl;i<=pr;i++){
                    list.add(i);
                }
                res.add(list);
                pl++;
            }else if (cur<sum){
                pr++;
            }else{
                pl++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
       ArrayList<ArrayList<Integer>>res= findContinuousSequence(100);
       Iterator<ArrayList<Integer>>iterator=res.iterator();
       while (iterator.hasNext()){
           iterator.next().stream().forEach(System.out::println);
       }
    }
}
