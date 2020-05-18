package io.github.weechang.java.thread.synchronizeds;

/**
 * synchronized 修饰静态方法 -- 错误示例
 */
public class InstanceSyncBad implements Runnable{

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
        Thread t1 = new Thread(new InstanceSyncBad());
        Thread t2 = new Thread(new InstanceSyncBad());
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}
