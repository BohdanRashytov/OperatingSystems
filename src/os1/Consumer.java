package os1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;

public class Consumer {
    public static void writeData(ArrayList<String> buffers, String path) {
        try {
            Writer writer = new FileWriter(path);
            BufferedWriter bufferWriter = new BufferedWriter(writer);
            for (String buffer : buffers) {
                bufferWriter.write(buffer);
                bufferWriter.write(".");
            }
            bufferWriter.flush();
        } catch (Exception e) {
            System.out.println("[error] Exception!");
        }
    }
}
