package com.gupao.learn.multithread;

import org.junit.Test;

/**
 * Description:
 *
 * @author 轩辚
 * @date 2019/3/13 18:17
 */
public class JavaProgramTest {
    public static int k = 0;
    int m = 9;

    {
        print("构造块",++m);
    }

    static {
        print("静态块",k++);
    }

    public JavaProgramTest(){
        ++k;
        m++;
    }

    public static void print(String str,int num) {
        System.out.println(str+num);
    }

    public static void main(String[] args) {
        new JavaProgramTest();
    }
}
