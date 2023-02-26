package leetcode.单调栈;

import java.util.Deque;
import java.util.LinkedList;

public class lc84_柱状图中最大的矩形 {

    //左右扩张到第一个小于自己的元素

    public static int largestRectangleArea(int[] heights) {

        //找小压小
        Deque<Integer> stack = new LinkedList<>();

        int[] leftMin = new int[heights.length];
        int[] rightMin = new int[heights.length];
        int n = heights.length;

        for (int i = 0; i < n; i++) {

            while(!stack.isEmpty() && heights[i] < heights[stack.peek()]){
                int topIndex = stack.poll();
                leftMin[topIndex] = stack.isEmpty() ? -1 : stack.peek();//左侧没有比自己小的就可以一直扩
                rightMin[topIndex] = i;
            }

            stack.push(i);
        }

        while(!stack.isEmpty()){
            int topIndex = stack.poll();
            leftMin[topIndex] = stack.isEmpty() ? -1 : stack.peek();
            rightMin[topIndex] = n;//右侧没有比自己小的也是扩到头
        }

        int maxSquare = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            int square = heights[i] * (rightMin[i] - leftMin[i] - 1);
            maxSquare = maxSquare >= square ? maxSquare : square;
        }

        return maxSquare;
    }

    public static void main(String[] args) {
        int[] heights = new int[]{2,4};
        System.out.println(largestRectangleArea(heights));

    }
}
