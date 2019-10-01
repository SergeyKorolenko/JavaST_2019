package by.korolenko.demothreads.ex12_pr_cons_reentrant_lock;

public class Main {

    public static void main(String[] args) {

        Store store = new Store();
        Producer p1 = new Producer("producer 1", store, 10);
        Consumer c1 = new Consumer("cons 1", store, 5);
        Consumer c2 = new Consumer("cons 2", store, 3);
        Consumer c3 = new Consumer("cons 3", store, 2);
        p1.start();
        c1.start();
        c2.start();
        c3.start();

        try {
            c1.join();
            c2.join();
            c3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
