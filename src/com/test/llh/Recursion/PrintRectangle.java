package com.test.llh.Recursion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class PrintRectangle {
    public static void printRec(int[][]rec){
        if(rec==null||rec[0]==null||rec.length==0||rec[0].length==0){
            return;
        }
        int tr=0;
        int tc=0;
        int dr=rec.length-1;
        int dc=rec[0].length-1;
        while (tr<=dr&&tc<=dc){
            process(tr++,tc++,dr--,dc--,rec);
        }
    }
    public static void process(int tr,int tc,int dr,int dc,int[][]rec){
        if(tr==dr){
            for(int i=tc;i<=dc;i++){
                System.out.print(rec[tr][i]+" ");
            }
        }else if(tc==dc){
            for(int i=tr;i<=dr;i++){
                System.out.print(rec[i][tc]+" ");
            }
        }else{
            int tempr=tr;
            int tempc=tc;
            while (tempc!=dc){
                System.out.print(rec[tr][tempc]+" ");
                tempc++;
            }
            while (tempr!=dr){
                System.out.print(rec[tempr][dc]+" ");
                tempr++;
            }
            while (tempc!=tc){
                System.out.print(rec[dr][tempc]+" ");
                tempc--;
            }
            while (tempr!=tr){
                System.out.print(rec[tempr][tc]+" ");
                tempr--;
            }
        }
    }
    public static void main(String[] args) {
        int[][]arr={
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
//        ArrayList list=printMatrix(arr);
//        Iterator iterator=list.iterator();
//        while (iterator.hasNext()){
//            System.out.print(iterator.next()+" ");
//        }
        printRec(arr);
    }
}
