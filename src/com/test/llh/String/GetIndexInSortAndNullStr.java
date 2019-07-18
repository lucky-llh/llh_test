package com.test.llh.String;

/**
 * 在有序但含有null的数组中查找字符串，可以利用二分查找
 */
public class GetIndexInSortAndNullStr {
    public int getIndex(String[]arr,String str){
        if (arr==null||arr.length==0||str==null){
            return -1;
        }
        int left=0;
        int right=arr.length-1;
        int res=-1;
        int mid=0;
        int i=0;
        while (left<=right){
            mid=(left+right)/2;
            if (arr[mid]!=null&&arr[mid].equals(str)){
                res=mid;//说名找到了，但应继续查找最左边是否出现
                right=mid-1;
            }else if (arr[mid]!=null){
                if (arr[mid].compareTo(str)<0){
                    left=mid+1;//去右边找
                }else{
                    right=mid-1;
                }
            }else{
                i=mid;
                while (--i>left&&arr[i]==null)
                    ;
                //整个左半区都为null或者找到不为null的位置小于str,应往右半区查找
                if (i<left||arr[i].compareTo(str)<0){
                    left=mid+1;
                }else{
                    res=arr[i].equals(str)?i:res;
                    right=i-1;
                }
            }
        }
        return res;
    }
}
