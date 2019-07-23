package com.test.llh.Array;

import com.llh.hashmap.MyMap;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

/**
 * 在数组中找到出现次数超过N/k的数：
 *
 */
public class PrintNKMajor {
    /**
     * 找到数组中出现次数超过数组一半的元素：
     * 每次删除数组中两个不同的数，最后剩下的数可能为超过数组一半的元素
     * cand表示候选的值，time表示只出现的次数
     * @param arr
     */
    public void printHalfMajor(int[]arr){
        if(arr==null||arr.length==0){
            return;
        }
        int cand=0;
        int time=0;
        for (int i=0;i<arr.length;i++){
            if (time==0){
                //说明还没有两个数
                cand=arr[i];
                time=1;
            }else if (arr[i]==cand){
                //如果当前值等于候选，说明没有出现两个不同的数，就将候选出现的次数加1
                time++;
            }else{
                //如果当前数不等于候选并且已经存在一个数，说明找到了两个不同的数，将当前候选的time-1,相当于删除了两个不同的数
                time--;
            }
        }
        time=0;
        for (int i=0;i<arr.length;i++){
            if (arr[i]==cand){
                time++;
            }
        }
        if (time>arr.length/2){
            System.out.println(cand);
        }else{
            System.out.println("no this num");
        }
    }

    /**
     * 由上面方法可知，找到出现次数超过n/k的数，需要建立k-1个候选，然后有k-1的time统计，
     * 用map记录：
     * 遍历数组时，遍历到arr[i]，首先判断arr[i]与当前候选中是否有相同的，若有就将对应候选的time+1；
     * 若没有，看当前候选的个数是否到达k-1个，若到达说明候选满了，需要删除，
     * 若没满，就将当前值作为新的候选添加到新的候选中
     * @param arr
     * @param k
     */
    public void printNlNum(int[]arr,int k){
        if(arr==null||arr.length==0){
            return;
        }
        HashMap<Integer,Integer>cand=new HashMap<>();
        for (int i=0;i<arr.length;i++){
            if (cand.containsKey(arr[i])){
                cand.put(arr[i],cand.get(arr[i])+1);
            }else{
                if (cand.size()==k-1){
                    allCandsRemoveOne(cand);
                }else{
                    cand.put(arr[i],1);
                }
            }
        }
        boolean hashPrint=false;
        //得到真正超过n/k的候选
        HashMap<Integer, Integer>real=getRealCand(arr,cand);
        for (Map.Entry<Integer,Integer>entry:real.entrySet()){
            int key=entry.getKey();
            if (real.get(key)>arr.length/k){
                hashPrint=true;
                System.out.print(key+" ");
            }
        }
        System.out.println(hashPrint?"":"no such num");
    }

    /**
     * 对于移除后time=0的说明还需要把当前候选删除
     * @param map
     */
    public void allCandsRemoveOne(HashMap<Integer,Integer>map){
        List<Integer> removeList=new ArrayList<>();
        for (Map.Entry<Integer,Integer>entry:map.entrySet()){
            Integer key=entry.getKey();
            Integer value=entry.getValue();
            if (value==1){
                removeList.add(key);
            }
            map.put(key,value-1);
        }
        for (Integer removeKey:removeList){
            map.remove(removeKey);
        }
    }
    public HashMap<Integer,Integer>getRealCand(int[]arr,HashMap<Integer,Integer>cands){
        HashMap<Integer,Integer>real=new HashMap<>();
        for (int i=0;i<arr.length;i++){
            if (cands.containsKey(arr[i])){
                if (real.containsKey(arr[i])){
                    real.put(arr[i],real.get(arr[i])+1);
                }else{
                    real.put(arr[i],1);
                }
            }
        }
        return real;
    }
}
