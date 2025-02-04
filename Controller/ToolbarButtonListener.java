package note_app_project.Controller;

import note_app_project.View.NoteAppView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolbarButtonListener implements ActionListener {
    private NoteAppView nV;
    private String buttonName;
    private NoteListener nL;

    public ToolbarButtonListener(NoteAppView nV, String buttonName) {
        this.nV = nV;
        this.buttonName = buttonName;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        nV.areaTitle.setText(buttonName);
        nV.areaNote.setText(nV.noteTree.findNoteNodeByTitle(buttonName).getNote());
        nV.showRelation(buttonName, nV.noteTree.findNoteNodeByTitle(buttonName).getNote());
    }

}