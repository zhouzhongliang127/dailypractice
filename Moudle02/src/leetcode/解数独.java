package leetcode;

/**
 * @author zzl
 * @Description
 * @date 2022/9/26 - 10:56
 */
public class 解数独 {

    public static void solveSudoku(char[][] board) {
        int[][] rowVisited = new int[9][10];
        int[][] colVisited = new int[9][10];
        int[][] bxoVisited = new int[9][10];

        backtracking(board,0,0,rowVisited,colVisited,bxoVisited);
        for(char[] c : board){
            for (char c1 : c) {
                System.out.print(c1 + " ");
            }
            System.out.println();
        }
    }

    static boolean backtracking(char[][] board, int row, int col, int[][] rowVisited, int[][] colVisited, int[][] bxoVisited){

        if(row > 8){
            return true;
        }
        int newRow = row;//这里必须初始化，不然要是后面不进下面if则没有值
        int newCol;
        if(col + 1 > 8){
            newRow = row + 1;
            newCol = 0;
        }else {
            newCol = col + 1;
        }

        int boxIndex = (row / 3) * 3 + col / 3;

        //当遇到棋盘原有的数字时，我一开始的思路是在对应行列将该数字置为已访问就直接下一个位置，但是后来发现前面填充的数字可能和棋盘原有数字冲突，这时如果直接刚刚那样
        //处理，那么就会造成重复，于是对于旗棋盘上的数字也开始了判断，如果发现前面有冲突就返回，没有冲突就置为以访问，我这时还是认为棋盘上的数字在回溯的时候存在标志不需要清除
        //这时又出错了，如果在将棋盘原有数字置为以访问之后不清除，后续再次来到该棋盘数字位置，就会触发之前我为了避免棋盘数字与前面填入数字冲突的逻辑，由于之前从棋盘数字回溯回去
        //没有重置访问标志，回溯后再次来到这个位置进行检查是否重复的时候就会命中，
        if(board[row][col] != '.'){
            int curNum = board[row][col] - '0';
            //棋盘原有数字与之前填入的冲突，返回false
            if(rowVisited[row][curNum] == 1 || colVisited[col][curNum] == 1 || bxoVisited[boxIndex][curNum] == 1) {
                return false;
            }
            rowVisited[row][curNum] = 1;
            colVisited[col][curNum] = 1;
            bxoVisited[boxIndex][curNum] = 1;
            //这里因为当前数字是棋盘原有的数字，所以回溯回来之后不需要继续状态清除，正好避免回溯回去之后的重复选择
            boolean flag =  backtracking(board,newRow,newCol,rowVisited,colVisited,bxoVisited);
            rowVisited[row][curNum] = 0;
            colVisited[col][curNum] = 0;
            bxoVisited[boxIndex][curNum] = 0;
            return flag;
        }


        for(int i = 1; i <= 9; i++){

            if(rowVisited[row][i] == 0 && colVisited[col][i] == 0 && bxoVisited[boxIndex][i] == 0){
                rowVisited[row][i] = 1;
                colVisited[col][i] = 1;
                bxoVisited[boxIndex][i] = 1;
                board[row][col] = (char)(i + '0');

                boolean flag = backtracking(board,newRow,newCol,rowVisited,colVisited,bxoVisited);
                if(flag){
                    return true;
                }
                rowVisited[row][i] = 0;
                colVisited[col][i] = 0;
                bxoVisited[boxIndex][i] = 0;
                board[row][col] = '.';
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
                };

        solveSudoku(board);


    }
}
