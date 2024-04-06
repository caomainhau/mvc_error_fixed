import java.io.File;
import java.io.IOException;
import java.util.List;

// Controller
public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model; // Initialize Controller with Model and View
        this.view = view;
    }

    public void addLine(String line) {
        model.addLine(line); // Add a line to the Model
    }

    public void loadFromFile(File file) throws IOException {
        model.loadFromFile(file); // Load data from file into the Model
    }

    public void saveToFile(File file) throws IOException {
        model.saveToFile(file); // Save data from the Model to file
    }

    public void displayLines() {
        view.displayLines(model.getLines()); // Display lines from the Model using the View
    }

    public List<String> getLines() {
        return model.getLines(); // Return a list of lines from the Model
    }

    public void addLines(List<String> lines) {
        for (String line : lines) {
            model.addLine(line); // Add a list of lines to the Model
        }
    }
}
