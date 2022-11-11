package 算法课程实践.排序;

/**
 * @author zzl
 * @Description
 * @date 2022/4/4 - 16:53
 */
public class InsertSort {
    public static void insertSort(int[] arr){

        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            for (int j = i - 1; j >= 0 ; j--) {
                if(arr[j] > temp){
                    arr[j + 1] = arr[j];
                }else{
                    arr[j + 1] = temp;//找到插入位置的之后别忘了break
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-29,-10,20,32,56,34,23,21,78,87,43};
        insertSort(nums);
        for (int num : nums) {
            System.out.print(num + "  ");
        }
    }
}
