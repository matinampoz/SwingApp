package gr.aueb.elearn;


import javax.swing.*;
import java.awt.*;

public class MainApp extends JFrame {
    public MainApp() {
        setTitle("Main Application");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTabbedPane tabbedPane = new JTabbedPane();

        // Text Editor Tab
        tabbedPane.addTab("Text Editor", new TextEditorPanel());

        // Calculator Tab
        tabbedPane.addTab("Calculator", new CalculatorPanel());

        // Notes Manager Tab
        tabbedPane.addTab("Notes Manager", new NotesManagerPanel());

        add(tabbedPane);
    }
}
