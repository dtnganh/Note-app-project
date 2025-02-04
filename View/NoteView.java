package note_app_project.View;


import java.awt.*;
import javax.swing.*;


public class NoteView extends JFrame {
    public NoteView() {
        initComponents();
        this.setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Nguyen DInh Duy
        pnHead = new JPanel();
        pnHeadLeft = new JPanel();
        menuBar1 = new JMenuBar();
        btPath = new JButton();
        labelLocation = new JLabel();
        pnMenu = new JPanel();
        pnMenuTop = new JPanel();
        pnButton = new JPanel();
        btOpen = new JButton();
        btSave = new JButton();
        btAdd = new JButton();
        btAddImg = new JButton();
        btDelete = new JButton();
        pnMain = new JPanel();
        toolBar1 = new JToolBar();
        addImg = new JButton();
        lSizeImg = new JLabel();
        spinner1 = new JSpinner();
        lFontValue = new JLabel();
        comboBox2 = new JComboBox();
        lFontSize = new JLabel();
        spinner3 = new JSpinner();
        scrollPane1 = new JScrollPane();
        pnContentCenter = new JPanel();
        areaNote = new JTextArea();
        scrollPane3 = new JScrollPane();
        areaTitle = new JTextArea();

        //======== this ========
        setBackground(new Color(0xe0d9fb));
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout(10, 10));

        //======== pnHead ========
        {
            pnHead.setBackground(new Color(0xf46481));
            pnHead.setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing. border .EmptyBorder ( 0
            , 0 ,0 , 0) ,  "JF\u006frmDes\u0069gner \u0045valua\u0074ion" , javax. swing .border . TitledBorder. CENTER ,javax . swing. border .TitledBorder . BOTTOM
            , new Font ( "D\u0069alog", Font. BOLD ,12 ) ,Color .red ) ,
            pnHead. getBorder () ) ); pnHead. addPropertyChangeListener( new java. beans .PropertyChangeListener ( ){ @Override public void propertyChange (java . beans. PropertyChangeEvent e
            ) { if( "\u0062order" .equals ( e. getPropertyName () ) )throw new RuntimeException( ) ;} } );
            pnHead.setLayout(new GridLayout(1, 2, 5, 0));

            //======== pnHeadLeft ========
            {
                pnHeadLeft.setLayout(new BorderLayout());

                //======== menuBar1 ========
                {

                    //---- btPath ----
                    btPath.setText("Note Chill");
                    menuBar1.add(btPath);
                }
                pnHeadLeft.add(menuBar1, BorderLayout.CENTER);
            }
            pnHead.add(pnHeadLeft);

            //---- labelLocation ----
            labelLocation.setText("Group 14: Note App Project");
            labelLocation.setFont(new Font("Segoe UI", Font.PLAIN, 16));
            labelLocation.setHorizontalAlignment(SwingConstants.CENTER);
            pnHead.add(labelLocation);
        }
        contentPane.add(pnHead, BorderLayout.NORTH);

        //======== pnMenu ========
        {
            pnMenu.setBackground(new Color(0xccccff));
            pnMenu.setLayout(new GridLayout(2, 1, 10, 10));

            //======== pnMenuTop ========
            {
                pnMenuTop.setBackground(new Color(0xccccff));
                pnMenuTop.setLayout(new FlowLayout());

                //======== pnButton ========
                {
                    pnButton.setBackground(new Color(0xccccff));
                    pnButton.setLayout(new GridLayout(5, 1, 5, 5));

                    //---- btOpen ----
                    btOpen.setText("Open ");
                    btOpen.setHorizontalAlignment(SwingConstants.LEADING);
                    btOpen.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                    pnButton.add(btOpen);

                    //---- btSave ----
                    btSave.setText("Save ");
                    btSave.setHorizontalAlignment(SwingConstants.LEADING);
                    btSave.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                    pnButton.add(btSave);

                    //---- btAdd ----
                    btAdd.setText("Add Page");
                    btAdd.setHorizontalAlignment(SwingConstants.LEADING);
                    btAdd.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                    pnButton.add(btAdd);

                    //---- btAddImg ----
                    btAddImg.setText("Add Note");
                    btAddImg.setHorizontalAlignment(SwingConstants.LEADING);
                    btAddImg.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                    pnButton.add(btAddImg);

                    //---- btDelete ----
                    btDelete.setText("Delete Note");
                    btDelete.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                    pnButton.add(btDelete);
                }
                pnMenuTop.add(pnButton);
            }
            pnMenu.add(pnMenuTop);
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
                toolBar1.add(addImg);

                //---- lSizeImg ----
                lSizeImg.setText("        Size  ");
                toolBar1.add(lSizeImg);
                toolBar1.add(spinner1);

                //---- lFontValue ----
                lFontValue.setText("        Font  ");
                toolBar1.add(lFontValue);
                toolBar1.add(comboBox2);

                //---- lFontSize ----
                lFontSize.setText("        Font size  ");
                toolBar1.add(lFontSize);
                toolBar1.add(spinner3);
            }
            pnMain.add(toolBar1, BorderLayout.NORTH);

            //======== scrollPane1 ========
            {

                //======== pnContentCenter ========
                {
                    pnContentCenter.setLayout(new BorderLayout());

                    //---- areaNote ----
                    areaNote.setText("Enter the content to note ...");
                    areaNote.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                    pnContentCenter.add(areaNote, BorderLayout.CENTER);

                    //======== scrollPane3 ========
                    {

                        //---- areaTitle ----
                        areaTitle.setText("Enter the title");
                        scrollPane3.setViewportView(areaTitle);
                    }
                    pnContentCenter.add(scrollPane3, BorderLayout.NORTH);
                }
                scrollPane1.setViewportView(pnContentCenter);
            }
            pnMain.add(scrollPane1, BorderLayout.CENTER);
        }
        contentPane.add(pnMain, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Nguyen DInh Duy
    private JPanel pnHead;
    private JPanel pnHeadLeft;
    private JMenuBar menuBar1;
    private JButton btPath;
    private JLabel labelLocation;
    private JPanel pnMenu;
    private JPanel pnMenuTop;
    private JPanel pnButton;
    private JButton btOpen;
    private JButton btSave;
    private JButton btAdd;
    private JButton btAddImg;
    private JButton btDelete;
    private JPanel pnMain;
    private JToolBar toolBar1;
    private JButton addImg;
    private JLabel lSizeImg;
    private JSpinner spinner1;
    private JLabel lFontValue;
    private JComboBox comboBox2;
    private JLabel lFontSize;
    private JSpinner spinner3;
    private JScrollPane scrollPane1;
    private JPanel pnContentCenter;
    private JTextArea areaNote;
    private JScrollPane scrollPane3;
    private JTextArea areaTitle;

    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
