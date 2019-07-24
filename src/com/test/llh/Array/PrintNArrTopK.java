package com.test.llh.Array;

/**
 * 打印N个数组的整体最大TOPK:
 * 利用堆排序实现，
 * 首先建立一个包含N个元素的堆，堆顶为最大值，然后查看堆顶元素是来自哪个数组的哪个位置，若该位置已经是数组的最左边一个元素，
 * 就把堆中的最后一个元素放在堆顶，然后调整堆，直到找到k个元素
 * ，若该位置不是数组最左元素，就把该位置前一个元素放在堆顶，调整堆
 */
public class PrintNArrTopK {
    public class HeapNode{
        public int value;//值
        public int arrNum;//来自哪个数组
        public int index;//数组中的位置
        public HeapNode(int value,int arrNum,int index){
            this.value=value;
            this.arrNum=arrNum;
            this.index=index;
        }
    }
    public void printTopk(int[][]arr,int topk){
        if (arr==null||arr[0]==null||arr.length==0||arr[0].length==0){
            return;
        }
        int heapSize=arr.length;
        HeapNode[]node=new HeapNode[heapSize];
        for (int i=0;i!=heapSize;i++){
            int index=arr[i].length-1;
            node[i]=new HeapNode(arr[i][index],i,index);
            heapInsert(node,i);
        }
        System.out.println("TOP "+topk+" :");
        for (int i=0;i!=topk;i++){
            if (heapSize==0){
                break;
            }
            System.out.println(node[0].value+" ");
            if (node[0].index!=0){
                node[0].value=arr[node[0].arrNum][node[0].index-1];
            }else{
                swap(node,0,heapSize--);
            }
            heapify(node,0,heapSize);
        }
    }
    public void heapInsert(HeapNode[]arr,int index){
        while (index!=0){
            int parent=(index-1)/2;
            if (arr[parent].value<arr[index].value){
                swap(arr,parent,index);
                index=parent;
            }else{
                break;
            }
        }
    }
    public void heapify(HeapNode[]nodes,int index,int heapSize){
        int left=2*index+1;
        int right=2*index+2;
        int largest=index;
        while (left<heapSize){
            if (nodes[left].value>nodes[largest].value){
                largest=left;
            }
            if (right<heapSize&&nodes[right].value>nodes[largest].value){
                largest=right;
            }
            if (largest!=right){
                swap(nodes,largest,index);
            }else{
                break;
            }
            index=largest;
            left=2*index+1;
            right=2*index+2;
        }
    }
    public void swap(HeapNode[]nodes,int i,int j){
        HeapNode temp=nodes[i];
        nodes[i]=nodes[j];
        nodes[j]=temp;
    }
}
