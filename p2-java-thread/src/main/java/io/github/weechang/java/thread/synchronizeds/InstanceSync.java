package io.github.weechang.java.thread.synchronizeds;

/**
 * Java synchronized 修饰实例方法
 */
public class InstanceSync implements Runnable {

    static int i = 0;

    public synchronized void syncCount() {
        i++;
    }

    public void run() {
        for (int j = 0; j < 100000; j++) {
            syncCount();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        InstanceSync instance = new InstanceSync();
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}
