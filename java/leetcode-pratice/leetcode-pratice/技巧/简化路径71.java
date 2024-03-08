package com.boshrong.leetcode.技巧;

public class 简化路径71 {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder(".");
        System.out.println(stringBuilder.toString().equals("."));

        simplifyPath("/a/../../b/../c//.//");
    }
    public static String simplifyPath(String path) {
        //字符串模拟题 ,将每段字符串按照 /进行分段。对.. 和. 进行特判
        // 为了方便使用 StringBuilder
        StringBuilder res = new StringBuilder();
        StringBuilder tmp = new StringBuilder();
        for (int i = 0; i < path.length(); i++) {
            if (res.length() == 0) {
                res.append('/');
                continue;
            }
            if (path.charAt(i) != '/') {
                tmp.append(path.charAt(i));
            } else {
                // 等于斜杠,判断 tmp 是否为 .. 或 .
                 if (tmp.toString().equals("..")) {
                    // 上个目录
                    int j = res.length() - 1;
                    res.deleteCharAt(j);
                    j--;
                    while (res.length() > 1 && res.charAt(j) != '/') {
                        res.deleteCharAt(j);
                        j--;
                    }
                } else {
                    if(!tmp.toString().equals(".") &&tmp.length()!=0) {
                        res.append(tmp);
                        res.append('/');
                    }

                }
                tmp=new StringBuilder();
            }

        }
        int lens = res.length();
        if (lens > 0 && res.charAt(lens - 1) == '/') {
            res = res.deleteCharAt(lens - 1);
        }
        return res.toString();
    }
}
