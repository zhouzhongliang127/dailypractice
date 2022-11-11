package leetcode;

/**
 * @author zzl
 * @Description
 * @date 2021/11/7 - 19:41
 */
public class Sort {

    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void heapInsert(int[] arr,int index){
        while (arr[(index-1)/2] < arr[index]){
            swap(arr,index,(index-1)/2);
            index = (index-1)/2;
        }
    }
    public static void heapify(int[] arr,int index,int heapSize){
        int left = index * 2 + 1;
        //堆的范围为0~heapSize-1
        while (left < heapSize){
            //这里要考虑右孩子不存在的情况，即只当有孩子存在同时右孩子大于左孩子才取右孩子，
            // 若右孩子不存在，则由前条件截断，不进行后面大小比较
            int maxIndex = left + 1 < heapSize && arr[left] < arr[left + 1] ? left + 1 : left;
            maxIndex = arr[index] > arr[maxIndex] ? index : maxIndex;
            if(maxIndex == index) break;
            //孩子大，指针下移，并更新左孩子
            swap(arr,index, maxIndex);
            index = maxIndex;
            left = 2 * index + 1;
        }
    }
    public static void heapSort(int[] arr){
        if(arr.length == 0 || arr.length < 2) {
            return;
        }
        //先构建堆
        for (int i = 0; i < arr.length;i++ ) {
            heapInsert(arr,i);
        }
        int heapSize = arr.length;
        //逐步将堆顶元素与堆的最后一个元素交换
        while(heapSize > 0){
            swap(arr,0,heapSize-1);
            --heapSize;
            heapify(arr,0,heapSize);
        }
    }
    public static void quickSort(int[] arr,int left,int right){
        if(left >= right){
            return;
        }
        int pivot = partition(arr,left,right);
        quickSort(arr,left,pivot - 1);
        quickSort(arr,pivot + 1,right);
    }
    public static int partition(int[] arr, int left, int right){
        //区间上随机取一个数来进行划分
        //固定写法，取a到b之间的额一个随机数 = a + random() * (b - a + 1)
        int randomIndex = left + (int)(Math.random()*(right - left + 1));
        //将取出来的数放在最左侧并保存，放在左侧是因为从右侧查起，会先覆盖左侧
        int temp = arr[randomIndex];
        swap(arr,left,randomIndex);
        int low = left;
        int high = right;
        while(low < high){
            //从右边找到第一个小于temp的数，所以只要arr[high]>=temp右侧指针就左移
            while(low < high && arr[high] >= temp){
                --high;
            }
            //
            arr[low] = arr[high];
            while(low < high && arr[low] <= temp){
                ++low;
            }
            arr[high] = arr[low];
        }
        arr[low] = temp;
        return low;
    }
    public static void mergeSort(int[] arr,int left,int right){
        if(left == right) return;
        int mid = left +((right - left) >> 1);
        mergeSort(arr,left,mid);
        mergeSort(arr,mid+1,right);
        merge(arr,left,mid,right);

    }
    public static void merge(int[] arr,int left, int mid, int right){
        int[] help = new int[right -left +1];
        int i = left;
        int j = mid + 1;
        int index = 0;
        while(i <= mid && j <= right){
            help[index++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }
        while(i <= mid){
            help[index++] = arr[i++];
        }
        while(j <= right){
            help[index++] = arr[j++];
        }
        for (int num : help) {
            arr[left++] = num;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-29,-10,20,32,56,34,23,21,78,87,43};
        //排序传下标时及得length—1
//        mergeSort(nums,0,nums.length-1);
//        quickSort(nums,0,nums.length-1);
        heapSort(nums);
        for (int num : nums) {
            System.out.print(" " + num);
        }
    }
}
