import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main extends JFrame {
    private JTextArea textArea;

    public Main(Controller controller) {
        setTitle("Input file editor"); // Set the title of the window
        setSize(400, 300); // Set the size of the window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Define default close operation

        textArea = new JTextArea(); // Create a new JTextArea for displaying text
        JScrollPane scrollPane = new JScrollPane(textArea); // Add scroll functionality to the text area

        JButton saveButton = new JButton("Save to Output File"); // Create a button to save data to an output file
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    // Save data to the output file when the button is clicked
                    File outputFile = new File("/Users/manhhaucao/IdeaProjects/mvc_fix_error.1.4/src/output.txt");
                    controller.saveToFile(outputFile);
                    JOptionPane.showMessageDialog(Main.this, "Data saved to output.txt");
                } catch (IOException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(Main.this, "Error saving data");
                }
            }
        });

        add(scrollPane, BorderLayout.CENTER); // Add the text area with scroll functionality to the center of the frame
        add(saveButton, BorderLayout.SOUTH); // Add the save button to the bottom of the frame

        // Load data from the input file
        try {
            File inputFile = new File("/Users/manhhaucao/IdeaProjects/mvc_fix_error.1.4/src/input.txt");
            controller.loadFromFile(inputFile);
            displayLines(controller.getLines());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Display lines of text in the JTextArea
    public void displayLines(List<String> lines) {
        for (String line : lines) {
            textArea.append(line + "\n");
        }
    }

    public static void main(String[] args) {
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);

        // Create and show the main frame on the event dispatch thread
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Main frame = new Main(controller);
                frame.setVisible(true);
            }
        });
    }
}
