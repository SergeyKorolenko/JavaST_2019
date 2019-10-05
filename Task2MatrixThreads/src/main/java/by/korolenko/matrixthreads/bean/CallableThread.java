package by.korolenko.matrixthreads.bean;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class CallableThread implements Callable<Integer> {

    /**
     * Count.
     */
    private static int count = 0;
    /**
     * Number.
     */
    private int number;
    /**
     * Numbers.
     */
    private int[] numbers;

    /**
     * Constructor.
     *
     * @param newNumbers number
     */
    public CallableThread(final int[] newNumbers) {
        this.numbers = newNumbers;
        if (count < numbers.length) {
            this.number = numbers[count++];
        } else {
            count = 0;
        }
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
