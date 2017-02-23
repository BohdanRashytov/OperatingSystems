package os1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Consumer {
    private static String outputPath = "Output.txt";

    public static void main(String[] args) throws InterruptedException, IOException {
        Writer writer = new FileWriter(outputPath);
        BufferedWriter bufferWriter = new BufferedWriter(writer);

        while (true) {
            while (!MainThread.workConsumer) {
                Thread.currentThread().sleep(1000);
            }
            bufferWriter.write(MainThread.buffer + "\n");
            MainThread.workConsumer = false;
            MainThread.workProvider = true;
            bufferWriter.flush();
        }
    }
}
