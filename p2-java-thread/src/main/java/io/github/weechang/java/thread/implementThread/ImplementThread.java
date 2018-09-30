package io.github.weechang.java.thread.implementThread;

/**
 * Java 中如何实现线程
 * @author zhangwei
 * date 2018/9/30
 * time 17:50
 */
public class ImplementThread {

    public static void main(String[] args) {
        ImplementThread implementThread = new ImplementThread();
        implementThread.byThread2();
    }

    /**
     * 继承 Thread 方式
     */
    public void byThread(){
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();

        t1.start();
        t2.start();
    }

    /**
     * Thread 资源不共享的补充说明
     */
    public void byThread2(){
        MyThread myThread = new MyThread();

        Thread t1 = new Thread(myThread);
        Thread t2 = new Thread(myThread);

        t1.start();
        t2.start();
    }

    /**
     * 实现 Runnable方式
     */
    public void byRunnable(){
        MyRunnable myRunnable = new MyRunnable();

        Thread t1 = new Thread(myRunnable);
        Thread t2 = new Thread(myRunnable);

        t1.start();
        t2.start();
    }
}


class MyThread extends Thread {
    private int count = 10;

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if (this.count > 0) {
                System.out.println(this.getName() + " 计数器：count" + this.count--);
            }
        }
    }

}

class MyRunnable implements Runnable{

    private int count = 10;

    public void run() {
        for (int i = 0; i < 20; i++) {
            if (this.count > 0) {
                System.out.println(Thread.currentThread().getName() + " 计数器：count" + this.count--);
            }
        }
    }

}