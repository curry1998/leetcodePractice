package com.boshrong.leetcode.dfs;

public class 解数独37 {

    static boolean  [][] rows= new boolean[9][9];
    static boolean [][] cols=new boolean[9][9];
    static boolean [][][] sub=new boolean[3][3][9];

    public static void main(String[] args) {

       char [][] ints  = new char [][]{
               {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}};
       solveSudoku(ints);
       System.out.println();
    }


    public static void solveSudoku(char[][] board) {
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    continue;
                }else{
                    int num = board[i][j]-'1';
                    rows[i][num] = cols[j][num] = sub[i/3][j/3][num] = true;
                }
            }
        }
        dfs(board,0,0);
    }
    public static boolean dfs(char [][] board,int x,int y){
        // 从左望右填数字，遇到y=9 越界了
        if(y == 9){
            x++;
            y=0;
        }
        if(x == 9) return true;
        if(board[x][y] != '.') return dfs(board,x,y+1);

        for(int i=0;i<9;i++){
                //判断能否加入
            if(!cols[x][i] && !rows[y][i] && !sub[x/3][y/3][i]){
                cols[x][i] = rows[y][i] = sub[x/3][y/3][i] = true;
                board[x][y] = (char)(i+'1');
                if(dfs(board,x,y+1)){
                    return true;
                }
                //回溯现场
                //board[x][y]='.';
                cols[x][i] = rows[y][i] = sub[x/3][y/3][i] = false;
            }
        }
        return false;
    }

}
