package os1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;

public class Provider {
    private static int bufferSize = 10;

    public static ArrayList<String> deliverData(String path) {
        System.out.println();
        System.out.println("[info] Provider: Run ...");
        System.out.println("[info] Provider: thread id = " + Thread.currentThread().getId() + ";");
        System.out.println("[info] Provider: start to download data from root/" + path + " to buffers;");
        ArrayList<String> buffers = new ArrayList<>();
        try {
            Reader reader = new FileReader(path);
            BufferedReader bufferReader = new BufferedReader(reader);
            String file = "";
            String read;
            while (null != (read = bufferReader.readLine())) {
                file = file.concat(read + "\n");
            }
            while (file.length() > 0){
                if (file.length() > bufferSize){
                    buffers.add(file.substring(0, bufferSize - 1));
                    file = file.substring(bufferSize - 1);
                } else {
                    buffers.add(file);
                    file = "";
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("[error] File not found!");

        } catch (Exception e) {
            System.out.println("[error] Exception!");
        }
        System.out.println("[info] Provider: received " + buffers.size() + " buffers;");
        return buffers;
    }
}
