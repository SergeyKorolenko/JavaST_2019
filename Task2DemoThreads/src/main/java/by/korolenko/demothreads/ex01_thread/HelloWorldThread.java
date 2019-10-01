package by.korolenko.demothreads.ex01_thread;

public class HelloWorldThread extends Thread {

    /**
     * Run method.
     */
    public void run() {
        System.out.println(Thread.currentThread());
        System.out.println("Hello, World");
    }
}
