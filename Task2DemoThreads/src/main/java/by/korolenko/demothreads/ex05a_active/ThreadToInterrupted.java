package by.korolenko.demothreads.ex05a_active;

import java.util.concurrent.TimeUnit;

public class ThreadToInterrupted extends Thread {

    public ThreadToInterrupted(String name) {
        super(name);
    }

    public void run() {
        System.out.printf("Поток %s начал работу... \n", Thread.currentThread().getName());
        int counter = 1; // счетчик циклов
        while (!Thread.interrupted()) {
            System.out.println("Цикл " + counter++);
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Поток прерван");
            }
        }
        System.out.printf("Поток %s завершил работу... \n", Thread.currentThread().getName());
    }
}
