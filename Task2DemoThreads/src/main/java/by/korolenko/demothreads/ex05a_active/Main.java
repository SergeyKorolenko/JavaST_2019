package by.korolenko.demothreads.ex05a_active;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        System.out.println("Главный поток начал работу...");
        ThreadToDisable myThread = new ThreadToDisable();
        ThreadToInterrupted myThreadInter = new ThreadToInterrupted("new name");
        Thread myT = new Thread(myThread, "name of ThreadToDisable");
        myT.start();
        myThreadInter.start();
        try {
            TimeUnit.MILLISECONDS.sleep(1100);

            myThread.disable();
            myThreadInter.interrupt();

            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Поток прерван");
        }
        System.out.println("Главный поток завершил работу...");
    }
}
