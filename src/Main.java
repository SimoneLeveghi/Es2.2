/*
ES2
Due amici si recano in una biblioteca per prendere in prestito dei libri.
Gli amici devono attendere il loro turno poiché in biblioteca c’è un unico sportello.
Considerando che i libri verranno cercati dal bibliotecario, che tempo per la ricerca del libro è di 2 secondi,
 e che il primo amico ne prende in prestito 3, mentre il secondo ne prende 2, simulare la situazione.
 Gli amici lasciano la biblioteca insieme solo quando entrambi hanno preso ciò di cui avevano bisogno
 */

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Semaphore s = new Semaphore(1);

        Amico a1 = new Amico(s, 3);
        Amico a2 = new Amico(s, 2);

        Thread t1 = new Thread(a1);
        Thread t2 = new Thread(a2);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Gli amici escono dalla biblioteca");

    }
}