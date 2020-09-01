package com.study.sf;

/**
 * 递归排序：
 * 1.终止条件
 * 2.分治划分
 * 3.返回
 * description
 *
 * @author huanglehao 2020/08/28 18:13
 */
public class Code_0004_RecursionSort {

  public static int getMax(int [] arr,int L,int R){
    //1.终止条件
    if(L==R){
      return arr[L];
    }
    //2.分治划分
    int mid = (L+R)/2;
    int leftMax = getMax(arr, L, mid);
    int rightMax = getMax(arr, mid + 1, R);

    //3.返回
    return Math.max(leftMax, rightMax);
  }

  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5};
    System.out.println(getMax(arr,0,4));
  }
}
