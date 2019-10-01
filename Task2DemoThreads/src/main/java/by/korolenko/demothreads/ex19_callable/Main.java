package by.korolenko.demothreads.ex19_callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(4);
        List<Future<Number>> list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            list.add(es.submit(new CalcCallable()));
        }
        es.shutdown();
        try {
            for (int i = 0; i < 4; i++) {
                System.out.println(list.get(i).get());
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
