package com.boshrong.leetcode.dfs;


import java.util.LinkedList;
class point{
    Integer a;
    Integer b;
    public point(Integer a,Integer b){
        this.a=a;
        this.b=b;
    }
    public int getPointa(){
        return this.a;
    }
    public int getPointb(){
        return this.b;
    }

}

public class 机器人的运动范围jz13 {
    public static void main(String[] args) {
        int i = movingCount(3, 2, 17);
        System.out.println(i);

    }
    public static int movingCount(int m, int n, int k) {
        // 坐标有两个值
        LinkedList<point> queue = new LinkedList<>();
        // 标记数组
        Boolean[][] flags = new Boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                flags[i][j]=false;
            }
        }
        //四个方向 上 右 下 左 dx 为向上的
        int [] dx=new int[]{-1,0,1,0};
        int [] dy=new int[]{0,1,0,-1};
        int result=0;
        queue.push(new point(0,0));
        flags[0][0]=true;
        while(!queue.isEmpty()){
            point pop = queue.pop();
            result++;
            //将满足条件的点加入队列中
            for(int i=0;i<4;i++){
                int i1 = pop.getPointa() + dx[i];
                int i2 = pop.getPointb() + dy[i];
                //边界判断并满足阈值条件并未被访问
                if (getTwo(i1,i2)<=k && i1<=m-1 && i1>=0 && i2>=0&& i2<=n-1){
                    if(!flags[i1][i2]){
                        flags[i1][i2]=true;
                        queue.push(new point(i1,i2));

                    }
                }
            }
        }
        return result;
    }
    //获取单个数字的位数之和
    static int getOne(int num){
        int result=0;
        while(num!=0){
            //取最后一个数
            result+=num%10;
            num=num/10;
        }
        return result;
    }
    static int getTwo(int num1,int num2){
        return getOne(num1)+getOne(num2);
    }
}
