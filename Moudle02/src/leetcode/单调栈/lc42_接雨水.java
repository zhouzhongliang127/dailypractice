package leetcode.单调栈;

import java.util.Deque;
import java.util.LinkedList;

public class lc42_接雨水 {

    public static int trap(int[] height) {
        //先构建每个位置的左右侧最高柱子数组
        int[] lHeight = new int[height.length];
        int[] rHeight = new int[height.length];
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            lHeight[i] = max;
            max = max > height[i] ? max : height[i];

        }
        max = 0;
        for(int i = height.length - 1; i >= 0; i--){
            rHeight[i] = max;
            max = max > height[i] ? max : height[i];

        }

        int square = 0;

        for (int i = 1; i < height.length - 1; i++) {
            int h = Math.min(lHeight[i], rHeight[i]);
            if(h > height[i]){
                square += (h - height[i]);
            }

        }

        return square;
    }

    public static int trap_deque(int[] height) {
        Deque<Integer> stack = new LinkedList<>();

        int sum = 0;
        stack.push(0);
        for (int i = 1; i < height.length; i++) {
            while(!stack.isEmpty() && height[i] >= height[stack.peek()]){
                int bottom = stack.poll();
                //出了栈顶后先检测是否还有元素，有才构成凹陷
                if(!stack.isEmpty()){
                    int left = stack.peek();
                    //sum += 底 * 高
                    sum = sum + (i - left - 1) * (Math.min(height[left], height[i]) - height[bottom]);
                }
            }

            stack.push(i);
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
        System.out.println(trap_deque(height));
    }
}
