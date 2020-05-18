package io.github.weechang.java.thread.threadMessage;

/**
 * Java 线程间通信
 */
public class ThreadMessage {

    public static void main(String[] args) {
        WaitTest wT = new WaitTest();
        wT.test();
    }
}

class WaitTest {

    public void test() {
        ThreadA tA = new ThreadA("t1");

        synchronized (tA) {
            try {
                // 启动“线程tA”
                System.out.println(Thread.currentThread().getName() + " start tA");
                tA.start();

                // 主线程等待tA通过notify()唤醒。
                System.out.println(Thread.currentThread().getName() + " wait()");
                tA.wait();

                System.out.println(Thread.currentThread().getName() + " continue");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

/**
 * 线程A
 */
class ThreadA extends Thread {

    public ThreadA(String name) {
        super(name);
    }

    public void run() {
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + " run notify()");
            // 唤醒当前的wait线程
            notify();
        }
    }
}
