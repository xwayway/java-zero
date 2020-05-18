package io.github.weechang.java.thread.synchronizeds;


/**
 * synchronized 修饰
 */
public class StaticSync implements Runnable {

    static int i=0;

    public static synchronized void increase(){
        i++;
    }

    public void run() {
        for(int j=0;j<100000;j++){
            increase();
        }
    }
    public static void main(String[] args) throws InterruptedException {
        // 新实例
        Thread t1=new Thread(new StaticSync());
        Thread t2=new Thread(new StaticSync());

        // 启动线程
        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println(i);
    }

}
