import java.io.*;
import java.util.*;

public class p3 {
    public static void main(String[] args) {
        ArrayList<String> lines = new ArrayList<>();

        try (
            FileInputStream fis = new FileInputStream("lines.txt");
            Scanner scanner = new Scanner(fis)
        ){
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        Collections.sort(lines);
        System.out.println("sorted Lines: \n"+lines);

        try (
            FileOutputStream fos = new FileOutputStream("reversed_sorted_lines.txt");
            PrintWriter writer = new PrintWriter(fos)
        ){
            System.out.println("Rotated Line:");
            for (String line : lines) {
                String reversed = new StringBuilder(line).reverse().toString();
                System.out.println(reversed);
                writer.println(reversed);
            }
        } catch (IOException e) {
            System.out.println("Error : " + e.getMessage());
        }

    }
}
