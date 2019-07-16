package com.test.llh.Tree;

/**
 * 判断t1树中是否有与t2树拓扑结构完全相同的子树:
 * 思路：将两课树先序列化，然后利用字符串匹配计算（kmp算法）
 */
public class IsSubtree {
    public boolean isSubTree(TreeNode node1,TreeNode node2){
        String str1=serialByPre(node1);
        String str2=serialByPre(node2);
        return getIndexOf(str1,str2)!=-1;
    }
    public String serialByPre(TreeNode node){
        if (node==null){
            return "#!";
        }
        String str=node.val+"!";
        str+=serialByPre(node.left);
        str+=serialByPre(node.right);
        return str;
    }
    public int getIndexOf(String str,String match){
        if (str==null||match==null||match.length()>str.length()||match.length()<1){
            return -1;
        }
        char[]sArr=str.toCharArray();
        char[]mArr=match.toCharArray();
        int s=0;
        int m=0;
        int []next=getNextArray(mArr);
        while (s<sArr.length&&m<mArr.length){
            if (sArr[s]==mArr[m]){
                s++;
                m++;
            }else if(next[m]==-1){
                s++;
            }else{
                m=next[m];
            }
        }
        //如果匹配就返回匹配开始位置，否则返回-1
        return m==mArr.length?s-m:-1;
    }
    public int[]getNextArray(char[]arr){
        if (arr.length==1){
            return new int[]{-1};
        }
        int[]res=new int[arr.length];
        res[0]=-1;
        res[1]=1;
        int pos=2;
        int cn=0;
        while (pos<arr.length){
            if (arr[pos-1]==arr[cn]){
                res[pos++]=cn+1;
            }else if (cn>0){
                cn=res[cn];
            }else{
                res[pos++]=0;
            }
        }
        return res;
    }

}
