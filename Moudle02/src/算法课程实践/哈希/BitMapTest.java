package 算法课程实践.哈希;

/**
 * @author zzl
 * @Description
 * @date 2022/11/7 - 10:54
 */
public class BitMapTest {

    public static void main(String[] args) {

        int a = 0;

        //位图可以用其他类型进行表述，本质上就是一个个二进制位

        int[] bitmap = new int[10];//320个二进制位

        int i = 178;//假如要获取178号二进制位

        int index = 178 / 32;//定位到二进制位所在数组元素下标

        int offset = 178 % 32;//二进制位在元素内偏移

        //取该位置上的状态(右移是因为bit存储是地位到高位，实际上bitmap[i]的32位从左只有一次是31 ~ 0 号位置）
        int s = (bitmap[index] >> (offset - 1) & 1);

        //将178位上的状态改为1(左右移offset-1是因为offset指示的是二进制位处于从右往左第几个位置)
        bitmap[index] = bitmap[index] | (1 << (offset - 1));

        //改为0
        bitmap[index] = bitmap[index] & ( ~ (1 << (offset - 1)));

        int bit = bitmap[(i / 32)] >> (i % 32 - 1);

        System.out.println(bit);
    }
}
