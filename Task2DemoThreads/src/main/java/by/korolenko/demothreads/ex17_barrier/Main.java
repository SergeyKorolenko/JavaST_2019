package by.korolenko.demothreads.ex17_barrier;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Auction auction = new Auction();
        int startPrice = new Random().nextInt(100);
        for (int i = 0; i < auction.BIDS_NUMBER; i++) {
            Bid thread = new Bid(i, startPrice, auction.getBarrier());
            auction.add(thread);
            thread.start();
        }
    }
}
