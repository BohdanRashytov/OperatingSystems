package os3;

import static os3.MainThread.*;

public class FirstClient {

    public static boolean pending = false;

    public static void main(String[] args) throws InterruptedException {
        while (true) {
            takeSourceA(30);
            takeSourceB(60);
            putSourceA(30);
            putSourceB(60);
        }
    }

    public static void takeSourceA(int x) throws InterruptedException {
        while (true) {
            if (sourceA >= x) {
                pending = false;
                sourceA = sourceA - x;
                capturedAbyFirst = capturedAbyFirst + x;
                System.out.println("FirstClient: take A " + x);
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
                capturedBbyFirst = capturedBbyFirst + x;
                System.out.println("FirstClient: take B " + x);
                return;
            } else {
                pending = true;
                Thread.currentThread().sleep(100);
            }
        }
    }

    public static void putSourceA(int x) {
        sourceA = sourceA + x;
        capturedAbyFirst = capturedAbyFirst - x;
        System.out.println("FirstClient: put A " + x);
    }

    public static void putSourceB(int x) {
        sourceB = sourceB + x;
        capturedBbyFirst = capturedBbyFirst - x;
        System.out.println("FirstClient: put B " + x);
    }
}
