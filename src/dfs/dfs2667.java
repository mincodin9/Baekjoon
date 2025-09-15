package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class dfs2667 {
    static int n;
    static int[][] board;
    static int[][] visited;

    static int[] dx={0, 1, 0, -1};
    static int[] dy={-1, 0, 1, 0};

    static int count;
    static List<Integer> nums=new ArrayList<>();

    static void DFS(int x, int y){
        visited[x][y]=1;
        count++;

        for(int i=0; i<4; i++){
            int nowX=x+dx[i];
            int nowY=y+dy[i];

            if(nowX >= 0 && nowY >= 0 && nowX < n && nowY < n){
                if(visited[nowX][nowY]==0 && board[nowX][nowY]==1){
                    DFS(nowX, nowY);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        board = new int[n][n];
        visited = new int[n][n];
        for(int i=0; i<n; i++){
            String line = br.readLine();
            for(int j=0; j<n; j++){
                char c=line.charAt(j);
                board[i][j]=c-'0';
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(board[i][j]==1 && visited[i][j]==0){
                    count=0;
                    DFS(i, j);
                    nums.add(count);
                }
            }
        }

        Collections.sort(nums);
        System.out.println(nums.size());
        for(int x: nums) System.out.println(x);
    }
}
