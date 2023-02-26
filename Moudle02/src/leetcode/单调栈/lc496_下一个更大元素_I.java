package leetcode.单调栈;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class lc496_下一个更大元素_I {

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer> stack = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int[] nextBiggerIndex = new int[nums2.length];
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
            while(!stack.isEmpty() && nums2[i] > nums2[stack.peek()]){
                nextBiggerIndex[stack.poll()] = i;
            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            nextBiggerIndex[stack.poll()] = -1;
        }
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            //获取当前数字在数组2中的下标
            int index = map.get(nums1[i]);
            ans[i] = nextBiggerIndex[index] == -1 ? -1 : nums2[nextBiggerIndex[index]];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{4,1,2};
        int[] nums2 = new int[]{1,3,4,2};

        int[] ans = nextGreaterElement(nums1, nums2);

        for (int an : ans) {
            System.out.print(an + " ");
        }

    }
}
