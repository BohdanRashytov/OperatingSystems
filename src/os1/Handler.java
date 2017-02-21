package os1;


import java.util.ArrayList;

public class Handler {
    public static ArrayList<String> processData(ArrayList<String> buffers) {
        ArrayList<String> buffersCopy = new ArrayList<>();
        for (String buffer : buffers) {
            buffersCopy.add(buffer.toLowerCase());
        }
        return buffersCopy;
    }
}
