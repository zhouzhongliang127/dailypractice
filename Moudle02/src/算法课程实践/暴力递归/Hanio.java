package 算法课程实践.暴力递归;

/**
 * @author zzl
 * @Description
 * @date 2022/9/13 - 14:15
 */
public class Hanio {

    public static void hanio(int n, String from, String to, String other){
        if(n == 1){
            System.out.println(from + " --->" + to);
            return;
        }
        hanio(n-1, from, other, to);
        System.out.println(from + " --->" + to);
        hanio(n-1, other, to, from);
    }

    public static void main(String[] args) {
        hanio(4,"左", "右", "中");
    }
}
