package be.intecbrussel.app;

import be.intecbrussel.model.NumberThread;
import be.intecbrussel.model.PlayerRunnable;
import be.intecbrussel.model.PlayerThread;
import be.intecbrussel.model.Snowkids;

public class FootballApp {

    public static void main(String[] args) throws InterruptedException {
        //appWithThread();
        threadCycle();
    }

    private static void threadCycle() {
        Thread t1 = new NumberThread();
        ((NumberThread) t1).name = "t1";

        Thread t2 = new NumberThread();
        ((NumberThread) t2).name = "t2";

        System.out.println("T1 alive? " + t1.isAlive());
        System.out.println("T1 state? " + t1.getState());
        System.out.println("T2 alive? " + t2.isAlive());
        System.out.println("T2 state? " + t2.getState());

        t1.start();
        System.out.println("T1 alive? " + t1.isAlive());
        System.out.println("T1 state? " + t1.getState());
        System.out.println("T2 alive? " + t2.isAlive());
        System.out.println("T2 state? " + t2.getState());

        t2.start();
        System.out.println("T1 alive? " + t1.isAlive());
        System.out.println("T1 state? " + t1.getState());
        System.out.println("T2 alive? " + t2.isAlive());
        System.out.println("T2 state? " + t2.getState());

        for (int i = 0; i < 1000; i++) {
            System.out.println("Main" + " " + i);
        }

    }


    private static void appWithThread() throws InterruptedException {
        Snowkids team = new Snowkids();
        Runnable mert = new PlayerThread("Cristiano", team);
        Runnable jeanPierre = new PlayerThread("jeanPierre", team);
        Runnable matteo = new PlayerThread("Not Cristiano", team);
        Runnable microIce = new PlayerThread("MicroIce", team);

        Thread mertThread = new Thread(mert);
        Thread jeanPierreThread = new Thread(jeanPierre);
        Thread matteoThread = new Thread(matteo);
        Thread microIceThrea = new Thread(microIce);

        mertThread.start();
        jeanPierreThread.start();
        matteoThread.start();
        microIceThrea.start();

        Thread.sleep(3000);
        System.out.println(team.getTotalFans());


    }

    private static void appWithRunnable() throws InterruptedException {
        Snowkids team = new Snowkids();
        Runnable mert = new PlayerRunnable("Christiano Mert", team);
        Runnable jeanPierre = new PlayerRunnable("Jean-Pierre", team);
        Runnable matteo = new PlayerRunnable("(Not Christiano) Matteo", team);
        Runnable microIce = new PlayerRunnable("MicroIce", team);

        Thread mertThread = new Thread(mert);
        Thread jeanPierreThread = new Thread(jeanPierre);
        Thread matteoThread = new Thread(matteo);
        Thread microIceThread = new Thread(microIce);

        mertThread.start();
        jeanPierreThread.start();
        matteoThread.start();
        microIceThread.start();

        Thread.sleep(3000);
        System.out.println(team.getTotalFans());
    }

    private static void appWithLambdas() {
        Thread t1 = new Thread(() -> printNumbers(100));
        Thread t2 = new Thread(() -> printNumbers(100));

        t1.start();
        t2.start();
    }

    private static void printNumbers(int limit) {
        for (int i = 0; i < limit; i++) {
            System.out.println(i);
        }

    }

}
