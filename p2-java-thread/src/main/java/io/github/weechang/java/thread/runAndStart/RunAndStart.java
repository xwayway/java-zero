package io.github.weechang.java.thread.runAndStart;

/**
 * run 和 start 的区别
 */
public class RunAndStart {

    public static void main(String[] args) {
        MyThread myThread = new MyThread("test");

        System.out.println("*** myThread run method");
        myThread.run();

        System.out.println("*** myThread start method");
        myThread.start();
    }

}

class MyThread extends Thread{

    public MyThread(String name){
        super(name);
    }

    @Override
    public void run(){
        System.out.println("my name is " + Thread.currentThread().getName());
    }
}