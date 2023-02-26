package leetcode;

import java.util.LinkedList;

public class lc239_滑动窗口最大值 {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];

        //值严格降序的下标序列
        LinkedList<Integer> list = new LinkedList<>();

        int L = 0;
        int index = 0;

        //i为窗口右边界
        for (int i = 0; i < nums.length; i++) {
            if(i < k){
                //当前数字入队前弹出小区等于它的数字
                while(list.size() != 0 && nums[i] >= nums[list.getLast()]){
                    list.removeLast();
                }
                list.addLast(i);
            }else{
                //右边界先右移
                while(list.size() != 0 && nums[i] >= nums[list.getLast()]){
                    list.removeLast();
                }
                list.addLast(i);
                //左边界右移
                if(list.getFirst() == L){
                    list.removeFirst();
                }
                L++;
            }
            if(i >= k - 1){
                res[index++] = nums[list.getFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,1,2,0,5};
        int k = 3;
        int[] res = maxSlidingWindow(nums, k);
        for (int re : res) {
            System.out.print(re + " ");
        }
    }
}
