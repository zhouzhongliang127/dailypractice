package 算法课程实践.排序;

/**
 * @author zzl
 * @Description
 * @date 2022/4/15 - 11:28
 */
public class QuickSort {
    private static void swap(int[] arr, int minIndex, int i) {
        int temp = arr[minIndex];
        arr[minIndex] = arr[i];
        arr[i] = temp;
    }

    private static void quickSort(int[] arr, int left, int right){
        if(left >= right) {
            return;
        }

        int[] p = partition(arr, left, right);
        quickSort(arr, left, p[0] - 1);// < 区域
        quickSort(arr, p[1] + 1, right);// > 区域
    }

    private static int[] partition(int[] arr, int left, int right){
        //随机确定一个数放用作划分
        int randomIndex = left + (int) (Math.random() * (right - left + 1));
        // 保存该数并换到左边第一个(不换只保存这个值好像也行，但是将该值放在固定的位置可以省一个变量)
        // 选择可读性则用新变量存储，节省空间则将这个用于划分的值放在头或者尾
        int temp = arr[randomIndex];//以temp做划分
//        swap(arr, left, randomIndex);

        //做好随机化处理之后回归荷兰国旗问题
        int less = left - 1;
        int more = right + 1;//大小区间边界
        int i = left;
        while(i < more){
            if(arr[i] == temp){//等于的情况比较少，熟练之后应当将等于的逻辑放到最后
                i++;
            }else if(arr[i] < temp){
                swap(arr, less + 1, i);
                less++;
                i++;
            }else {
                swap(arr, more - 1,i);
                more--;
            }
        }
        return new int[]{less + 1, more - 1};//实际的等于区间是less+1到more-1
    }
    public static void main(String[] args) {
        int[] nums = new int[]{-29,-10,20,32,56,34,23,21,78,87,43};
        //排序传下标时及得length—1
        quickSort(nums,0,nums.length - 1);
        for (int num : nums) {
            System.out.print(" " + num);
        }
    }
}
