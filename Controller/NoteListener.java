package note_app_project.Controller;

import note_app_project.View.NoteAppView;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class NoteListener implements ActionListener {
    private NoteAppView nV;
    public NoteListener(NoteAppView nV) {
        this.nV = nV;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String btn = e.getActionCommand();

        if (btn.equals("Add Note")) {
            String title = nV.areaTitle.getText();
            nV.showDialog(title);
            String content = nV.noteTree.findNoteNodeByTitle(nV.title1.getText()).getNote();

            JButton newButton = new JButton(title);
            newButton.addActionListener(new ToolbarButtonListener(nV, title));
            nV.toolBar2.add(newButton);
            nV.addNote(nV.title1.getText(), content);

            nV.getContentPane().revalidate();
            nV.getContentPane().repaint();

            nV.areaNote.setText("");
            nV.areaTitle.setText("");
            nV.areaNote.requestFocus();
        } else if (btn.equals("Delete Note")) {
            nV.deleteNote();
        }

        // set font
        if (e.getSource() == nV.cBSetFont) {
            nV.areaNote.setFont(new Font((String) nV.cBSetFont.getSelectedItem(), Font.PLAIN, nV.areaNote.getFont().getSize()));
        }

        // Set color
        if (e.getSource() == nV.fontColorButton) {
            JColorChooser colorChooser = new JColorChooser();

            Color color = colorChooser.showDialog(null, "Choose a color", Color.black);

            nV.areaNote.setForeground(color);
        }

        // Open files
        if (e.getSource() == nV.btOpen) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File("."));
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Text files", "txt");
            fileChooser.setFileFilter(filter);

            int responseBtPath = fileChooser.showOpenDialog(null);

            if (responseBtPath == JFileChooser.APPROVE_OPTION) {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                Scanner fileIn = null;

                try {
                    fileIn = new Scanner(file);
                    if (file.isFile()) {
                        while (fileIn.hasNextLine()) {
                            String line = fileIn.nextLine() + "\n";
                            nV.areaNote.append(line);
                        }
                    }
                } catch (FileNotFoundException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                } finally {
                    fileIn.close();
                }
            }
        }

        // Save filee
        if (e.getSource() == nV.btSave) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File("."));

            int responseBtPath = fileChooser.showSaveDialog(null);

            if (responseBtPath == JFileChooser.APPROVE_OPTION) {
                File file;
                PrintWriter fileOut = null;

                file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                try {
                    fileOut = new PrintWriter(file);
                    fileOut.println(nV.areaNote.getText());
                } catch (FileNotFoundException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                } finally {
                    fileOut.close();
                }
            }
        }
        // Show note chill
        if (e.getSource() == nV.btPath) {
            nV.areaTitle.setText("");
            nV.areaNote.setText("");
            nV.showRelation(nV.noteTree.getRoot().getTitle(), nV.noteTree.getRoot().getNote());
            nV.areaTitle.append(nV.noteTree.getRoot().getTitle());
            nV.areaNote.append(nV.noteTree.getRoot().getNote());
        }

        // Show dialog Note Chill
        if (e.getSource() == nV.dialogNoteChill) {
            nV.title1.setText("Note Chill");
            nV.dialog.dispose();
        }

        // Add image
        if(e.getSource() == nV.addImg) {
            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Image files", ImageIO.getReaderFileSuffixes());
            fileChooser.setFileFilter(filter);
            int response = fileChooser.showOpenDialog(null);
            if (response == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try {
                    nV.originalImageIcon = new ImageIcon(ImageIO.read(file)); // Save the original
                    Image scaledInstance = nV.originalImageIcon.getImage().getScaledInstance(nV.imageSlider.getValue(), nV.imageSlider.getValue(), Image.SCALE_SMOOTH);
                    nV.imageLabel.setIcon(new ImageIcon(scaledInstance));
                    nV.imageLabel.setSize(nV.imageSlider.getValue(), nV.imageSlider.getValue());
                    nV.getContentPane().revalidate();
                    nV.getContentPane().repaint();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }

        // Set size img
        if (e.getSource() == nV.setSzImg) {
            nV.showDialogSetSizeImage();
        }
    }
}
