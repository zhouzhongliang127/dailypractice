package 算法课程实践.排序;

/**
 * @author zzl
 * @Description
 * @date 2022/4/4 - 16:11
 */
public class PrintOddNums {
    public static int[] singleNumbers(int[] nums) {
        int eor = 0;
        //计算a ^ b
        for (int num : nums) {
            eor ^= num;
        }

        int rightOne = eor & (~eor + 1);//取出最右侧的1

        //假设ab中该位置为1的数为a
        int a = 0;
        //将数组中这个位置为1的数异或起来
        for (int num : nums) {
            //只有当该位置上的数为一时才参与异或,只有当该位置上为1时才不等于0
            //注意，这个&的结果不能用==1判断，结果为某个数，只要不是0就可以说明满足条件了
            if((num & rightOne) != 0){
                a ^= num;
            }
        }

        return new int[]{a, eor ^ a};
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,5,2};
        int[] result = singleNumbers(arr);
        for (int i : result) {
            System.out.println("i = " + i);
        }
    }
}
