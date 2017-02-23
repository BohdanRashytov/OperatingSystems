package os1;

public class Handler {
    public static void main(String[] args) throws InterruptedException {
        while (true) {
            while (!MainThread.workHandler) {
                Thread.currentThread().sleep(1000);
            }
            MainThread.buffer = MainThread.buffer.toLowerCase();
            MainThread.workHandler = false;
            MainThread.workConsumer = true;
        }
    }
}
