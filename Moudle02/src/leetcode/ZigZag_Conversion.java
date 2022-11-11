package leetcode;

/**
 * @author zzl
 * @Description
 * @date 2021/10/27 - 18:51
 */
public class ZigZag_Conversion {
    public static String convert(String s, int numRows) {
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < sb.length; i++) {
            sb[i] = new StringBuilder();
        }
        int index = 0;
        int flag = -1;
        int count = 0;
        while(index < s.length()){
            sb[count].append(s.charAt(index++));
            if(count == 0||count==numRows-1) flag = -flag;
            count += flag;
        }
        for(int i =1;i<numRows;i++){
            sb[0].append(sb[i].toString());
        }
        return sb[0].toString();



//        int n = s.length();
//        int cols = (numRows-1)*n/(2*numRows-2);
//        System.out.println(cols);
//        if((n%(2*numRows-2))!=0) cols++;
//        System.out.println(cols);
//        char[][] chars = new char[numRows][cols];
//        int index=0;
//        int row = 0,col = 0;
//        while(index < n){
//            while(row<numRows&&index < n){
//                System.out.println(row+","+col+"index="+index+"li");
//                chars[row++][col]=s.charAt(index++);
//
//            }
//            row--;
//            while(row>1&&index < n){
//                chars[--row][++col] = s.charAt(index++);
//                System.out.println(row+","+col+"index="+(index-1));
//            }
//            col++;
//            row--;
//        }
//        StringBuilder s1 = new StringBuilder();
//        for(int i =0;i < numRows;i++){
//            for(int j=0;j<cols;j++){
//                if(chars[i][j]!=0)
//                    s1.append(chars[i][j]);
//            }
//        }
//        return s1.toString();
    }

    public static void main(String[] args) {
//        s = "PAYPALISHIRING", numRows = 3
        String s = "PAYPALISHIRING";
        int numRows = 4;
        System.out.println(s.length());
        System.out.println(convert(s,numRows));
    }
}
