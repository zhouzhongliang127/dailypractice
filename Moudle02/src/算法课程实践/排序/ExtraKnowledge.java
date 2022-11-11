package 算法课程实践.排序;

/**
 * @author zzl
 * @Description
 * @date 2022/4/18 - 9:42
 */
public class ExtraKnowledge {
    //递归找出最大值
    public static int getMax(int[] arr){
        return process(arr, 0, arr.length - 1);
    }
    public static int process(int[] arr, int left, int right){
        if(left == right) {
            return arr[left];
        }

        int mid = left + ((right - left) >> 1);
        int maxLeft = process(arr, left,mid);
        int maxRight = process(arr, mid + 1, right);
        return Math.max(maxLeft, maxRight);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-29,-10,20,32,56,34,23,21,78,87,43};
        System.out.println(getMax(nums));

    }
}
