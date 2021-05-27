package 排序算法;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author caihe
 * @date 2021/5/27 16:13
 */
public class QuickSort {

    static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int start = left;
        int end = right;
        int stand = arr[end];
        while (start < end) {
            // 从右到左
            while (start < end) {
                if (stand < arr[start]) {
                    arr[end] = arr[start];
                    break;
                }
                start++;
            }
            //System.out.println(Arrays.toString(arr));
            while (start < end) {
                if (stand > arr[end]) {
                    arr[start] = arr[end];
                    break;
                }
                end--;
            }
            //System.out.println(Arrays.toString(arr));
        }
        arr[end] = stand;
        quickSort(arr, left, end - 1);
        quickSort(arr, end, right);

    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 3, 6, 7, 1, 3, 2};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }


    static void sortQuick(int[] arr, int begin, int end) {
        if (begin >= end) {
            return;
        }
        int start = begin;
        int stop = end;
        int stand = arr[start];

        while (start < stop) {
            while (start < stop && stand <= arr[stop]) {
                stop--;
            }
            arr[start] = arr[stop];
            while (start < stop && arr[start] <= stand) {
                start++;
            }
            arr[stop] = arr[start];
        }
        arr[start] = stand;

        sortQuick(arr, begin, start);
        sortQuick(arr, start + 1, end);
    }


}
