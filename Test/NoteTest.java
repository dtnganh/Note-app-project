package note_app_project.Test;

import note_app_project.View.NoteAppView;

import javax.swing.*;

public class NoteTest {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            NoteAppView view2 = new NoteAppView();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
