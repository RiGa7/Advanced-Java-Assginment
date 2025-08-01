import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class p4 {
    public static void main(String[] args) {

        HashMap<String, Integer> hash = new HashMap<>();
        try (
                FileInputStream fileS = new FileInputStream("paragraph.txt");
                Scanner FileSc = new Scanner(fileS);                
                FileWriter output = new FileWriter("redacted_output");
        ) {
            while (FileSc.hasNext()) {
                String word = FileSc.next();
                int count = hash.getOrDefault(word, 0);

                if (count >= 1) {
                    System.out.print("redacted ");
                    output.write("redacted ");
                } else {
                    System.out.print(word + " ");
                    output.write(word + " ");
                }

                hash.put(word, count + 1);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
