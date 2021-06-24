package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class MyCanvas extends JPanel implements MouseListener, MouseMotionListener {

    private final MyJPanel panel;
    private final ArrayList<MyTree> myTreeArrayList = new ArrayList<>();
    private final ArrayList<MyHouse> myHouseArrayList = new ArrayList<>();
    public MyCanvas(MyJPanel panel){
        super();
        this.panel = panel;
        this.setFocusable(true);
        this.setVisible(true);
        addMouseListener(this);
        addMouseMotionListener(this);
    }




    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
