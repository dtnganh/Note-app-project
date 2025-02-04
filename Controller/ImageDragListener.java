package note_app_project.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ImageDragListener extends MouseAdapter {
    private JLabel imageLabel;
    private Point initialClick;


    public ImageDragListener(JLabel imageLabel) {
        this.imageLabel = imageLabel;
    }

    @Override
    public void mousePressed(MouseEvent me) {
        initialClick = me.getPoint();
    }

    @Override
    public void mouseDragged(MouseEvent me) {
        Point location = imageLabel.getLocation();
        int x = location.x - initialClick.x + me.getX();
        int y = location.y - initialClick.y + me.getY();
        imageLabel.setLocation(x, y);
    }
}