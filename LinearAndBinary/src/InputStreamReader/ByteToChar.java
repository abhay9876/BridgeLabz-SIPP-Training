package InputStreamReader;
import java.io.*;


public class ByteToChar {
   public static void main(String[] args) {
	   String filepath = "./example.txt";
	   String charSet = "UTF-8";
	   
	   try (
		   FileInputStream fis = new FileInputStream(filepath);
		   InputStreamReader isr = new InputStreamReader(fis, charSet);
		   BufferedReader br = new BufferedReader(isr);
		   ){
		   String line;
		   while ((line = br.readLine()) != null) {
               System.out.println(line);
           }
	   }
	   
	   catch (UnsupportedEncodingException e) {
           System.err.println("Unsupported character encoding: " + charSet);
       } catch (FileNotFoundException e) {
           System.err.println("File not found: " + filepath);
       } catch (IOException e) {
           System.err.println("Error reading file: " + e.getMessage());
       }
   }
}
