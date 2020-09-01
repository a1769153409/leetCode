package com.study.sf;

/**
 * 冒泡排序
 * description
 *
 * @author huanglehao 2020/08/28 18:13（教学版本才会用）
 */
public class Code_0001_BubbleSort {

    public void sort(int [] arr){
        if(arr==null||arr.length<2){
            return;
        }
        for(int end = arr.length-1;end>0;end--){
            for(int i=0;i<end;i++){
                if(arr[i]>arr[i+1]){
                    swap(arr, i, i++);
                }
            }
        }
    }

    public static void swap (int []arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {

    }
}
