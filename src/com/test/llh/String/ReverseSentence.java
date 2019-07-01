package com.test.llh.String;

/**
 * 反转单词顺序列：
 * “student. a am I”--->“I am a student.”
 */
public class ReverseSentence {
    /**
     * 1.先整体反转
     * 2.在反转每个单词
     * @param str
     * @return
     */
    public static String reverseSentence(String str) {
        if (str==null||str.length()==0){
            return "";
        }
        char[]arr=str.toCharArray();
        int l=-1;
        int r=-1;
        reverseString(arr,0,arr.length-1);
        for (int i=0;i<arr.length;i++){
            if (arr[i]!=' '){
                l=i==0|| arr[i-1]==' '?i:l;
                r=i==arr.length-1||arr[i+1]==' '?i:r;
            }
            if (l!=-1&&r!=-1){
                reverseString(arr,l,r);
                l=-1;
                r=-1;
            }
        }
        return String.valueOf(arr);
    }
    public static void reverseString(char[]arr,int start,int end){
        while (start<=end){
            char temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        String str="student. a am I";
        System.out.println(reverseSentence(str));
    }
}
