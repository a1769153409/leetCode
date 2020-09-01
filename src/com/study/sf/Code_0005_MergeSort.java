package com.study.sf;

/**
 * 归并排序
 * 1.终止条件
 * 2.分治划分
 * 3.返回
 * description
 *
 * @author huanglehao 2020/08/28 18:13
 */
public class Code_0005_MergeSort {

    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length <2 ) {
            return;
        }
        sortProcess(arr, 0, arr.length - 1);
    }

    private static void sortProcess(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        int mid = L + ((R - L) >> 1);
        sortProcess(arr, L, mid);
        sortProcess(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    public static void merge(int[] arr, int L, int mid, int R) {
        int pL = L;
        int pR = mid + 1;
        int temp[] = new int[R - L + 1];
        int tempIndex = 0;
        while (pL <= mid && pR <= R) {
            temp[tempIndex++] = arr[pL] < arr[pR] ? arr[pL++] : arr[pR++];
        }
        while (pL <=mid) {
            temp[tempIndex++] = arr[pL++];
        }
        while (pR <= R) {
            temp[tempIndex++] = arr[pR++];
        }
        for (int i = 0; i < temp.length; i++) {
            arr[L + i] = temp[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 4, 2};
          mergeSort(arr);
          for(int i = 0; i < arr.length; i++) {
              System.out.println(arr[i]);
          }
        System.out.println(arr.toString());
    }
}
