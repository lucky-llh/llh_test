package com.test.llh.String;

/**
 * 翻转字符串
 */
public class RotateWord {
    /**
     * 把 pig love 翻转后为loval pig
     * 先把字符串整体翻转，再把每个单词进行翻转
     * @param arr
     */
    public void rotateWord(char[]arr){
        if (arr==null||arr.length==0){
            return;
        }
        //翻转整体
        reverse(arr,0,arr.length-1);
        int l=-1;
        int r=-1;
        for (int i=0;i<arr.length;i++){
            if (arr[i]!=' '){
                //单词开始索引
                l=i==0||arr[i-1]==' '?i:l;
                //单词结束索引
                r=i==arr.length-1||arr[i+1]==' '?i:r;
            }
            if (l!=-1&&r!=-1){
                reverse(arr,l,r);
                l=-1;
                r=-1;
            }
        }
    }
    public void reverse(char[]arr,int start,int end){
        char temp=0;
        while (start<end){
            temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }

    /**
     * 给定一个字符数组，和一个size,把大小为size的左半区移动到右半区
     * ：
     * 先把0，size-1翻转，再把size,length翻转，在整体反转
     * @param arr
     * @param size
     */
    public void rotate(char[]arr,int size){
        reverse(arr,0,size-1);
        reverse(arr,size,arr.length-1);
        reverse(arr,0,arr.length-1);
    }
}
