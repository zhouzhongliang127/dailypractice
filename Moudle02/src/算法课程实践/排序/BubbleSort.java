package 算法课程实践.排序;

/**
 * @author zzl
 * @Description
 * @date 2022/4/4 - 11:22
 */
public class BubbleSort {

    public static void bubbleSort(int[] arr){
        for (int e = arr.length - 1 ; e > 0; e--) {
            for (int j = 0; j < e; j++) {
                if(arr[j] > arr[j + 1]){
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    private static void swap(int[] arr, int a, int b) {
       arr[a] = arr[a] ^ arr[b];//a = a ^ b
       arr[b] = arr[a] ^ arr[b];//b = (a ^ b) ^ b;b取a的值
       arr[a] = arr[a] ^ arr[b];//a = (a ^ b) ^ a;a取b的值
    }
}
