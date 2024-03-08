package com.boshrong.leetcode.dfs;

public class 矩阵中的路径jz12 {

    public static void main(String[] args) {
        char[][] chars = {{'A', 'B', 'F'}, {'B','E','G'}, {'C','D','G'}};
        String word="ABCDEBF";
        hasPath(chars,word);
    }

    //定义四个方向 上下左右
    static int [] dx=new int[]{-1,0,1,0};
    static int [] dy=new int[]{0,1,0,-1};
    static int rowlens;
    static int clomnlens;
    static boolean dfs(char [][] matrix,String word,int row,int clomn,int start,boolean[][] booleans){
        int lens=word.length();
        if(start==lens){
            return true;
        }
        char s=word.charAt(start);
        boolean flag=false;
        //从四周开始找，找到一个合适的字符
        for(int i=0;i<4;i++){
           if( 0<=row+dx[i]&& row+dx[i]<rowlens && 0<=clomn+dy[i]&& clomn+dy[i]<clomnlens ){
               if( booleans[row+dx[i]][clomn+dy[i]]==false){
                   if (matrix[row+dx[i]][clomn+dy[i]]==s){
                       booleans[row+dx[i]][clomn+dy[i]]=true;
                       flag=dfs(matrix,word,row+dx[i],clomn+dy[i],start+1,booleans);
                       if(flag==true){
                           break;
                       }
                       //通过debug 才发现，如果flag为false 将设为true 的置为false
                       // 回溯现场
                       booleans[row+dx[i]][clomn+dy[i]]=false;
                   }
               }
           }
        }
        return flag;
    }

    public static boolean hasPath (char[][] matrix, String word) {
        // write code here
        int lens=word.length();
        if(lens<0){
            return false;
        }
        boolean flag=false;
        rowlens=matrix.length;
        clomnlens=matrix[0].length;
        boolean enter= false;
        //访问矩阵也要传过去,初始全为false
        boolean[][] booleans = new boolean[rowlens][clomnlens];
        for(int i=0;i<rowlens;i++){
            for(int j=0;j<clomnlens;j++){
                if (matrix[i][j]==word.charAt(0)){
                    enter=true;
                    booleans[i][j]=true;
                    flag = dfs(matrix, word,i,j, 1,booleans);
                    if(flag==true){
                        break;
                    }
                }
                //进入一次递归就要清零
                if(enter){
                    for (int k=0;k<rowlens;k++){
                        for(int kk=0;kk<clomnlens;kk++){
                            booleans[k][kk]=false;
                        }
                    }
                    enter=false;
                }
            }
            if(flag==true){
                break;
            }
        }
        return flag;
    }
}
