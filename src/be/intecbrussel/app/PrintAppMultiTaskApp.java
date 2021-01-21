package be.intecbrussel.app;

public class PrintAppMultiTaskApp {

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> print('#', 500));
        Thread thread2 = new Thread(() -> print('°', 1000));
        System.out.println("Available processors on this Mac: " + Runtime.getRuntime().availableProcessors());
        thread1.setDaemon(true);
        thread2.setDaemon(true);

        thread1.start();
        thread2.start();


    }

    public static void print(char c, int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(c);
            Thread.yield();


        }

    }
}
