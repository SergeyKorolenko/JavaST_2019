package by.korolenko.demothreads.ex12_pr_cons_reentrant_lock;

public class Producer extends Thread {
    int count;
    Store store;

    Producer(String name, Store store, int count) {
        super(name);
        this.store = store;
        this.count = count;
    }

    public void run() {
        for (int i = 1; i <= count; i++) {
            store.put();
        }
    }

}
