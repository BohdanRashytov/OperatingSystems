package os1;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.concurrent.*;

public class MainThread {
    private static String inputPath = "Input.txt";
    private static String outputPath = "Output.txt";

    private static ExecutorService executor = Executors.newCachedThreadPool();

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        System.out.println("[info] Main: Start ...");
        System.out.println("[info] Main: thread id = " + Thread.currentThread().getId() + ";");
        Future<ArrayList<String>> data = executor.submit(new Callable<ArrayList<String>>() {
            public ArrayList<String> call() {
                return Provider.deliverData(inputPath);
            }
        });

        Future<ArrayList<String>> processedData = executor.submit(new Callable<ArrayList<String>>() {
            public ArrayList<String> call() {
                try {
                    if (data.get().size() > 0)
                        return Handler.processData(data.get());
                    return new ArrayList<>();
                } catch (InterruptedException e) {
                    System.out.println("[error] InterruptedException!");
                } catch (ExecutionException e) {
                    System.out.println("[error] ExecutionException!");
                }
                return new ArrayList<>();
            }
        });

        Boolean result = executor.submit(new Callable<Boolean>() {
            public Boolean call() {
                try {
                    if (processedData.get().size() > 0)
                        return Consumer.writeData(processedData.get(), outputPath);
                    else return false;
                } catch (InterruptedException e) {
                    System.out.println("[error] InterruptedException!");
                } catch (ExecutionException e) {
                    System.out.println("[error] ExecutionException!");
                }
                return false;
            }
        }).get();
        System.out.println();
        System.out.println("[info] Main: success = " + result + ";");
        System.out.println("[info] Main: Finish!");
        executor.shutdown();
    }
}
