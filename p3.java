import java.io.*;
import java.util.*;

public class p3 {
    public static void main(String[] args) {
        List<String> lines = new ArrayList<>();

        // Step 1: Read lines from the file
        try (
            FileInputStream fis = new FileInputStream("lines.txt");
            Scanner scanner = new Scanner(fis)
        ) {
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        // Step 2: Sort the lines alphabetically
        Collections.sort(lines);

        // Step 3: Reverse each line character-wise
        List<String> reversedLines = new ArrayList<>();
        for (String line : lines) {
            reversedLines.add(new StringBuilder(line).reverse().toString());
        }

        // Step 4: Write reversed and sorted lines to output file
        try (
            FileOutputStream fos = new FileOutputStream("reversed_sorted_lines.txt");
            PrintWriter writer = new PrintWriter(fos)
        ) {
            for (String reversedLine : reversedLines) {
                writer.println(reversedLine);
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }

        System.out.println("Sorted and reversed lines written to reversed_sorted_lines.txt");
    }
}
