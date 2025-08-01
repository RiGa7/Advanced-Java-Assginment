import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P1Old {
    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("input.txt");
        System.out.println(fis);
        Scanner sc = new Scanner(fis);

        HashMap<String, Integer> hash = new HashMap<>();

        while (sc.hasNext()) {
            String word = sc.next();

            System.out.println(word);
            word = word.replaceAll("[^a-zA-Z]", "").toLowerCase();

            if (!word.isEmpty()) {
                hash.put(word, hash.getOrDefault(word, 0) + 1);
            }
        }

        FileOutputStream fos = new FileOutputStream("wordCount.txt");
        PrintWriter writer = new PrintWriter(fos);

        /*
         * entrySet() ->  returns a set of all key-value pairs in the map
         * Map.Entry<> -> A Map.Entry represents one key-value pair.
         */
        for (Map.Entry<String, Integer> entry : hash.entrySet()) {
            writer.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.print(hash);

        writer.close();
        sc.close();

    }
}
