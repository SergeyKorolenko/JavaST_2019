package by.korolenko.demothreads.ex01_thread;

public class Main {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread());
        HelloWorldThread thread = new HelloWorldThread();
        thread.setName("Hello World Thread");
        thread.start();
    }
}
