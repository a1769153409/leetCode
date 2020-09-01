package com.study.sf;

/**
 * 选择排序，每一次循环选择一个最小的，插入到这次循环的起始点（教学版本才会用）
 * description
 *
 * @author huanglehao 2020/08/28 18:13
 */
public class Code_0002_SelectSort {

    public void sort(int [] arr){
        if(arr==null||arr.length<2){
            return;
        }

        for(int i = 0 ;i<arr.length-1;i++){
            int minIndex = i;
            for(int j = i+1;j <arr.length;j++){
                minIndex = arr[j]>arr[minIndex]?minIndex:j;
            }
            swap(arr, i, minIndex);
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
