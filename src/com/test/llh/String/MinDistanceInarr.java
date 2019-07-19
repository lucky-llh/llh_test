package com.test.llh.String;

/**
 * 数组中两个字符串的最小距离
 */
public class MinDistanceInarr {
    /**
     * 定义一个变量min代表str1和str2的最小值
     * last1记录str1最近一次出现的位置，last2记录str2最近一次出现的位置
     * 当遍历到字符串等于str1时，就用i-last2，同时更新最小值，等于str2时类似
     * @param arr
     * @param str1
     * @param str2
     * @return
     */
    public int minDistance(String[]arr,String str1,String str2){
        if (arr==null||str1==null||str2==null){
            return -1;
        }
        if (str1.equals(str2)){
            return 0;
        }
        int min=Integer.MAX_VALUE;
        int last1=-1;
        int last2=-1;
        for (int i=0;i<arr.length;i++){
            if (str1.equals(arr[i])){
                min=Math.min(min,last2==-1?min:i-last2);
                last1=i;
            }
            if (str2.equals(arr[i])){
                min=Math.min(min,last1==-1?min:i-last1);
                last2=i;
            }
        }
        return min==Integer.MAX_VALUE?-1:min;
    }
}
