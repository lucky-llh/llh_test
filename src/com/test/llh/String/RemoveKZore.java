package com.test.llh.String;

/**
 * 去掉字符串中连续出现的k个0字符;
 * 把去掉0的时机放在不是0字符时，用count统计连续0出现的次数，start代表0出现的开始位置
 */
public class RemoveKZore {
    public String removeKZore(String str,int k){
        if (str==null){
            return str;
        }
        char[]arr=str.toCharArray();
        int count =0;
        int start=-1;
        for (int i=0;i<arr.length;i++){
            if (arr[i]=='0'){
                count++;
                start=start==-1?i:start;
            }else{
                if (count==k){
                    while (count--!=0){
                        arr[start++]=0;
                    }
                }
                //一组完成后初始化count和start值
                count=0;
                start=-1;
            }
        }
        if (count==k){
            while (count--!=0){
                arr[start++]=0;
            }
        }
        return String.valueOf(arr);
    }
}
