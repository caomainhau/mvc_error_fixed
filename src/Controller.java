import java.io.*;

// Controller
public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void addLine(String line) {
        model.addLine(line);
    }

    public void loadFromFile(File file) throws IOException {
        model.loadFromFile(file);
    }

    public void saveToFile(File file) throws IOException {
        model.saveToFile(file);
    }

    public void displayLines() {
        view.displayLines(model.getLines());
    }
}