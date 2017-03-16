package os3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainThread {

    public static boolean manyTimes = true;

    public static int sourceA = 50;
    public static int sourceB = 100;

    public static int capturedAbyFirst = 0;
    public static int capturedBbyFirst = 0;

    public static int capturedAbySecond = 0;
    public static int capturedBbySecond = 0;

    public static void main(String[] args) throws InterruptedException {
        do {
            ExecutorService executor = Executors.newCachedThreadPool();

            executor.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        FirstClient.main(args);
                    } catch (InterruptedException e) {
                    }
                }
            });

            executor.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        SecondClient.main(args);
                    } catch (InterruptedException e) {
                    }
                }
            });

            int second = 0;
            while (true) {
                if (FirstClient.pending && SecondClient.pending) {
                    second = second + 1;
                    System.out.println("Closes in  " + (10 - second) + " seconds");
                } else second = 0;
                if (second == 10) break;
                Thread.currentThread().sleep(1000);
            }

            executor.shutdownNow();

            if (manyTimes) {
                sourceA = 50;
                sourceB = 100;
                capturedAbyFirst = 0;
                capturedBbyFirst = 0;
                capturedAbySecond = 0;
                capturedBbySecond = 0;
                FirstClient.pending = false;
                SecondClient.pending = false;

                System.out.println();
                System.out.println();
                System.out.println();
            }
        } while (manyTimes);
    }
}
