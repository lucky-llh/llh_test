package com.test.llh.Bit;

/**
 * 1.数组中只有一个数出现奇数次，其余出现偶数次，找出出现奇数次的数
 * 2.数组中只有两个数出现奇数次，其余出现偶数次，找出出现奇数次的数
 * 3.数组中其他数都出现了K次，只有一个数出现了一次，找出该数
 * 根据a^a=0,a^0=a计算
 */
public class FindOldNum {
    public static int findOnlyOneNum(int[]arr){
        int eOne=0;
        for(int num:arr)
        {
            eOne^=num;
        }
        return eOne;
    }
    public static int[]findOnlyOneTwoNum(int[]arr){
        int eO=0;
        int eHashOne=0;
        for (int num:arr){
            eO^=num;
        }
        //eO计算的结果为两个出现奇数次的数亦或的结果，肯定不为0，所以在eO的某一位上肯定有一位为1，则该位置对应那两个奇数的该位置肯定一个为1，一个为0
        //假设第k为为1，再次遍历数组，让ehashone只与第k位上为1的结点进行亦或运算，最后得到的值肯定为其中的一个
        int rightOne=eO&(~eO+1);
        for(int cur:arr){
            if((cur&1)!=0){
                eHashOne^=cur;
            }
        }
        int[]res=new int[2];
        res[0]=eHashOne;
        eO=eO^eHashOne;
        res[1]=eO;
        return res;
    }

    /**
     * 让数组中的元素转换成k进制数，进行无进位相加，两个k进制数进行无进位相加的结果为(a(i)+b(i))%k;
     * k个相同的数进行无进位相加肯定为0，
     * 定义一个32位变量eO,将每个元素与其进行无进位相加，最后得到的结果转换称十进制就是结果
     * @param arr
     * @param k
     * @return
     */
    public static int onceNum(int[]arr,int k){
        int[]eO=new int[32];
        for(int i=0;i<arr.length;i++){
            setExclusive(eO,arr[i],k);
        }
        int res=getNumFromKSystem(eO,k);
        return res;
    }
    public static void setExclusive(int[]eO,int value,int k){
        int[]curKSystem=getKSystemFromNum(value,k);
        for (int i=0;i<eO.length;i++){
            eO[i]=(eO[i]+curKSystem[i])%k;
        }
    }

    /**
     * 将10进制转换成k进制
     * @param value
     * @param k
     * @return
     */
    public static int[]getKSystemFromNum(int value,int k){
        int[]res=new int[32];
        int index=0;
        while (value!=0){
            res[index++]=value%k;
            value/=k;
        }
        return res;
    }

    /**
     * 将k进制数转换称10进制数
     * @param eO
     * @param k
     * @return
     */
    public static int getNumFromKSystem(int[]eO,int k){
        int res=0;
        for(int i=eO.length-1;i>=0;i--){
            res=res*k+eO[i];
        }
        return res;
    }


    public static void main(String[] args) {
        int []arr={1,2,3,3,4,4};
        int[]res=findOnlyOneTwoNum(arr);
        System.out.println(res[0]+"====="+res[1]);
    }
}
