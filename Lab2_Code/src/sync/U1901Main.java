package sync;

public class U1901Main {
    public static void main(String[] args) {
        U1901Bank bankMain = new U1901Bank();
        U1901Thread threadOne = new U1901Thread(bankMain, 100, 2000);
        U1901Thread threadTwo = new U1901Thread(bankMain, 50, 300);

        threadOne.setName("Thread 1");
        threadOne.setPriority(Thread.MAX_PRIORITY);

        threadTwo.setName("Thread 2");
        threadTwo.setPriority(Thread.MAX_PRIORITY);

        threadOne.start();
        threadTwo.start();

        System.out.printf("Current thread: %s\n", Thread.currentThread().getName());
    }
}
