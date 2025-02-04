package note_app_project.Model;

import java.io.*;

public class NoteTree implements Serializable {
    private NoteNode root;

    public NoteTree(String rootTitle, String rootNote) {
        this.root = new NoteNode(rootTitle, rootNote);
    }

    public NoteNode getRoot() {
        return root;
    }

    public void addRoot(String rootTitle, String rootNote) {
        this.root = new NoteNode(rootTitle, rootNote);
    }

    public void addNote(String parentTitle, String parentNote, String newTitle, String newNote) {
        NoteNode parentNode = findNoteNode(parentTitle, parentNote, root);
        if (parentNode != null) {
            NoteNode newNoteNode = new NoteNode(newTitle, newNote);
            parentNode.addChild(newNoteNode);
        } else {
            System.out.println("Parent note not found.");
        }
    }

    // Trả về danh sách con của ghi chú được tìm kếm qua title
    public NoteNode[] getChildren(String title) {
        NoteNode parentNode = findNoteNodeByTitle(title);
        if (parentNode != null) {
            NoteNode[] children = new NoteNode[parentNode.getChildrenCount()];
            for (int i = 0; i < children.length; i++) {
                children[i] = parentNode.getChild(i);
            }
            return children;
        } else {
            return null;
        }
    }

    public void removeNote(String titleToRemove, String noteToRemove) {
        NoteNode nodeToRemove = findNoteNode(titleToRemove, noteToRemove, root);
        if (nodeToRemove != null) {
            NoteNode parentNode = findParentNode(titleToRemove, noteToRemove, root);
            if (parentNode != null) {
                parentNode.removeChild(nodeToRemove);
            } else {
                System.out.println("Error: Root note cannot be removed.");
            }
        } else {
            System.out.println("Note not found.");
        }
    }

    public NoteNode findNoteNode(String title, String note, NoteNode node) {
        if (node != null && node.getTitle().equals(title) && node.getNote().equals(note)) {
            return node;
        } else {
            assert node != null;
            for (NoteNode child : node.getChildren()) {
                NoteNode found = findNoteNode(title, note, child);
                if (found != null) {
                    return found;
                }
            }
        }
        return null;
    }

    public NoteNode findParentNode(String title, String note, NoteNode node) {
        for (NoteNode child : node.getChildren()) {
            if (child.getTitle().equals(title) && child.getNote().equals(note)) {
                return node;
            } else {
                NoteNode found = findParentNode(title, note, child);
                if (found != null) {
                    return found;
                }
            }
        }
        return null;
    }

    // Tìm kiếm ghi chú theo tiêu đề và trả về NoteNode
//    public NoteNode findNoteNodeByTitle(String title) {
//        // Duyệt qua các ghi chú con của ghi chú gốc
//        if (root.getTitle().equals(title)) {
//            return root;
//        }
//        for (NoteNode child : root.getChildren()) {
//            // Nếu tiêu đề của ghi chú con bằng với tiêu đề cần tìm
//            if (child.getTitle().equals(title)) {
//                // Trả về ghi chú con
//                return child;
//            }
//        }
//        // Nếu không tìm thấy ghi chú nào có tiêu đề bằng với tiêu đề cần tìm
//        // thì trả về null
//        return null;
//    }

    public NoteNode findNoteNodeByTitle(String title) {
        return findNoteNodeByTitle(title, root);
    }

    private NoteNode findNoteNodeByTitle(String title, NoteNode node) {
        if (node != null) {
            System.out.println("Checking node: " + node.getTitle());
            if (node.getTitle().equals(title)) {
                System.out.println("Found node: " + node.getTitle());
                return node;
            } else {
                for (NoteNode child : node.getChildren()) {
                    System.out.println("Descending into child: " + child.getTitle());
                    NoteNode found = findNoteNodeByTitle(title, child);
                    if (found != null) {
                        return found;
                    }
                }
            }
        }
        System.out.println("Node not found: " + (node != null ? node.getTitle() : "null"));
        return null;
    }

    //Tìm kiếm tất cả các ghi chú con khi biết tiêu đề của ghi chú cha
    public NoteNode[] findAllChildren(String title) {
        NoteNode parentNode = findNoteNodeByTitle(title);
        if (parentNode != null) {
            NoteNode[] children = new NoteNode[parentNode.getChildrenCount()];
            for (int i = 0; i < children.length; i++) {
                children[i] = parentNode.getChild(i);
            }
            return children;
        } else {
            return null;
        }
    }
}
