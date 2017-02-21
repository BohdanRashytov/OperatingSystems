package os1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;

public class Provider {
    public static ArrayList<String> deliverData(String path) {
        ArrayList<String> buffers = new ArrayList<>();
        try {
            Reader reader = new FileReader(path);
            BufferedReader bufferReader = new BufferedReader(reader);
            String file = "";
            String read;
            while (null != (read = bufferReader.readLine())) {
                file = file.concat(read);
            }
            for (String buffer : file.split("\\.")) {
                buffers.add(buffer);
            }
        } catch (FileNotFoundException e) {
            System.out.println("[error] File not found!");
        } catch (Exception e) {
            System.out.println("[error] Exception!");
        }
        return buffers;
    }
}
