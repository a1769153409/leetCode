package com.study.sf;

/**
 * 插入排序，每次从i+1的位置往0的位置滑动，一旦小于则交换，像斗地主滑动牌进行排序一样
 * description
 *
 * @author huanglehao 2020/08/28 18:13
 */
public class Code_0003_InsertSort {

    public void sort(int [] arr){
        if(arr==null||arr.length<2){
            return;
        }

        for(int i = 0 ;i<arr.length-1;i++){
            for(int j = i+1;j >0&&arr[j]<arr[j-1];j--){
                swap(arr,j,j--);
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
