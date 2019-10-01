package by.korolenko.demothreads.ex05c_deamon;

import java.util.concurrent.TimeUnit;

public class SimpleThread extends Thread {

    public void run() {
        try {
            if (isDaemon()) {
                System.out.println("demon-thread has started");
                TimeUnit.SECONDS.sleep(1);
            } else {
                System.out.println("usual-thread has started");
            }
        } catch (InterruptedException e) {
            System.err.println(e);
        } finally {
            if (!isDaemon()) {
                System.out.println("usual-thread has finished");
            } else {
                System.out.println("demon-thread has finished");
            }
        }
    }
}
