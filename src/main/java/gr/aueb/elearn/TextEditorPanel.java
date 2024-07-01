package gr.aueb.elearn;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class TextEditorPanel extends JPanel {
    private JTextArea textArea;
    private JButton saveButton;

    public TextEditorPanel() {
        setLayout(new BorderLayout());

        textArea = new JTextArea();
        saveButton = new JButton("Save");

        add(new JScrollPane(textArea), BorderLayout.CENTER);
        add(saveButton, BorderLayout.SOUTH);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveTextToFile();
            }
        });
    }

    private void saveTextToFile() {
        JFileChooser fileChooser = new JFileChooser();
        int option = fileChooser.showSaveDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write(textArea.getText());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}

