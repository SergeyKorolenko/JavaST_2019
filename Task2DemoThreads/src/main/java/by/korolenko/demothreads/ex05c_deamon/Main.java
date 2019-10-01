package by.korolenko.demothreads.ex05c_deamon;

public class Main {

    public static void main(String[] args) {
        SimpleThread usual = new SimpleThread();
        SimpleThread daemon = new SimpleThread();

        daemon.setDaemon(true);
        daemon.start();
        usual.start();

        System.out.println("last operator of main");
    }
}
