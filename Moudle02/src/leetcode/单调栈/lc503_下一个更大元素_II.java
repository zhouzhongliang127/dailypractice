package leetcode.单调栈;

import java.util.*;

public class lc503_下一个更大元素_II {
    public static int[] nextGreaterElements(int[] nums) {
        int[] numsPlus = new int[nums.length * 2];
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            numsPlus[i] = nums[i];
            numsPlus[n + i] = nums[i];
        }

        Deque<Integer> stack = new LinkedList<>();
        
        int[] nextBiggerIndex = new int[numsPlus.length];
        for (int i = 0; i < numsPlus.length; i++) {
            
            while(!stack.isEmpty() && numsPlus[i] > numsPlus[stack.peek()]){
                nextBiggerIndex[stack.poll()] = numsPlus[i];
            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            nextBiggerIndex[stack.poll()] = -1;
        }

        int[] ans = Arrays.copyOfRange(nextBiggerIndex, 0, n);
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,3};


        int[] ans = nextGreaterElements(nums);

        for (int an : ans) {
            System.out.print(an + " ");
        }

    }
}
