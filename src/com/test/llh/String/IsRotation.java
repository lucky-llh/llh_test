package com.test.llh.String;

/**
 * 判断两个字符串是否是旋转词：str字符串前面任意部分挪到后面形成的字符串叫做str的旋转词：
 *
 */
public class IsRotation {
    /**
     * 生成一个大的字符串：有两个b拼接而成，然后判断a是否是这个大字符串的子串:
     * 判断子串问题可以用KMP算法
     * @param a
     * @param b
     * @return
     */
    public boolean isRotation(String a,String b){
        if (a==null||b==null){
            return false;
        }
        String b2=b+b;
        return getIndex(b2,a)!=-1;
    }
    public int getIndex(String str,String mac){
        if (str==null||mac==null||mac.length()>str.length()||mac.length()<1){
            return -1;
        }
        char[]sArr=str.toCharArray();
        char[]mArr=mac.toCharArray();
        int[]next=getNext(mArr);
        int si=0;
        int mi=0;
        while (si<sArr.length&&mi<mArr.length){
            if (sArr[si]==mArr[mi]){
                si++;
                mi++;
            }else if (next[mi]==-1){
                si++;
            }else{
                mi=next[mi];
            }
        }
        return mi==mArr.length?si-mi:-1;
    }
    //获取每一个位置最长前缀和最长后缀匹配的最大长度
    public int[]getNext(char[]arr){
        if (arr==null||arr.length==0){
            return null;
        }
        int[]next=new int[arr.length];
        next[0]=-1;
        next[1]=0;
        int pos=2;
        int cn=0;
        while (pos<arr.length){
            if(arr[pos-1]==arr[cn]){
                next[pos++]=++cn;
            }else if (cn>0){
                cn=next[cn];
            }else{
                next[pos++]=0;
            }
        }
        return next;
    }
}
