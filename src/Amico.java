import java.util.concurrent.Semaphore;

public class Amico implements Runnable {
    private Semaphore s;
    private int nLibri;

    public Amico (Semaphore s , int nLibri){
        this.s = s;
        this.nLibri = nLibri;
    }

    @Override
    public void run() {
        s.acquireUninterruptibly();
        System.out.println("Amico " + Thread.currentThread().getName() + " prende in prestito i libri");
        try {
            Thread.sleep(nLibri * 2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Amico " + Thread.currentThread().getName() + " ha preso i libri");
        s.release();
    }
}
