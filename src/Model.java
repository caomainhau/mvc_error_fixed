import java.io.*;
import java.util.*;

// Model
public class Model {
    private List<String> lines = new ArrayList<>();

    public void addLine(String line) {
        lines.add(line); // Add a line to the list of lines
    }

    public List<String> getLines() {
        return lines; // Return the list of lines
    }

    public void loadFromFile(File file) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line); // Add each line from the file to the list
            }
        }
    }

    public void saveToFile(File file) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine(); // Write each line to the file
            }
        }
    }
}