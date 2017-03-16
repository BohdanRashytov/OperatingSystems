package os3;

import static os3.MainThread.*;

public class SecondClient {

    public static boolean pending = false;

    public static void main(String[] args) throws InterruptedException {
        while (true) {
            takeSourceB(60);
            takeSourceA(30);
            putSourceB(60);
            putSourceA(30);
        }
    }

    public static void takeSourceA(int x) throws InterruptedException {
        while (true) {
            if (sourceA >= x) {
                pending = false;
                sourceA = sourceA - x;
                capturedAbySecond = capturedAbySecond + x;
                System.out.println("SecondClient: take A " + x);
                return;
            } else {
                pending = true;
                Thread.currentThread().sleep(100);
            }
        }
    }

    public static void takeSourceB(int x) throws InterruptedException {
        while (true) {
            if (sourceB >= x) {
                pending = false;
                sourceB = sourceB - x;
                capturedBbySecond = capturedBbySecond + x;
                System.out.println("SecondClient: take B " + x);
                return;
            } else {
                pending = true;
                Thread.currentThread().sleep(100);
            }
        }
    }

    public static void putSourceA(int x) {
        sourceA = sourceA + x;
        capturedAbySecond = capturedAbySecond - x;
        System.out.println("SecondClient: put A " + x);
    }

    public static void putSourceB(int x) {
        sourceB = sourceB + x;
        capturedBbySecond = capturedBbySecond - x;
        System.out.println("SecondClient: take B " + x);
    }
}
