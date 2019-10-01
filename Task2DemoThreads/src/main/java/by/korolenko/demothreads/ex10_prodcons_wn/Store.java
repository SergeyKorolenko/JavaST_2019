package by.korolenko.demothreads.ex10_prodcons_wn;

public class Store {

    private int product = 0;

    public synchronized void put() {
        while (product >= 3) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        product++;
        System.out.println("Производитель " + Thread.currentThread().getName() + " добавил 1 товар");
        System.out.println("Товаров на складе: " + product);
        notify();
    }

    public synchronized void get() {
        while (product < 1) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        product--;
        System.out.println("Покупатель " + Thread.currentThread().getName() + " купил 1 товар");
        System.out.println("Товаров на складе: " + product);
        notify();
    }

}
