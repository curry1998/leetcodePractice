package com.boshrong.leetcode.基础.回调函数;

public class 回调函数 {
    public static void main(String[] args) {
        Teacher teacher = new Teacher(new Tom());
        teacher.askQuestion();
        teacher.answer();

    }
}
//创建一个接口回调
interface TCallBack{
    public void tellAnswer(int answer);
}

interface Student{
    public void resolveQuestion(TCallBack tCallBack);
}

class Teacher implements TCallBack{
    private Student student;
    private Integer answer;
    public Teacher(Student student){
        this.student=student;
    }


    public void askQuestion(){
        student.resolveQuestion(this);
    }

    @Override
    public void tellAnswer(int answer) {
        this.answer=answer;
    }

    public void answer(){
        System.out.println(this.answer);
    }
}

class Tom implements Student{

    @Override
    public void resolveQuestion(TCallBack tCallBack) {
        //处理问题
        tCallBack.tellAnswer(3);
    }
}

