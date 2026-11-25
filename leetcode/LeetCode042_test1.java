import java.util.*;

public class LeetCode042_test1 {
    static class Point {
        int x,y;
        Point(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    static class lightOff{
        //重点
        static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
         static int[][] bfs(int[][] matrix, Point starter){

            int n=matrix.length;
            int m= matrix[0].length;
            int[][] mat=new int[n][m];
            for(int i=0;i<n;i++){
                Arrays.fill(mat[i],-1);
            }
            Queue<Point> queue= new LinkedList<>();
            queue.offer(starter);
            mat[starter.x][starter.y]=0;
            while(!queue.isEmpty()){
                Point cur=queue.poll();
                //for(int[] t:mat){
                //用方向数组遍历
                for(int[] t:dirs){
                    int nx=cur.x+t[0];
                    int ny=cur.y+t[1];
                    if(nx<0 || nx>=n||ny<0||ny>=m)
                    //if(nx<0 || nx>=n||ny<0||ny>m)
                        continue;
                    if(matrix[nx][ny]==1)
                        continue;
                    if(mat[nx][ny]!=-1)
                        continue;
                    mat[nx][ny]=mat[cur.x][cur.y]+1;
                    queue.offer(new Point(nx,ny));
                }
            }
            return mat;
        }
        int[][] buildDisMatrix(int [][] matrix){
            int n=matrix.length;
            int m=matrix[0].length;
            Point start =null;
            Point exit = null;
            List<Point> lights = new ArrayList<>();

            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(matrix[i][j]==3){
                        start = new Point(i,j);
                    } else if (matrix[i][j]==4){
                        exit = new Point(i,j);
                    } else if (matrix[i][j] ==2){
                        lights.add(new Point(i,j));
                    }
                }
            }
            List<Point> points =new ArrayList<>();
            points.add(start);
            points.add(exit);
            points.addAll(lights);
            int k = points.size();
            int [][] disMatrix=new int[k][k];

            for(int i=0; i<k; i++){
                int[][] disI= bfs(matrix,points.get(i));
                for(int j=0;j<k;j++){
                    Point pj=points.get(j);
                    int d = disI[pj.x][pj.y];
                    if(d ==-1){
                        disMatrix[i][j]=Integer.MAX_VALUE/2;
                    } else {
                        disMatrix[i][j]=d;
                    }
                }

            }
            return disMatrix;
        }
        int solveDP(int[][] disMatrix,int m,int timeLimit){
            int[][] dp = new int[1 << m][m];

            for (int i = 0; i < (1 << m); i++) {
                Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
            }

            for (int i = 0; i < m; i++) {
                int d = disMatrix[0][i + 2];
                if (d < Integer.MAX_VALUE / 2) {
                    dp[1 << i][i] = d;
                }
            }
            // 状态转移
            for (int mask = 0; mask < (1 << m); mask++) {
                for (int i = 0; i < m; i++) {
                    if ((mask & (1 << i)) == 0) continue;  // i 不在 mask 中，跳过
                    if (dp[mask][i] >= Integer.MAX_VALUE / 2) continue;  // 不可达

                    // 尝试去关下一盏灯 j
                    for (int j = 0; j < m; j++) {
                        if ((mask & (1 << j)) != 0) continue;  // j 已经关过了

                        int newMask = mask | (1 << j);
                        int cost = dp[mask][i] + disMatrix[i + 2][j + 2];
                        if (cost < dp[newMask][j]) {
                            dp[newMask][j] = cost;
                        }
                    }
                }
            }
            // 统计答案：对每个 mask，检查能否在时限内到门口
            int maxLights = 0;
            for (int mask = 0; mask < (1 << m); mask++) {
                int lightCount = Integer.bitCount(mask);
                if (lightCount <= maxLights) continue;  // 已经不可能更优

                for (int i = 0; i < m; i++) {
                    if ((mask & (1 << i)) == 0) continue;
                    if (dp[mask][i] >= Integer.MAX_VALUE / 2) continue;

                    int total = dp[mask][i] + disMatrix[i + 2][1];
                    if (total <= timeLimit) {
                        maxLights = lightCount;
                        break;
                    }
                }
            }


            return maxLights;

        }


        }

    }



}
