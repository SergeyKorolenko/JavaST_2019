package by.korolenko.demothreads.ex14_philosophers;

import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        final int plates = 5;
        final int philosophers = 13;
        Semaphore sem = new Semaphore(plates);
        for (int i = 1; i <= philosophers; i++)
            new Philosopher(sem, i).start();

    }
}
