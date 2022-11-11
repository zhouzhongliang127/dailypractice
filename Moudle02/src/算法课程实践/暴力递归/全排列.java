package 算法课程实践.暴力递归;

/**
 * @author zzl
 * @Description
 * @date 2022/9/13 - 17:45
 */
public class 全排列 {
    //依次确定第n个位置上的字符，确定好之后去确定下一个字符
    public static void process(char[] chs, int[] visited, int n, StringBuilder s){
        if(n == chs.length){
            System.out.println(s.toString());
        }
        for(int i =0;i < chs.length;i++){
            if(visited[i] == 0){
                visited[i] = 1;
                process(chs, visited, n + 1, s.append(chs[i]));
                visited[i] = 0;
                s.delete(s.length() - 1,s.length());
            }
        }
    }

    public static void main(String[] args) {
//        char[] chs = "abcd".toCharArray();
//        process(chs, new int[chs.length], 0, new StringBuilder());


    }
}
