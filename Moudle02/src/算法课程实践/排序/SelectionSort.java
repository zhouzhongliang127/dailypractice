package 算法课程实践.排序;

/**
 * @author zzl
 * @Description
 * @date 2022/4/4 - 10:48
 */
public class SelectionSort {

    public static void selectionSort(int[] arr){

        for (int i = 0; i < arr.length - 1; i++) {//从i到N-1找到最小值放到i位置上
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr, minIndex, i);
        }
    }

    private static void swap(int[] arr, int minIndex, int i) {
        int temp = arr[minIndex];
        arr[minIndex] = arr[i];
        arr[i] = temp;
    }
}
