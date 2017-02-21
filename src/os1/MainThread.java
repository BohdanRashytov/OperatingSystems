package os1;

public class MainThread {
    private static String inputPath = "Input.txt";
    private static String outputPath = "Output.txt";

    public static void main(String[] args) {
        Consumer.writeData(Handler.processData(Provider.deliverData(inputPath)), outputPath);

    }
}
