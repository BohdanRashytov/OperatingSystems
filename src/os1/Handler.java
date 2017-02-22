package os1;


import java.util.ArrayList;

public class Handler {
    public static ArrayList<String> processData(ArrayList<String> buffers) {
        System.out.println();
        System.out.println("[info] Handler: Run ...");
        System.out.println("[info] Handler: thread id = " + Thread.currentThread().getId() + ";");
        System.out.println("[info] Handler: data received;");
        ArrayList<String> buffersCopy = new ArrayList<>();
        for (String buffer : buffers) {
            buffersCopy.add(buffer.toLowerCase());
        }
        System.out.println("[info] Handler: data processed;");
        return buffersCopy;
    }
}
