public class LeetCode042_numIslands {
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    void dfs(char[][] grid, int x, int y) {
        int m = grid.length;
        int n = grid[0].length;
        if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] != '1') {
            return;
        }
        grid[x][y] = '0';
        for (int[] d : dirs) {
            dfs(grid, x + d[0], y + d[1]);
        }
    }
    void dfs1(char[][] grid,int x,int y){
        int m= grid.length;
        int n= grid[0].length;
        if(x <0 || x>= m || y<0 || y>= n || grid[x][y] !='1'){
            return;
        }
        grid[x][y]='0';
        for(int[]d :dirs){
            dfs( grid, x+ d[0],y+ d[1]);
        }
    }

}
