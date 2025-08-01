import java.io.*;
import java.util.Scanner;

public class p2 {
    public static void main(String[] args) {

        StringBuilder str = new StringBuilder();
        try (
            FileInputStream fileS = new FileInputStream("input2.txt");
            Scanner sc = new Scanner(fileS);
         ){
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                line = line.toLowerCase();
                System.out.println(line);

                for (int i = 0; i < line.length(); i++) {
                    char ch = line.charAt(i);
                    if (Character.isLetter(ch)) {
                        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                            str.append("*");
                        } else {
                            str.append("#");
                        }
                    } else {
                        str.append(ch);
                    }
                }
                str.append("\n");
            }
         } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(str);

        try (FileOutputStream fos = new FileOutputStream("masked_output.txt")) {
            fos.write(str.toString().getBytes());
        } catch (IOException e) {
            System.out.println("Error : " + e.getMessage());
        }
    }
}
