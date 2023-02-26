package 算法课程实践.有序表与并查集;

public class 位运算实现加减乘除 {

    //可读性强
    public static int add(int a, int b){
        int noCarryAddRes = a ^ b;
        int carryInfo = (a & b) << 1;
        int temp = 0;
        while(carryInfo != 0){
            temp = noCarryAddRes ^ carryInfo;
            carryInfo = (noCarryAddRes & carryInfo) << 1;
            noCarryAddRes = temp;
        }

        return noCarryAddRes;
    }

    //精简版
    public static int add_1(int a, int b){
        int sum = a;
        while(b != 0){
            sum = a ^ b;
            b = (a & b) << 1;
            a = sum;
        }
        return sum;
    }

    /**
     * 求相反数,取反加一
     */
    public static int negNum(int a){
        return add(~a, 1);
    }

    public static int sub(int a, int b){
        return add(a, negNum(b));
    }

    public static int multiply(int a, int b){
        //依次取出b的每一位，根据此位偏移对a进行移位累加
        //本质上是累加b的每一个二进制位与a的乘积
        int res = 0;
        int curOffset = 0;
        int curBitValue = 0;

        while(b != 0){
            curBitValue = b & 1;
            if(curBitValue != 0){
                res = add(res, (a << curOffset));
            }
            b = b >>> 1;
            curOffset++;
        }
        return res;
    }

    public static int multiply_1(int a, int b){
        int res = 0;
        while(b != 0){

            if((b & 1) == 1){
                res = add(res, a);
            }
            a <<= 1;
            b >>>= 1;//无符号右移

        }
        return res;
    }

    public static int div(int a, int b){
        int x = a < 0 ? negNum(a) : a;
        int y = b < 0 ? negNum(b) : b;

        int res = 0;

        for(int i = 30; i >= 0 && x >= y; i--){
            //x右移多少位才是尽可能接近y(右到左首次大于y),此时y左移这么多位也是刚好小于x
            if((x >> i) >= y){
                res = add(res, (1 << i));//x里有多少个y（count是2的整数次方）
                x = sub(x, (y << i));
            }
        }

        return (a < 0 && b > 0) || (a > 0 && b < 0) ? negNum(res) : res;
    }

    public static int divide(int a, int b){
        if(b == Integer.MIN_VALUE ){
            return a == Integer.MIN_VALUE ? 1 : 0;
        }
        if(a == Integer.MIN_VALUE) {
            int flag = b < 0 ? -1 : 1;
            int res_1 = div(add(a, multiply(flag, b)), b);
            int res_2 = div(multiply(-flag, b), b);
            return  res_1 == Integer.MAX_VALUE ? res_1 : res_2 + res_1;
        }
        return div(a, b);
    }

    public static void main(String[] args) {
//        System.out.println(add(55 , 1));
//        System.out.println(sub(55,1));
//        System.out.println(multiply(20, -4));
//        System.out.println(multiply_1(20, -4));
        System.out.println(divide(-2147483648, -2147483648));
    }
}
