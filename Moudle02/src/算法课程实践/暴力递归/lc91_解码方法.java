package 算法课程实践.暴力递归;

/**
 * @author zzl
 * @Description
 * @date 2022/9/14 - 15:21
 */
public class lc91_解码方法 {

    /*
    一条包含字母 A-Z 的消息通过以下映射进行了编码 ：

    'A' -> "1"
    'B' -> "2"
        ...
    'Z' -> "26"
    要解码已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为：

    "AAJF" ，将消息分组为 (1 1 10 6)
    "KJF" ，将消息分组为 (11 10 6)

     */
    public static int process(char[] chs, int i, StringBuilder s){
        if(i == chs.length){
            System.out.println(s);
            return 1;
        }

        if(chs[i] == '0'){//当前位置为0，无法解析成任何字母，不可与后面组合，古可能的结果数为0
            return 0;
        }

        int res = 0;//当前位置数字选择不同解析方法下各自结果数的统计

        //下面三种情况只会命中一种，res会统计该数字下解的数量

        if(chs[i] == '1'){
            //单独解析，去决定 i + 1 位置上数字如何解析
            //选择单独解析，那么这种情况下解码数量就是其i+1为首子串解码数量
            res += process(chs, i + 1, s.append((char)(64 + (chs[i] - 48))));//如果选择独立解析，剩余子串的解码方式数量
            s.delete(s.length() - 1,s.length());

            //与后一个值合并解析，在去决定 i + 2 位置上的该如何解析
            if(i + 1 < chs.length){
                //选择合并解析，这种情况下剩余子串的解码方式数量
                res += process(chs, i + 2, s.append((char) (64 + (chs[i] - 48) * 10 + (chs[i + 1] - 48))));//记录解析结果传下去
                s.delete(s.length() - 1,s.length());
            }
        }


        if(chs[i] == '2'){
            //单独
            res += process(chs, i + 1, s.append((char)(64 + (chs[i] - 48))));
            s.delete(s.length() - 1,s.length());
            if(i + 1 < chs.length && chs[i] >= '0' && chs[i] <= '6'){
                res += process(chs, i + 2, s.append((char) (64 + (chs[i] - 48) * 10 + (chs[i + 1] - 48))));
                s.delete(s.length() - 1,s.length());
            }
        }

        if(chs[i] >= '3') {
            res += process(chs, i + 1,s.append((char)(64 + (chs[i] - 48))));
            s.delete(s.length() - 1,s.length());
        }
        return res;
    }

    public static void main(String[] args) {
        String str = "111111111111111111111111111111111111111111111";
        char[] chs = str.toCharArray();
        System.out.println(process(chs, 0 , new StringBuilder()));
        System.out.println('a' + 1);
    }
}
