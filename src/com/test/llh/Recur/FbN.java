package com.test.llh.Recur;

/**
 * 斐波那契数列
 */
public class FbN {
    /**
     * 递归方式:o(N2)
     * @param n
     * @return
     */
    public int f1(int n){
        if (n<1){
            return 0;
        }
        if (n==1||n==2){
            return 1;
        }
        return f1(n-1)+f1(n-2);
    }

    /**
     * 非递归直接计算：o(N)
     * @param n
     * @return
     */
    public int f2(int n){
        if (n<1){
            return 0;
        }
        if(n==1||n==2){
            return 1;
        }
        int pre=1;
        int res=1;
        int temp=0;
        for (int i=3;i<=n;i++){
            temp=res;
            res=res+pre;
            pre=temp;
        }
        return res;
    }

    /**
     * 用求矩阵n次方的形式求解：O(N)
     * f(n),f(n-1)=(f(n-1),f(n-2))x|1110|
     * @param n
     * @return
     */
    public int f3(int n){
        if (n<1){
            return 1;
        }
        if (n==1||n==2){
            return 1;
        }
        int[][]base={{1,1},{1,0}};
        int res[][]=matrixPower(base,n-2);
        return res[0][0]+res[1][0];
    }
    public int[][]matrixPower(int[][]m,int p){
        int[][]res=new int[m.length][m[0].length];
        for (int i=0;i<res.length;i++){
            res[i][i]=1;
        }
        int temp[][]=m;
        for (; p!=0; p>>=1){
            if((p&1)!=0){
                res=mulitPower(res,temp);
            }
            temp=mulitPower(temp,temp);
        }
        return res;
    }
    public int[][]mulitPower(int[][]m1,int[][]m2){
        int[][]res=new int[m1.length][m1[0].length];
        for (int i=0;i<m1.length;i++){
            for (int j=0;j<m2[0].length;j++){
                for(int k=0;k<m2.length;k++){
                    res[i][j]+=m1[i][k]*m2[k][j];
                }
            }
        }
        return res;
    }

}
