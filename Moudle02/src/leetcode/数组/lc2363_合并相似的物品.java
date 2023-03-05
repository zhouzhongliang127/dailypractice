package leetcode.数组;

import java.util.*;

public class lc2363_合并相似的物品 {

    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {

        Arrays.sort(items1, (a, b) -> a[0] - b[0] );
        Arrays.sort(items2, (a, b) -> a[0] - b[0] );

        List<List<Integer>> lists = new ArrayList<>();
        int index = 0;

        int i = 0, j = 0;
        while(i < items1.length && j < items2.length){
            int sum = 0;
            int curVal = Math.min(items1[i][0], items2[j][0]);
            while(i < items1.length && items1[i][0] == curVal) sum += items1[i++][1] ;
            while(j < items2.length && items2[j][0] == curVal) sum += items2[j++][1];
            List<Integer> list = new ArrayList<>();
            list.add(curVal);
            list.add(sum);
            lists.add(list);
        }


        if(j < items2.length){
            i = j;
            items1 = items2;
        }
        while(i < items1.length){
            int sum = 0;
            int curVal = items1[i][0];
            while(i < items1.length && items1[i][0] == curVal) sum += items1[i++][1];
            List<Integer> list = new ArrayList<>();
            list.add(curVal);
            list.add(sum);
            lists.add(list);
        }

        return lists;
    }
}
