package by.korolenko.demothreads.ex02_runnable;

public class RunnablePerson extends Person implements Runnable {

    public RunnablePerson(final String name) {
        super(name);
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(getName() + " Hello world");
        }
    }
}
