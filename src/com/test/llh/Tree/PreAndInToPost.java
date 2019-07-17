package com.test.llh.Tree;

import java.util.HashMap;

/**
 * 通过先序和中序数组生成后序数组
 */
public class PreAndInToPost {
    public int[]makePost(int[]pre,int[]in){
        if (pre==null||in==null){
            return null;
        }
        int len=pre.length;
        int[]post=new int[len];
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<in.length;i++){
            map.put(in[i],i);
        }
        setPost(pre,0,pre.length-1,in,0,in.length-1,post,len-1,map);
        return post;
    }
    public int setPost(int[]pre,int pi,int pj,int[]n,int ni,int nj,int[]post,int si,HashMap<Integer,Integer>map){
        if (pi>pj){
            return si;
        }
        post[si--]=pre[pi];
        int index=map.get(pre[pi]);
        si=setPost(pre,pj-nj+index+1,pj,n,index+1,nj,post,si,map);
        return setPost(pre,pi+1,pi+index-ni,n,ni,index-1,post,si,map);
    }
}
