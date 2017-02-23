package os1;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainThread {
    public static Boolean workProvider = true;
    public static Boolean workHandler = false;
    public static Boolean workConsumer = false;

    public static String buffer = "";
    private static ExecutorService executor = Executors.newCachedThreadPool();

    public static void main(String[] args) throws ExecutionException, InterruptedException, IOException {


        executor.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    Provider.main(args);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        executor.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    Handler.main(args);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
