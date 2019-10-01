package by.korolenko.demothreads.ex06b_synchronized;

public class Main {

    public static void main(String[] args) {
        CommonResource commonResource = new CommonResource();
        for (int i = 1; i <= 3; i++) {
            Thread t = new Thread(new CountThread(commonResource));
            t.setName("Поток " + i);
            t.start();
        }

    }
}

