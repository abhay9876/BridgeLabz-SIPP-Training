import java.io.*;

public class FileReadingComparison {
    public static void main(String[] args) throws Exception {
        File file = new File("sample.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        for (int i = 0; i < 1000000; i++) writer.write("Sample text\n");
        writer.close();

        long start = System.currentTimeMillis();
        FileReader fr = new FileReader(file);
        while (fr.read() != -1) {}
        fr.close();
        System.out.println("FileReader time: " + (System.currentTimeMillis() - start) + "ms");

        start = System.currentTimeMillis();
        InputStreamReader isr = new InputStreamReader(new FileInputStream(file));
        while (isr.read() != -1) {}
        isr.close();
        System.out.println("InputStreamReader time: " + (System.currentTimeMillis() - start) + "ms");
    }
}