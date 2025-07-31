import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class p1 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();

        try (FileWriter writer = new FileWriter("C:/Users/nikki/Desktop/Java Assignment/input.txt")) {

            writer.write(text);

        }catch(IOException e){
            System.out.println("Error"+e.getMessage());
        }

        FileInputStream fileS = new FileInputStream("input.txt");
        Scanner fileSc = new Scanner(fileS);
        HashMap<String, Integer> hash = new HashMap<>();

        while (fileSc.hasNext()) {
            String word = fileSc.next().replaceAll("[^a-zA-z]","").toLowerCase();

            if(!word.isEmpty()){
                hash.put(word, hash.getOrDefault(word,0)+1);
            }
        }

        System.out.println(hash);

        FileWriter output = new FileWriter("output.txt");

        for(String word : hash.keySet()){
            output.write(word+" : "+ hash.get(word)+"\n");
        }

        output.close();
        fileS.close();
        sc.close();
        fileSc.close();
    }
}
