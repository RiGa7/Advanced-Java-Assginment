import java.io.*;
import java.util.*;
import java.util.regex.*;

public class p5 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("server_log.txt");
        Scanner scanner = new Scanner(fis);
        PrintWriter summaryWriter = new PrintWriter("log_summary.txt");
        PrintWriter sanitizedWriter = new PrintWriter("sanitized_log.txt");

        Map<String, Integer> logCounts = new HashMap<>();
        Pattern emailPattern = Pattern.compile("\\b[\\w.-]+@[\\w.-]+\\b");
        Pattern ipPattern = Pattern.compile("\\b(?:\\d{1,3}\\.){3}\\d{1,3}\\b");

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            if (line.contains("INFO")) logCounts.merge("INFO", 1, Integer::sum);
            else if (line.contains("WARNING")) logCounts.merge("WARNING", 1, Integer::sum);
            else if (line.contains("ERROR")) logCounts.merge("ERROR", 1, Integer::sum);

            line = emailPattern.matcher(line).replaceAll("[REDACTED_EMAIL]");
            line = ipPattern.matcher(line).replaceAll("[REDACTED_IP]");
            sanitizedWriter.println(line);
        }

        summaryWriter.println("Log Level Summary:");
        for (String level : List.of("INFO", "WARNING", "ERROR")) {
            summaryWriter.println(level + ": " + logCounts.getOrDefault(level, 0));
        }

        scanner.close();
        summaryWriter.close();
        sanitizedWriter.close();
    }
}
