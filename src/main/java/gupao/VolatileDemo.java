package main.java.gupao;

/**
 * @description:
 * @author：wwei
 * @date: 2022/3/30
 */
public class VolatileDemo {


    public static volatile boolean stop = false;

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            int i = 0;

            while (!stop) {
                i++;
            }
            System.out.printf("i" + i);
        });
        t1.start();
        System.out.println("begin start thread");
        Thread.sleep(1000);
        stop = true;


    }
}
