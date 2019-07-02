package com.test.llh.String;

import java.beans.beancontext.BeanContext;

/**
 * 字符串转换成整数：将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，但是string不符合数字要求时返回0)，
 * 要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 */
public class StrToInt {
    /**
     * 1.首先判断字符串是否合法
     *    （1）：以字符开头并且长度为1，或者第二位为0，不合法
     *    （2）：以0开否长度不为1，不合法
     *    （3）：以字符开头，后面不是数字，不合法
     *    （4）：在遍历字符串时，出现字符，不合法
     * 2.根据符号返回整数
     * @param str
     * @return
     */
    public static int stringToInt(String str) {
        if(str==null||str.length()==0){
            return 0;
        }else if (str.length()==1&&(str.charAt(0)=='-'||str.charAt(0)=='+')){
            return 0;
        }else {
            boolean error=false;
            int index=0;
            int res=0;
            int flag=0;
            char[]arr=str.toCharArray();
            if(arr[0]=='+'){
                index++;
                flag=1;
            }
            if (arr[0]=='-'){
                index++;
                flag=2;
            }
            for (int i=index;i<arr.length;i++){
                if (arr[i]>'0'&&arr[i]<'9'){
                    res=res*10+(arr[i]-'0');
                }else{
                    error=true;
                    break;
                }
            }
            if (!error){
                if (flag==2){
                    res=-res;
                }
                return res;
            }else{
                return 0;
            }
        }
    }

    public static void main(String[] args) {
        String str="-0123";
        System.out.println(stringToInt(str));
    }
}
