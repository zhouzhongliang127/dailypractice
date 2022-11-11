package 算法课程实践.暴力递归;

/**
 * @author zzl
 * @Description
 * @date 2022/9/13 - 17:20
 */
public class 字符串的全部子串 {

    public static void process(char[] chs, int i, StringBuilder s){
        if(i == chs.length){
            System.out.println(s.toString());
            return;
        }

        process(chs, i+1,s.append(chs[i]));
        s.delete(s.length() - 1,s.length());
        process(chs, i+1, s);
    }

    public static void main(String[] args) {

        process("abdas".toCharArray(),0,new StringBuilder());
    }
}
