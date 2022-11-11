package leetcode;

/**
 * @author zzl
 * @Description
 * @date 2022/4/18 - 14:16
 */
class 数组中的逆序对 {
    public static int reversePairs(int[] nums) {
        if(nums == null || nums.length < 2){
            return 0;
        }
        return process(nums, 0, nums.length - 1);
    }

    public static int process(int[] arr, int left, int right){
        if(left == right){
            return 0;
        }
        int mid = left + ((right - left) >> 1);
        return process(arr, left, mid) + process(arr, mid + 1, right) + merge(arr, left, right, mid);
    }
    public static int merge(int[] arr, int left, int right, int mid){
        int[] help =new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int index = 0;
        int res = 0;
        while(i <= mid && j <= right){
            //记录左边比右边大的数量或者右边比左边小的数量?不妥，对比之后一定是小的被拷贝，所以当右边的小时右边的会被拷贝所以此时应该记录左边有几个比这个数大，如果是想记录右边比左边小的数量，在找到arr[i] > arr[j]时可以计算出右侧有多少个小于arr[i]，但是后续被拷贝的是小的，arr[i]依旧参与后续的merge，后续计算出来的逆序数会包含之前统计过的，所以这类问题中，只能在拷贝下去的另一侧统计
            res += arr[i] > arr[j] ? mid - i + 1 : 0;
            help[index++] = arr[i] > arr[j] ? arr[j++] : arr[i++];
        }
        while(i <= mid){
            help[index++] = arr[i++];
        }
        while(j <= right){
            help[index++] = arr[j++];
        }
        for (int num : help) {
            arr[left++] = num;
        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,1,2,1};
        System.out.println(reversePairs(nums));
    }
}