import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main extends JFrame {
    private JTextArea textArea;

    public Main(Controller controller) {
        setTitle("Simple File Processor");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);

        JButton saveButton = new JButton("Save to Output File");
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    File outputFile = new File("/Users/manhhaucao/IdeaProjects/mvc_fix_error.1.4/src/output.txt");
                    controller.saveToFile(outputFile);
                    JOptionPane.showMessageDialog(Main.this, "Data saved to output.txt");
                } catch (IOException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(Main.this, "Error saving data");
                }
            }
        });

        add(scrollPane, BorderLayout.CENTER);
        add(saveButton, BorderLayout.SOUTH);

        // Load data from input file
        try {
            File inputFile = new File("/Users/manhhaucao/IdeaProjects/mvc_fix_error.1.4/src/input.txt");
            controller.loadFromFile(inputFile);
            displayLines(controller.getLines());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void displayLines(List<String> lines) {
        for (String line : lines) {
            textArea.append(line + "\n");
        }
    }

    public static void main(String[] args) {
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Main frame = new Main(controller);
                frame.setVisible(true);
            }
        });
    }
}