package note_app_project.Model;

public class Test {
    public static void main(String[] args) {
        NoteTree tree = new NoteTree("Root", "Root note");
        tree.addNote("Root", "Root note", "Child 1", "Child 1 note");
        tree.addNote("Root", "Root note", "Child 2", "Child 2 note");
        tree.addNote("Child 1", "Child 1 note", "Child 1.1", "Child 1.1 note");
        tree.addNote("Child 1", "Child 1 note", "Child 1.2", "Child 1.2 note");
        tree.addNote("Child 2", "Child 2 note", "Child 2.1", "Child 2.1 note");
        tree.addNote("Child 2", "Child 2 note", "Child 2.2", "Child 2.2 note");
        tree.addNote("Child 2", "Child 2 note", "Child 2.3", "Child 2.3 note");
        tree.addNote("Child 2.3", "Child 2.3 note", "Child 2.4", "Child 2.4 note");
        tree.addNote("Child 2", "Child 2 note", "Child 2.5", "Child 2.5 note");
        tree.addNote("Child 2", "Child 2 note", "Child 2.6", "Child 2.6 note");
        tree.addNote("Child 2", "Child 2 note", "Child 2.7", "Child 2.7 note");
        tree.addNote("Child 2", "Child 2 note", "Child 2.8", "Child 2.8 note");
        tree.addNote("Child 2", "Child 2 note", "Child 2.9", "Child 2.9 note");
        tree.addNote("Child 2", "Child 2 note", "Child 2.10", "Child 2.10 note");
        tree.addNote("Child 2", "Child 2 note", "Child 2.11", "Child 2.11 note");
        tree.addNote("Child 2", "Child 2 note", "Child 2.12", "Child 2.12 note");
        tree.addNote("Child 2", "Child 2 note", "Child 2.13", "Child 2.13 note");

        // In ra màn hình kết quả trên
        System.out.println("Tree:");
        System.out.println(tree.getRoot().getTitle());
        System.out.println(tree.getRoot().getNote());
        for (NoteNode child : tree.getRoot().getChildren()) {
            System.out.println("  " + child.getTitle());
            System.out.println("    " + child.getNote());
            for (NoteNode grandchild : child.getChildren()) {
                System.out.println("      " + grandchild.getTitle());
                System.out.println("        " + grandchild.getNote());
                for (NoteNode grandgrandchild : grandchild.getChildren()) {
                    System.out.println("          " + grandgrandchild.getTitle());
                    System.out.println("            " + grandgrandchild.getNote());
                }
            }
        }

        System.out.println("Size: " + tree.getRoot().getChildrenCount());

//        // Xóa ghi chú con
//        tree.removeNote("Child 2", "Child 2 note");
//        System.out.println("Tree:");
//        System.out.println(tree.getRoot().getTitle());
//        System.out.println(tree.getRoot().getNote());
//        for (NoteNode child : tree.getRoot().getChildren()) {
//            System.out.println("  " + child.getTitle());
//            System.out.println("    " + child.getNote());
//            for (NoteNode grandchild : child.getChildren()) {
//                System.out.println("      " + grandchild.getTitle());
//                System.out.println("        " + grandchild.getNote());
//            }
//        }

        System.out.println("Tìm ghi chú con");
        NoteNode found = tree.findNoteNode("Child 1", "Child 1 note", tree.getRoot());
        if (found != null) {
            System.out.println("Found: " + found.getTitle());
        } else {
            System.out.println("Not found");
        }

        System.out.println("Tìm ghi chú con theo tiêu đề");
        tree.findNoteNodeByTitle("Child 2.3");
//        System.out.println("Found: " + foundByTitle.getTitle());

        // Tìm các ghi chú con khi biết tiêu đề
        System.out.println("Tìm các ghi chú con khi biết tiêu đề");
        NoteNode[] children = tree.findAllChildren("Child 2");
        for (NoteNode child : children) {
            System.out.println(child.getTitle());
        }
        System.out.println("Size: " + children.length);

    }
}
