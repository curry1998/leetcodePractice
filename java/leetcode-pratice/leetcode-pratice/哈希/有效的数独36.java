package com.boshrong.leetcode.哈希;

import java.util.HashMap;

public class    有效的数独36 {
    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] clomns = new int[9][9];
        int[][][] subBoard = new int[3][3][9];
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]!='.'){
                    //数字是从1-9,下标为0的位置要表示为1
                    int num=board[i][j]-'0'-1;
                    rows[i][num]++;
                    clomns[j][num]++;
                    subBoard[i/3][j/3][num]++;
                    if(rows[i][num]>1||clomns[j][num]>1||subBoard[i/3][j/3][num]>1){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
