package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class dfs2583 {
    static int m, n, k;
    static boolean[][] board;
    static boolean[][] visited;

    static int[] dx={0, 1, 0, -1};
    static int[] dy={-1, 0, 1, 0};

    static int count;
    static List<Integer> nums;

    static void DFS(int x, int y){
        visited[x][y]=true;
        count++;

        for(int i=0; i<4; i++){
            int nowX=x+dx[i];
            int nowY=y+dy[i];

            if(nowX >= 0 && nowY >= 0 && nowX < n && nowY < m){
                if(!visited[nowX][nowY] && !board[nowX][nowY]){
                    DFS(nowX, nowY);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());

        board=new boolean[n][m];
        visited=new boolean[n][m];
        nums=new ArrayList<>();
        count=0;

        for(int i=0; i<k; i++){
            st=new StringTokenizer(br.readLine());
            int lx=Integer.parseInt(st.nextToken());
            int ly=Integer.parseInt(st.nextToken());
            int rx=Integer.parseInt(st.nextToken());
            int ry=Integer.parseInt(st.nextToken());

            for(int j=lx; j<rx; j++){
                for(int l=ly; l<ry; l++){
                    board[l][j]=true;
                }
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!visited[i][j] && !board[i][j]){
                    DFS(i, j);
                    nums.add(count);
                    count=0;
                }
            }
        }

        Collections.sort(nums);
        System.out.println(nums.size());
        for(Integer num: nums) System.out.print(num+" ");
    }
}
