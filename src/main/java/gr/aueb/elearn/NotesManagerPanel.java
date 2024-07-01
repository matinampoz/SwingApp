package gr.aueb.elearn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class NotesManagerPanel extends JPanel {
    private DefaultListModel<String> notesModel;
    private JList<String> notesList;
    private JTextArea noteTextArea;
    private JButton addButton;
    private JButton deleteButton;

    public NotesManagerPanel() {
        setLayout(new BorderLayout());

        notesModel = new DefaultListModel<>();
        notesList = new JList<>(notesModel);
        noteTextArea = new JTextArea();
        addButton = new JButton("Add Note");
        deleteButton = new JButton("Delete Note");

        notesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        notesList.addListSelectionListener(e -> displaySelectedNote());

        add(new JScrollPane(notesList), BorderLayout.WEST);
        add(new JScrollPane(noteTextArea), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2));
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        add(buttonPanel, BorderLayout.SOUTH);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNote();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteNote();
            }
        });
    }

    private void displaySelectedNote() {
        int selectedIndex = notesList.getSelectedIndex();
        if (selectedIndex >= 0) {
            noteTextArea.setText(notesModel.get(selectedIndex));
        } else {
            noteTextArea.setText("");
        }
    }

    private void addNote() {
        String note = noteTextArea.getText();
        if (!note.isEmpty()) {
            notesModel.addElement(note);
            noteTextArea.setText("");
        }
    }

    private void deleteNote() {
        int selectedIndex = notesList.getSelectedIndex();
        if (selectedIndex >= 0) {
            notesModel.remove(selectedIndex);
        }
    }
}
