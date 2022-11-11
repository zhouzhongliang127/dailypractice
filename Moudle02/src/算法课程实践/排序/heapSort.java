package 算法课程实践.排序;

import java.util.PriorityQueue;

/**
 * @author zzl
 * @Description
 * @date 2022/4/22 - 11:25
 */
public class heapSort {

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void heapInsert(int[] arr, int index){
        //当当前节点值大于父节点则交换
        while(arr[index] > arr[(index - 1) / 2]){//直到当前节点值不大于父节点时停止（堆顶的父节点是自己）
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;//继续向上找
        }
    }

    public static void heapify(int[] arr, int index, int heapSize){
        int left = index * 2 + 1;
        while(left < heapSize){//还有孩子（heapSize-1才是堆最后一个的下标）

            //将孩子中较大者与父亲交换（找出三者中最大值的下标）
            int maxIndex = left + 1 < heapSize && arr[left] < arr[left + 1] ? left + 1: left;
            maxIndex = arr[index] >= arr[maxIndex] ? index : maxIndex;

            if(maxIndex == index){
                break;
            }
            swap(arr, index, maxIndex);
            index = maxIndex;
            left = index * 2 + 1;
        }
    }

    public static void heapSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }

        //构建一个堆
//        for (int i = 1; i < arr.length; i++) {//初级方法，依次插入构建 - O(NlogN)
//            heapInsert(arr, i);
//        }
        for(int i = arr.length / 2 - 1; i >= 0; i--){//进阶，从最后一个非叶子节点向前使用堆化来构建 - O(N)
            heapify(arr, i, arr.length);
        }

        int heapSize = arr.length;
        //堆顶元素与最后一个元素交换，看做弹出,同时heapSize-1缩小堆的范围
        swap(arr, 0, --heapSize);
        while(heapSize > 0){
            heapify(arr, 0, heapSize);//swap也可以防放在循环里面，理解为先把堆中最大的换出去再对剩下的进行堆化
            swap(arr,0, --heapSize);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-29,-10,20,32,56,34,23,21,78,87,43};
        //排序传下标时及得length—1
        heapSort(nums);
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int num : nums) {
            System.out.print(" " + num);
        }
    }
    public void sortedArrDistanceLessK(int[] arr, int k) {
        // 默认小根堆
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int index = 0;
        for(; index <= Math.min(arr.length - 1,k); index++){
            heap.add(arr[index]);
        }
        int i = 0;
        for(; index < arr.length; index++){
            arr[i++] = heap.poll();
            heap.add(arr[index]);
        }
        while(!heap.isEmpty()){
            arr[i++] = heap.poll();
        }
    }

}
