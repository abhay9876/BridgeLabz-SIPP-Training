package InputStreamReader;

import java.io.*;

public class ConsoleToFileWriter {
    public static void main(String[] args) {
        
        String filePath = "user_input.txt";

        try (
           
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader reader = new BufferedReader(isr);

            
            FileWriter writer = new FileWriter(filePath)
        ) {
            System.out.println("Enter text (type 'exit' to quit):");

            String line;

            
            while ((line = reader.readLine()) != null) {
                if (line.equalsIgnoreCase("exit")) {
                    break;
                }

                writer.write(line);
                writer.write(System.lineSeparator()); 
            }

            System.out.println("Input saved to " + filePath);

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

