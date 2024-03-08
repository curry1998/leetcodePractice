package com.boshrong.leetcode.队列栈;

import java.util.LinkedList;

public class 矩阵中的路径 {
    int[] dx = new int []{1,0,-1,0};
    int[] dy = new int []{0,1, 0,1};
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        char [] words = word.toCharArray();
        for(int i = 0; i< m;i++){
            for(int j =0;j<n; j++){
                if(board[i][j] == words[0]){
                    LinkedList<int []> queue= new LinkedList<>();
                    int startIndex = 1;
                    queue.offer(new int[]{i,j});
                    while(!queue.isEmpty()){
                        int[] peek = queue.peek();
                        for(int k =0;k<4;k++){
                            int newX = peek[0]+ dx[k];
                            int newY = peek[1] +dy[k];

                            if(newX<0 || newX>=m || newY<0 || newY>=n || board[i][j] != words[startIndex]){
                                continue;
                            }
                            startIndex++;
                            queue.offer(new int[]{newX,newY});
                            if(startIndex == words.length){
                                return true;
                            }
                        }
                        int[] poll = queue.poll();
                        board[poll[0]][poll[1]] = '0';
                    }
                }
            }

        }
        return false;
    }
}
