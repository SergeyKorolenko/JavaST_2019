package by.korolenko.matrixthreads.bean;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 25.09.2019
 */
public class CallableThread implements Callable<Integer> {
    /**
     * Number.
     */
    private int number;

    /**
     * Constructor.
     *
     * @param newNumber number
     */
    public CallableThread(final int newNumber) {
        this.number = newNumber;
    }

    /**
     * Callable method.
     *
     * @return integer
     * @throws Exception exception
     */
    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName() + " print "
                + number);
        final int timeout = 10;
        TimeUnit.MILLISECONDS.sleep(timeout);
        return number;
    }
}
