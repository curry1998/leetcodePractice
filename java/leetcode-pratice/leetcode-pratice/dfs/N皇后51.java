package com.boshrong.leetcode.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N皇后51 {
    public static void main(String[] args) {

    }

    List<List<String>> res;
    public List<List<String>> solveNQueens(int n) {
        Character [][] s = new Character[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(s[i],'.');
        }
        res = new ArrayList<>();
        dfs(n,0,s);
        return res;
    }
    public void dfs(int n, int row, Character [][] s){
        if(row == n){
            ArrayList<String> tmp = new ArrayList<>();
            for(int i = 0; i < n; i++){
                String t = "";
                for(int j = 0;j < n;j++){
                    t += s[i][j];
                }
                tmp.add(t);
            }
            res.add(tmp);
            return;
        }
        // 遍历所有的列
        for(int col = 0; col < n; col++){
            if(isValid(s,row,col)){
                // 满足存放条件
                s[row][col] = 'Q';
                dfs(n , row + 1 , s);
                s[row][col] = '.';
            }
        }

    }
    public boolean isValid(Character [][] s, int row, int col){
        // 判断这一列,只考虑已经排好的
        for(int i = 0; i < row; i++){
            if(s[i][col] == 'Q'){
                return false;
            }
        }
        //判断45 度对角线
        for(int i = row - 1, j = col -1; i >= 0 && j >= 0; i--, j--){
            if(s[i][j] == 'Q'){
                return false;
            }
        }
        // 判断135 度对角线
        for(int i = row - 1, j = col + 1; i >= 0 && j <= s.length -1; i--, j++){
            if(s[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }
}
