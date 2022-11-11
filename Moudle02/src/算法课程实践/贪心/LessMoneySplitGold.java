package 算法课程实践.贪心;

/**
 * @author zzl
 * @Description
 * @date 2022/9/11 - 12:07
 */

import java.util.PriorityQueue;
import java.util.Queue;

public class LessMoneySplitGold {

    public static int lessMoneySplitGold(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        Queue<Integer> queue = new PriorityQueue<>();
        for(int num : arr){
            queue.add(num);
        }
        int mergeCost = 0;
        int res = 0;
        while(queue.size() > 1){
            mergeCost = queue.poll() + queue.poll();
            res += mergeCost;
            queue.add(mergeCost);
        }
        return res;
    }

    /**
     * 对数器方法
     */
    public static int lessMoneySplitGold1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        return process(arr, 0);
    }

    /**
     * arr中只剩一个数字的时候，停止合并
     *
     * @param arr 当前数组中等待合并的数
     * @param pre 之前的合并行为产生了多少总代价（需要花费的铜板数）
     * @return 最小的总代价
     */
    private static int process(int[] arr, int pre) {
        if (arr.length == 1) {
            return pre;
        }
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                answer = Math.min(answer, process(copyMergeTwo(arr, i, j), pre + arr[i] + arr[j]));
            }
        }
        return answer;
    }

    private static int[] copyMergeTwo(int[] arr, int i, int j) {
        int length = arr.length - 1;
        int[] ans = new int[length];
        int resultIndex = 0;
        for (int k = 0; k < arr.length; k++) {
            if (k != i && k != j) {
                ans[resultIndex++] = arr[k];
            }
        }
        ans[length - 1] = arr[i] + arr[j];
        return ans;
    }

    public static void main(String[] args) {
        int[] a = {10, 20, 30, 40, 50};
        System.out.println(lessMoneySplitGold(a));

        int maxLength = 6;
        int maxValue = 1000;
        int testTimes = 100000;
        for (int i = 0; i < testTimes; i++) {
            int[] arr = generateRandomArray(maxLength, maxValue);
            if (lessMoneySplitGold(arr) != lessMoneySplitGold1(arr)) {
                System.out.println("Error");
                break;
            }
        }
        System.out.println("Finish");
    }

    // ------------------------------- 辅助测试的方法 ---------------------------------

    public static int[] generateRandomArray(int maxLength, int maxValue) {
        int[] ans = new int[(int) ((maxLength + 1) * Math.random())];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = (int) ((maxValue + 1) * Math.random());
        }
        return ans;
    }

}