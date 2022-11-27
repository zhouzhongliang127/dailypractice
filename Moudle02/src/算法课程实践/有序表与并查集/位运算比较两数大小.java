package 算法课程实践.有序表与并查集;

public class 位运算比较两数大小 {


    /**
     * 获取一个int型整数的符号
     * @param a
     * @return 1-代表为正 0-负
     */
    public static int sign(int a){
        //这里与1主要是因为在其他语言中可能有带符号右移
        return ((a >> 31) & 1) ^ 1;
    }

    public static int compare(int a, int b){

        int c = a - b;//这里可能溢出，所以不能单纯看c的符号

        int sa = sign(a);
        int sb = sign(b);
        int sc = sign(c);

        //记录ab符号是否相同
        int dif = sa ^ sb;
        int same = dif ^ 1;

        //如果ab符号不同，a符号为1代表a>0,b<0,此时返回a,或者 ab符号相同，此时不会溢出，直接根据差的符号决定是否返回a
        int ReturnA =  dif & sa + same & sc;
        int ReturnB = ReturnA ^ 1;

        return a * ReturnA + b * ReturnB;

    }

    public static void main(String[] args) {
        int a = -1;
        int b = 20;

        System.out.println(compare(a, b));

    }
}
