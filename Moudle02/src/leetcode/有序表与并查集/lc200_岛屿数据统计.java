package leetcode.有序表与并查集;

public class lc200_岛屿数据统计 {

    public static int numIsland(char[][] grid){
        int n = grid.length;//行
        int m = grid[0].length;//列
        int count = 0;
        for(int i = 0; i < n; i++){
            for (int j = 0; j < m; j++) {
                if(grid[i][j] == '1'){
                    infect(grid, i, j, n, m);
                    count++;
                }
            }
        }
        return count;
    }

    private static void infect(char[][] grid, int i, int j, int n, int m) {
        if(i < 0 || i >= n || j < 0 || j >= m || grid[i][j] != '1'){
            return;
        }
        grid[i][j] = '2';
        infect(grid, i - 1, j, n, m);
        infect(grid, i + 1, j, n, m);
        infect(grid, i, j - 1, n, m);
        infect(grid, i, j + 1, n, m);
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };

        System.out.println(numIsland(grid));
    }
}
