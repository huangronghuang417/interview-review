public class LeetCode043_islandNum {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }

    public boolean exist1(char[][] board, String word){
        int m= board.length,n=board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(dfs(board,word,i,j,0)) return true;
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, String word, int i, int j, int idx) {
        if (idx == word.length()) return true;
        int m = board.length, n = board[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n) return false;
        if (board[i][j] != word.charAt(idx)) return false;

        // 标记访问
        char tmp = board[i][j];
        board[i][j] = '#';

        boolean found = dfs(board, word, i + 1, j, idx + 1)
                || dfs(board, word, i - 1, j, idx + 1)
                || dfs(board, word, i, j + 1, idx + 1)
                || dfs(board, word, i, j - 1, idx + 1);

        // 回溯还原
        board[i][j] = tmp;
        return found;
    }

    private boolean dfs1(char[][] board ,String word , int i,int j, int idx){
        if(idx == word.length()) return true;
        int m = board.length, n=board[0].length;
        if(i<0 ||i>=m || j<0 || j>=n) return false;
        if(board[i][j] != word.charAt(idx)) return false;

        char tmp = board[i][j];
        board[i][j]= '#';
        boolean found = dfs(board,word,i+1,j,idx+1)
                || dfs(board, word, i - 1, j, idx + 1)
                || dfs(board, word, i, j + 1, idx + 1)
                || dfs(board, word, i, j - 1, idx + 1);

        board[i][j]=tmp;
        return found;
    }

}
