package sync;

public class U1901Thread extends  Thread {
    private U1901Bank bankWork;
    private int intTrans;
    private long lngSleep;

    public void run() {
        bankWork.calc(intTrans, lngSleep);
    }

    public U1901Thread(U1901Bank bankWork, int intTrans, long lngSleep) {
        this.bankWork = bankWork;
        this.intTrans = intTrans;
        this.lngSleep = lngSleep;
    }
}
