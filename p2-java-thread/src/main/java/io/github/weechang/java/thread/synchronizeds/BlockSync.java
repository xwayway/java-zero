package io.github.weechang.java.thread.synchronizeds;

/**
 * synchronized 于代修饰码块
 */
public class BlockSync implements Runnable {

    static BlockSync instance = new BlockSync();
    static int i = 0;

    public void run() {
        //使用同步代码块对变量i进行同步操作,锁对象为instance
        synchronized (instance) {
            for (int j = 0; j < 100000; j++) {
                i++;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}
