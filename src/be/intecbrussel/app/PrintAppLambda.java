package be.intecbrussel.app;

public class PrintAppLambda {

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> print('#',100));
        Thread thread2 = new Thread(() -> print('°',1000));

        //print initial state
        System.out.println("Print initial state of each thread: ");
        System.out.println("Thread1 state : " + thread1.getState());
        System.out.println("Thread2 state : " + thread2.getState());

        //initiate and print after initiation thread1 then thread2
        System.out.println(" ");

        System.out.println("start thread1: ");

        //make daemons
        thread1.setDaemon(true);
        thread2.setDaemon(true);


        thread1.start();
        System.out.println(" ");
        System.out.println("\nThread1 state after start: " + thread1.getState());
        System.out.println("\nstart thread2: ");
        thread2.start();
        System.out.println(" ");
        System.out.println("\nThread2 state after start: " + thread2.getState());


        print('@', 100);
        System.out.println(" ");
        System.out.println(thread1.getState());
        System.out.println(thread2.getState());
    }

    public static void print(char c, int count){
        for(int i =0; i < count; i++){
            System.out.print(c);
            Thread.yield();

        }
    }
}
