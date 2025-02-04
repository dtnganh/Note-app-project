package note_app_project.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class NoteNode implements Serializable {
    private String title;
    private String note;
    private List<NoteNode> children;

    public NoteNode(String title, String note) {
        this.title = title;
        this.note = note;
        this.children = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public String getNote() {
        return note; //
    }

    public List<NoteNode> getChildren() {
        return children; // Trả về danh sách các ghi chú con
    }

    public int getChildrenCount() {
        return children.size(); // Trả về số lượng ghi chú con
    }

    public void addChild(NoteNode childNode) {
        children.add(childNode);
    }

    public void removeChild(NoteNode childNode) {
        children.remove(childNode);
    }

    public NoteNode getChild(int i) {
        return children.get(i);
    }

}
