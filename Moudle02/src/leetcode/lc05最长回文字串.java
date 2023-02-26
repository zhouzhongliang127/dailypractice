package leetcode;

public class lc05最长回文字串 {


    public static char[] manacherString(String s){
        char[] charArr = s.toCharArray();
        char[] res = new char[charArr.length * 2 + 1];
        int index = 0;
        for (int i = 0; i < res.length; i++) {
            res[i] = (i & 1) == 0 ? '#' : charArr[index++];
        }
        return res;
    }

    public static String longestPalindrome(String s){
        if(s == null || s.length() == 0) return null;

        char[] str = manacherString(s);
        int[] pArr = new int[str.length];//回文半径数组

        //最右侧回文边界(开区间）和对应的中心下标
        int C = -1;
        int R = -1;

        int maxRadius = Integer.MIN_VALUE;
        int maxCenter = -1;

        for (int i = 0; i < str.length; i++) {
            //先确定i位置至少的回文区域
            pArr[i] = R > i ? Math.min(pArr[C * 2 - i], R - i) : 1;

            //进一步确认是否可以扩张，先检测待比较位置是否越界
            while(i + pArr[i] < str.length && i - pArr[i] > - 1){
                if(str[i + pArr[i]] == str[i - pArr[i]]){
                    pArr[i]++;
                }else{
                    break;
                }
            }

            //如果此时以i为中心的回文区域右侧大于之前的，更新
            if(i + pArr[i] > R){
                R = i + pArr[i];
                C = i;
            }
            if(pArr[i] > maxRadius){
                maxRadius = pArr[i];
                maxCenter = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = maxCenter - pArr[maxCenter] + 1; i < maxCenter + pArr[maxCenter] - 1; i++){
            if((i & 1) != 0){
                sb.append(str[i]);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }

}
