package os1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Provider {
    private static String inputPath = "Input.txt";

    public static void main(String[] args) throws InterruptedException, IOException {
        Reader reader = new FileReader(inputPath);
        BufferedReader bufferReader = new BufferedReader(reader);
        String read;
        while (null != (read = bufferReader.readLine())) {
            while (!MainThread.workProvider) {
                Thread.currentThread().sleep(1000);
            }
            MainThread.buffer = read;
            MainThread.workProvider = false;
            MainThread.workHandler = true;
        }
    }
}
