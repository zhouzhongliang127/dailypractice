package leetcode;


import org.junit.Test;

/**
 * @author zzl
 * @Description
 * @date 2021/10/9 - 23:17
 */
public class Jump_Game_II {
    public int jump(int[] nums) {
        int start = 0;
        int ans = 0;
        int end = 0;

        while (end < nums.length-1)
        {
            int maxPos = 0;
            for (int i = start ; i <= end; i++) {
                maxPos = Math.max(maxPos,nums[i] + i);
            }
            start = end+1;
            end = maxPos;
            ans++;
        }
        return ans;
    }

    @Test
    public void test1() {
        int[] nums = new int[]{2,3,1,1,4};
        System.out.println(jump(nums));
    }


}
