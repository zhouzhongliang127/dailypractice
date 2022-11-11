package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zzl
 * @Description
 * @date 2021/11/4 - 20:34
 */
public class Count_of_Smaller_Numbers_After_Self {
    public static List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        List<Integer> result = new ArrayList<>();
        if(n == 0) return result;
        //声明索引数组，与nums数组的小标为一一对应关系
        //为什么声明索引数组
        //这里需要统计nums中每个元素对应的逆序数数量，要准备一个数组来统计每个位置上的
        //逆序数数量，但在归并过程中，会丢失nums与该数组对应关系，所以用索引数组排序的方法保证原数组不动，
        //索引数组既有nums的值的信息，也有其对应下标的信息，根据值进行归并，在根据下标进行逆序数量的存贮
        int[] index = new int[n];
        int[] temp = new int[n];
        int[] res = new int[n];
        //下标数组初始化
        for(int i = 0;i < n;i++){
            index[i] = i;
        }
        mergeSortAndCountSmaller(nums,0,n-1,index,temp,res);
        for(int i = 0;i < n;i++){
            result.add(res[i]);
        }
        for (int re : index) {
            System.out.print(nums[re]+"  ");
        }
        return result;
    }
    public static void mergeSortAndCountSmaller(int[] nums, int left, int right, int[] index, int[] temp,int[] res){
        if(left == right) return ;
        int mid = left + ((right -left) >> 1);
        mergeSortAndCountSmaller(nums,left,mid,index,temp,res);
        mergeSortAndCountSmaller(nums,mid+1,right,index,temp,res);

        // 归并排序的优化，如果索引数组有序，则不存在逆序关系，没有必要合并
        if (nums[index[mid]] <= nums[index[mid + 1]]) {
            return;
        }

        merge(nums,left,mid,right,index,temp,res);

    }
    public static void merge(int[] nums,int left,int mid, int right, int[] index, int[] temp, int[] res){
        int i = left;
        int j = mid + 1;
        int t = left;
        while(i <= mid && j <= right){
            //这里不同于之前的逆序数，之前的只要得到数量，不用统计每一位的，故之前当右边满足逆序定义左边都大于他，
            //直接可得该部分逆序数的数量，而现在要计算各位上的逆序数量，则要改变计数方法
            //这里当左边区域出值时统计右边比他小的数量，左边出值时因为在右边遇到了比他大的，所以mid+1到j的左闭右开区间内数的个数
            //为出来的这个元素在此次合并所统计到的逆序数的个数
            res[index[i]] += nums[index[i]] <= nums[index[j]] ? j-mid-1:0;
            temp[t++] = nums[index[i]] <= nums[index[j]] ? index[i++]:index[j++];

        }
        while(i <= mid){
            res[index[i]] += right - mid;
            temp[t++] = index[i++];
        }
        while(j <= right){
            temp[t++] = index[j++];
        }
        for(int k = left; k <= right; k++){
            index[k] = temp[k];
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,2,6,1};
        List<Integer> result = countSmaller(nums);
        for (Integer integer : result) {
            System.out.print(integer+"  ");
        }
    }
}

