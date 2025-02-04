package note_app_project.View;

import note_app_project.Controller.ImageDragListener;
import note_app_project.Controller.NoteListener;
import note_app_project.Model.NoteNode;
import note_app_project.Model.NoteTree;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class NoteAppView extends JFrame {
    public NoteAppView() {
        initComponents();
        this.setVisible(true);
    }

    private void initComponents() {
        this.setTitle("Note Chill");
        // Lấy kích thước màn hình
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        // Đặt kích thước của cửa sổ
        this.setSize(screenSize.width, screenSize.height);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Lấy font
        String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();

        //======== Khởi tạo ========
        pnHead = new JPanel();
        pnHeadLeft = new JPanel();
        btPath = new JButton();
        dialogNoteChill = new JButton("Note Chill");
        labelLocation = new JLabel();
        lRelation = new JLabel();
        labelSpace = new JLabel("  ");
        pnMenu = new JPanel();
        pnMenuTop = new JPanel();
        pnMenuBot = new JPanel();
        pnButton = new JPanel();
        btOpen = new JButton();
        btSave = new JButton();
        btAdd = new JButton();
        btDelete = new JButton();
        pnMain = new JPanel();
        toolBar1 = new JToolBar();
        toolBar2 = new JToolBar();
        addImg = new JButton();
        setSzImg = new JButton("Set size image");
        szImgDialog = new JDialog();
        lFontValue = new JLabel();
        comboBox2 = new JComboBox();
        lFontSize = new JLabel();
        spinner3 = new JSpinner();
        scrollPane1 = new JScrollPane();
        pnContentCenter = new JPanel();
        areaNote = new JTextArea();
        scrollPane3 = new JScrollPane();
        sPRelation = new JScrollPane();
        sPPath = new JScrollPane();
        areaTitle = new JTextArea();
        areaRelation = new JTextArea();
        fontColorButton = new JButton("Color");
        scrollPane2 = new JScrollPane();
        cBSetFont = new JComboBox(fonts);
        noteTree = new NoteTree("Note Chill", "This is root note!");
        dialog = new JDialog(this, "Select parent", true);

        // Thêm ảnh
        imageLabel = new JLabel();
        JPanel slidersPanel = new JPanel();
        imageSlider = new JSlider(JSlider.HORIZONTAL, 0, 1000, 400);

        // ActionListener
        ActionListener ac = new NoteListener(this);

        //----- showDialog -----
        panelDialog.setLayout(new FlowLayout(15,15,15));
        dialogNoteChill.addActionListener(ac);
        panelDialog.add(dialogNoteChill);


        //======== this ========
        setBackground(new Color(0xe0d9fb));
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout(10, 10));

        //======== pnHead ========
        {
            pnHead.setBackground(new Color(0xF4BD64));
            pnHead.setLayout(new GridLayout(2, 1, 5, 3));

            //---- labelLocation ----
            labelLocation.setText("Group 14: Note App Project");
            labelLocation.setFont(new Font("Segoe UI", Font.PLAIN, 16));
            labelLocation.setHorizontalAlignment(SwingConstants.CENTER);
            pnHead.add(labelLocation);

            //======== pnHeadLeft ========
            {
                pnHeadLeft.setLayout(new BorderLayout());

                //======== menuBar1 ========
                {

                    //---- btPath ----
                    btPath.setText("Note Chill");
                    btPath.addActionListener(ac);
                    toolBar2.add(btPath);
                    sPPath.setViewportView(toolBar2);
                }
                pnHeadLeft.add(toolBar2, BorderLayout.CENTER);
            }
            pnHead.add(pnHeadLeft);
        }
        contentPane.add(pnHead, BorderLayout.NORTH);

        //======== pnMenu ========
        {
            pnMenu.setBackground(new Color(0xCCCCFF));
            pnMenu.setLayout(new GridLayout(2, 1, 10, 10));

            //======== pnMenuTop ========
            {
                pnMenuTop.setBackground(new Color(0xCCCCFF));
                pnMenuTop.setLayout(new FlowLayout());

                //======== pnButton ========
                {
                    pnButton.setBackground(new Color(0xCCCCFF));
                    pnButton.setLayout(new GridLayout(4, 1, 5, 5));

                    //---- btOpen ----
                    btOpen.setText("Open ");
                    btOpen.setHorizontalAlignment(SwingConstants.LEADING);
                    btOpen.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                    btOpen.addActionListener(ac);
                    pnButton.add(btOpen);

                    //---- btSave ----
                    btSave.setText("Save ");
                    btSave.setHorizontalAlignment(SwingConstants.LEADING);
                    btSave.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                    btSave.addActionListener(ac);
                    pnButton.add(btSave);

                    //---- btAdd ----
                    btAdd.setText("Add Note");
                    btAdd.setHorizontalAlignment(SwingConstants.LEADING);
                    btAdd.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                    btAdd.addActionListener(ac);
                    pnButton.add(btAdd);


                    //---- btDelete ----
                    btDelete.setText("Delete Note");
                    btDelete.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                    btDelete.addActionListener(ac);
                    pnButton.add(btDelete);
                }
                pnMenuTop.add(pnButton);
            }
            //======== pnMenuBot ========
            {
                pnMenuBot.setBackground(new Color(0xccccff));
                pnMenuBot.setLayout(new BorderLayout());

                //======== lRelation ========
                {
                    lRelation.setText("Relationship");
                    lRelation.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                    lRelation.setHorizontalAlignment(SwingConstants.CENTER);
                    lRelation.setBackground(new Color(0xFFFFFF));
                }
                //======== sPRelation ========
                {
                    areaRelation.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                    sPRelation.setViewportView(areaRelation);
                }
                pnMenuBot.add(lRelation, BorderLayout.NORTH);
                pnMenuBot.add(sPRelation, BorderLayout.CENTER);
            }
            pnMenu.add(pnMenuTop);
            pnMenu.add(pnMenuBot);
        }
        contentPane.add(pnMenu, BorderLayout.WEST);


        //======== pnMain ========
        {
            pnMain.setLayout(new BorderLayout(0, 5));

            //======== toolBar1 ========
            {

                //---- addImg ----
                addImg.setText("Add image");
                addImg.setBackground(new Color(0xccccff));
                addImg.addActionListener(ac);
                toolBar1.add(addImg);

                //----- Space -----
                toolBar1.add(labelSpace);

                //---- lSizeImg ----
                setSzImg.addActionListener(ac);
                setSzImg.setBackground(new Color(0xccccff));
                toolBar1.add(setSzImg);


                //---- lFontValue ----
                lFontValue.setText("        Font  ");
                toolBar1.add(lFontValue);
                toolBar1.add(cBSetFont);
                cBSetFont.addActionListener(ac);
                cBSetFont.setSelectedItem("Arial");

                //----- Space -----
                toolBar1.add(new JLabel("   "));

                //---- fontColorButton ----
                fontColorButton.setBackground(new Color(0xF4BD64));
                toolBar1.add(fontColorButton);
                fontColorButton.addActionListener(ac);


                //---- lFontSize ----
                lFontSize.setText("        Font size  ");
                toolBar1.add(lFontSize);
                //
                toolBar1.add(spinner3);
                spinner3.setPreferredSize(new Dimension(50, 25));
                spinner3.setValue(20);
                spinner3.addChangeListener(new ChangeListener() {

                    @Override
                    public void stateChanged(ChangeEvent e) {

                        areaNote.setFont(new Font(areaNote.getFont().getFamily(), Font.PLAIN, (int) spinner3.getValue()));
                    }

                });
            }
            pnMain.add(toolBar1, BorderLayout.NORTH);

            //======== pnContentCenter ========
            {
                pnContentCenter.setLayout(new BorderLayout(10,10));
                //======== scrollPane1 ========
                {
                    //---- areaNote ----
                    areaNote.setText("Enter the content to note ...");
                    areaNote.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                    areaNote.setLineWrap(true);
                    scrollPane1.setViewportView(areaNote);
                    imageLabel.setBounds(50, 50, 100, 100); // Set the initial position and size of the imageLabel
                    areaNote.add(imageLabel);
                    ImageDragListener listener = new ImageDragListener(imageLabel);
                    imageLabel.addMouseListener(listener);
                    imageLabel.addMouseMotionListener(listener);
                }
                //======== scrollPane3 ========
                {
                    //---- areaTitle ----
                    areaTitle.setText("Enter the title ...");
                    areaTitle.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                    areaTitle.setLineWrap(true);
                    scrollPane3.setViewportView(areaTitle);
                    scrollPane3.setViewportView(areaTitle);
                }
            }
            pnContentCenter.add(scrollPane3, BorderLayout.NORTH);
            pnContentCenter.add(scrollPane1, BorderLayout.CENTER);
            pnMain.add(pnContentCenter, BorderLayout.CENTER);
        }
        contentPane.add(pnMain, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());

        //Add img
        imageSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (originalImageIcon != null && imageSlider.getValue() != 0) {
                    int currentHeight = imageLabel.getHeight();
                    Image widthImage = originalImageIcon.getImage().getScaledInstance(imageSlider.getValue(), imageSlider.getValue(), Image.SCALE_SMOOTH);
                    imageLabel.setIcon(new ImageIcon(widthImage));
                    imageLabel.setSize(imageSlider.getValue(), imageSlider.getValue());
                }
            }
        });
    }

    public JPanel pnHead;
    public JPanel pnHeadLeft;
    public JButton btPath;
    public JButton dialogNoteChill;
    public JLabel labelLocation;
    public JPanel pnMenu;
    public JPanel pnMenuTop;
    public JPanel pnMenuBot;
    public JPanel pnButton;
    public JButton btOpen;
    public JButton btSave;
    public JButton btAdd;
    public JButton btDelete;
    public JPanel pnMain;
    public JToolBar toolBar1;
    public JToolBar toolBar2;
    public JButton addImg;
    public JButton setSzImg;
    public JDialog szImgDialog;
    public JLabel lFontValue;
    public JLabel labelSpace;
    public JComboBox comboBox2;
    public JLabel lFontSize;
    public JLabel lRelation;
    public JSpinner spinner3;
    public JScrollPane scrollPane1;
    public JScrollPane sPPath;
    public JPanel pnContentCenter;
    public JTextArea areaNote;
    public JScrollPane scrollPane3;
    public JTextArea areaTitle;
    public JTextArea areaRelation;
    public JButton fontColorButton;
    public JScrollPane scrollPane2;
    public JScrollPane sPRelation;
    public JComboBox cBSetFont;
    public NoteNode noteNode;
    public NoteTree noteTree;
    public JDialog dialog;
    public JDialog dialog2;
    public JPanel panelDialog = new JPanel();
    public JLabel title1 = new JLabel("Note Chill");

    //Thêm ảnh
    public JLabel imageLabel; // new line
    public ImageIcon originalImageIcon;
    public JSlider imageSlider;


    // Add note
    public void addNote(String noteParentTitle, String noteParentNote) {
        String title = areaTitle.getText();
        String noteValue = areaNote.getText();
        noteNode = new NoteNode(title, noteValue);
        noteTree.addNote(
                noteParentTitle,
                noteParentNote,
                title,
                noteValue
        );
    }

    public void showDialog(String title) {
        dialog.setSize(300, 200);
        dialog.setLocationRelativeTo(null);


        JButton jButton = new JButton(title);
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                title1.setText(jButton.getText());
                dialog.dispose();
            }
        });

        panelDialog.add(jButton);
        dialog.add(panelDialog);
        dialog.pack();
        dialog.setVisible(true);
    }

    // Dialog set size image
    public void showDialogSetSizeImage() {
        szImgDialog.setSize(800, 100);
        szImgDialog.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        imageSlider.setMajorTickSpacing(100);
        imageSlider.setMinorTickSpacing(10);
        imageSlider.setPaintTicks(true);
        imageSlider.setPaintLabels(true);

        panel.add(imageSlider);
        szImgDialog.add(panel);

        szImgDialog.setVisible(true);
    }

    // Hiển thị toàn bộ cây ghi chú trên areaRelation
    public void showRelation(String title, String note) {
        NoteNode noteNode = noteTree.findNoteNodeByTitle(title);
        for (int i = 0; i < noteNode.getChildrenCount(); i++) {
            areaRelation.setText("Parent: " + noteNode.getTitle() + "\n");
            for (int j = 0; j < noteNode.getChildrenCount(); j++) {
                areaRelation.append("Child " + (j + 1) + ": " +
                        noteNode.getChild(j).getTitle() + "\n");
            }
        }
        getContentPane().revalidate();
        getContentPane().repaint();
    }


    // Delete note
    public void deleteNote() {
        dialog2 = new JDialog(this, "Select item", true);
        dialog2.setSize(300, 200);
        dialog2.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(15, 15, 15));

        Component[] componentsTB = toolBar2.getComponents();
        Component[] componentsPD = panelDialog.getComponents();
        JButton[] newButtons = new JButton[componentsTB.length];

        for (int i = 0; i < componentsTB.length; i++) {
            JButton oldButton1 = (JButton) componentsTB[i];
            JButton oldButton2 = (JButton) componentsPD[i];
            JButton newButton = new JButton(oldButton1.getText());

            newButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Check if the source is the newButton
                    if (e.getSource() == newButton) {
                        noteTree.findAllChildren(newButton.getText());
                        for (NoteNode noteNode : noteTree.findAllChildren(newButton.getText())) {
                            for (int j = 0; j < componentsPD.length; j++) {
                                if (componentsTB[j] instanceof JButton) {
                                    JButton button = (JButton) componentsTB[j];
                                    JButton button2 = (JButton) componentsPD[j];
                                    if (button.getText().equals(noteNode.getTitle()) || button2.getText().equals(noteNode.getTitle())) {
                                        toolBar2.remove(button);
                                        panelDialog.remove(button2);
                                        panel.remove(button);
                                    }
                                }
                            }
                        }

                        noteTree.removeNote(
                                newButton.getText(),
                                noteTree.findNoteNodeByTitle(newButton.getText()).getNote()
                        );
                        toolBar2.remove(oldButton1);
                        panelDialog.remove(oldButton2);
                        panel.remove(newButton);

                        dialog2.dispose();
                        getContentPane().revalidate();
                        getContentPane().repaint();
                    }
                }
            });

            panel.add(newButton);
            newButtons[i] = newButton;
        }

        dialog2.add(panel);
        dialog2.pack();
        dialog2.setVisible(true);
    }

}