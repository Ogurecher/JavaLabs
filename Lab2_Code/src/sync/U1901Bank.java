package sync;

public class U1901Bank {
    private int intTo, intFrom = 220;

    public synchronized void calc(int intTransaction, long lngTimeout) {
        System.out.printf("Before: intFrom: %d; intTo: %d; Thread: %s\n", intFrom, intTo, Thread.currentThread().getName());

        intFrom -= intTransaction;

        try {
            Thread.sleep(lngTimeout);
        } catch (InterruptedException e) {
            e.getStackTrace();
        }

        intTo += intTransaction;

        System.out.printf("After: intFrom: %d; intTo: %d; Thread: %s\n", intFrom, intTo, Thread.currentThread().getName());
    }
}
