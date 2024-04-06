import java.io.File;
import java.io.IOException;
import java.util.List;

// Controller
public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model; // Khởi tạo Controller với Model và View
        this.view = view;
    }

    public void addLine(String line) {
        model.addLine(line); // Thêm một dòng vào Model
    }

    public void loadFromFile(File file) throws IOException {
        model.loadFromFile(file); // Nạp dữ liệu từ tệp vào Model
    }

    public void saveToFile(File file) throws IOException {
        model.saveToFile(file); // Lưu dữ liệu từ Model vào tệp
    }

    public void displayLines() {
        view.displayLines(model.getLines()); // Hiển thị các dòng từ Model sử dụng View
    }

    public List<String> getLines() {
        return model.getLines(); // Trả về danh sách các dòng từ Model
    }

    public void addLines(List<String> lines) {
        for (String line : lines) {
            model.addLine(line); // Thêm danh sách các dòng vào Model
        }
    }
}