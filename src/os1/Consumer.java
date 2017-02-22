package os1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;

public class Consumer {
    public static Boolean writeData(ArrayList<String> buffers, String path) {
        System.out.println();
        System.out.println("[info] Consumer: Run ...");
        System.out.println("[info] Consumer: thread id = " + Thread.currentThread().getId() + ";");
        System.out.println("[info] Consumer: data received;");
        try {
            Writer writer = new FileWriter(path);
            BufferedWriter bufferWriter = new BufferedWriter(writer);
            for (String buffer : buffers) {
                bufferWriter.write(buffer);
            }
            bufferWriter.flush();
        } catch (Exception e) {
            System.out.println("[error] Exception!");
        }
        System.out.println("[info] Consumer: data has been recorded to root/" + path + ";");
        return true;
    }
}
