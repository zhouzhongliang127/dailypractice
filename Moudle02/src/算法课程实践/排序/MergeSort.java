package 算法课程实践.排序;

/**
 * @author zzl
 * @Description
 * @date 2022/4/18 - 10:14
 */
public class MergeSort {
    public static void mergeSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    public static void process(int[] arr, int left, int right){
        if(left == right) return;
        int mid = left + ((right - left) >> 1);
        process(arr, left, mid);
        process(arr, mid + 1, right);
        merge(arr, left, right, mid);
    }
    public static void merge(int[] arr, int left, int right, int mid){
        int[] help = new int[right - left + 1];
        int index = 0;
        int i = left,j = mid + 1;
        while (i <= mid && j <= right){
            //小和问题加这一句
            //res += arr[i] < arr[j] ? right - j + 1 : 0;这时候下面就要改成<
            help[index++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }
        while(i <= mid) {
            help[index++] = arr[i++];
        }
        while(j <= right){
            help[index++] = arr[j++];
        }
        for (int num : help) {
            arr[left++] = num;
        }
    }
    public static void main(String[] args) {
        int[] nums = new int[]{-29,-10,20,32,56,34,23,21,78,87,43};
        //排序传下标时及得length—1
        mergeSort(nums);
        for (int num : nums) {
            System.out.print(" " + num);
        }
    }

}
