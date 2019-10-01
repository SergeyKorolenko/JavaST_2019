package by.korolenko.demothreads.ex02_runnable;

public class Main {

    public static void main(String[] args) {
        RunnablePerson alice = new RunnablePerson("Alice");
        RunnablePerson bob = new RunnablePerson("Bob");
        Thread aliceThread = new Thread(alice);
        Thread bobThread = new Thread(bob);
        aliceThread.start();
        bobThread.start();
    }
}
