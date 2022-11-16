package leetcode.有序表与并查集;

public class 最大岛屿面积 {
    int maxArea = 0;
    int curArea = 0;
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;//行
        int m = grid[0].length;//列

        for(int i = 0; i < n; i++){
            for (int j = 0; j < m; j++) {
                if(grid[i][j] == 1){
                    curArea = 0;
                    infect(grid, i, j, n, m);
                    maxArea = Math.max(maxArea, curArea);
                }
            }
        }

        return maxArea;
    }

    private void infect(int[][] grid, int i, int j, int n, int m) {
        if(i < 0 || i >= n || j < 0 || j >= m || grid[i][j] != 1){
            return;
        }
        grid[i][j] = 2;
        //再感染的过程中记录1的数量，每次加一之后与最大面积相比较(也可以等当前岛屿面积统计玩再比较）
        curArea++;
        //maxArea = Math.max(maxArea, curArea);
        infect(grid, i - 1, j, n, m);
        infect(grid, i + 1, j, n, m);
        infect(grid, i, j - 1, n, m);
        infect(grid, i, j + 1, n, m);
    }
}
