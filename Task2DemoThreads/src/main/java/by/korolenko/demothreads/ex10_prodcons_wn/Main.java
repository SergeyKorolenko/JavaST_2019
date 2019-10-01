package by.korolenko.demothreads.ex10_prodcons_wn;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

        Store store = new Store();
        Producer p1 = new Producer(store);
        p1.setName("Prod - 1");
        Producer p2 = new Producer(store);
        p2.setName("Prod - 2");
        Consumer c1 = new Consumer(store);
        c1.setName("Cons - 1");
        Consumer c2 = new Consumer(store);
        c2.setName("Cons - 2");
        p1.start();
        p2.start();
        c1.start();
        c2.start();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
