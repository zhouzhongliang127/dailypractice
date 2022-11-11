package practice;

public class BubbleSort {


    public static void main(String[] args) {

        int[] nums = new int[]{34, 32, 67, 23, 65, 78, 31, 12};
        int temp ;
        //大数沉底，逐步构建有序
        for (int i = 0; i < nums.length - 1; i++) {
            System.out.print("第" + (i+1) + "轮:");
            for (int j =  1; j < nums.length - i; j++) {

                if (nums[j] < nums[j - 1]) {
                    temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                }
            }
            for (int num : nums) {
                System.out.print(num + " ");

            }
            System.out.println();

        }


    }
}
