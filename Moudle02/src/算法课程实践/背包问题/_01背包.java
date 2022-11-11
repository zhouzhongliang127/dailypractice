package 算法课程实践.背包问题;

/**
 * @author zzl
 * @Description
 * @date 2022/9/15 - 11:29
 */
public class _01背包 {


    public static int process01(int[] weight, int i, int[] values, int capacity){
        if(i == weight.length){
            return 0;
        }
        int res = 0;
        //返回放i元素和不放i元素中大的那个就行
        if(weight[i] <= capacity){
            res += values[i] + process01(weight, i + 1, values, capacity - weight[i]);
        }
        return Math.max(res,process01(weight, i + 1, values, capacity));
    }

    public static void main(String[] args) {
//        int[] values = {6, 3, 5, 4, 6};
//        int[] weight = {2, 2, 6, 5, 4};
//        System.out.println(process01(weight, 0 , values, 10));
    }
}
