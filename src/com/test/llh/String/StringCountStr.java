package com.test.llh.String;

/**
 * 字符串的统计字符：
 * aaabbb 的统计字符为a_3_b_3
 * 用变量num统计每个字符出现的次数
 * cur代表当前统计字符串，每次遇到新字符时进行拼接
 */
public class StringCountStr {
    public String countStr(String str){
        if(str==null||str.equals("")){
            return "";
        }
        char[]arr=str.toCharArray();
        String cur=String.valueOf(arr[0]);
        int num=0;
        for (int i=1;i<arr.length;i++){
            if (arr[i]!=arr[i-1]){
                cur=concat(cur,String.valueOf(num),String.valueOf(arr[i]));
                num=0;
            }else{
                num++;
            }
        }
        //最后将最后一个字符的次数拼接上，因为上面是遇到新字符时进行拼接，对于最后一个字符不出现遇见新字符的情况
        return concat(cur,String.valueOf(num),"");
    }
    public String concat(String s1,String s2,String s3){
        return s1+"_"+s2+(s3.equals("")?s3:"_"+s3);
    }
    /**
     * 给定一个统计字符串索引，返回该索引在原字符串中对应的字符
     * 定义一个boolean值stage:true表示在字符阶段，false:表示在数子阶段
     * sum代表出现的累加和，比较sum与index的位置
     * cur代表当前遍历的字符
     * num代表数字值
     */
    public char getCharAt(String str,int index){
        if (str==null||str.equals("")){
            return 0;
        }
        char[]arr=str.toCharArray();
        boolean stage=true;
        int sum=0;
        char cur=0;
        int num=0;
        for (int i=0;i<arr.length;i++){
            if (arr[i]=='_'){
                stage=!stage;//切换状态
            }else if (stage){//遇到字符时开始计算
                sum+=num;
                num=0;
                if (sum>index){
                    return cur;
                }
                cur=arr[i];
            }else{
                num=num*10+(arr[i]-0);
            }
        }
        //最后加上最后一个字符出现的次数
        return sum+num>index?cur:0;
    }
}
