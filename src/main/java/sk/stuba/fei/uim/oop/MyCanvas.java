package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class MyCanvas extends JPanel implements MouseListener, MouseMotionListener {

    private final MyJPanel panel;
    private final ArrayList<MyTree> myTreeArrayList = new ArrayList<>();
    private MyTree currentTree;
    private final ArrayList<MyHouse> myHouseArrayList = new ArrayList<>();
    private MyHouse currentHouse;
    private final ArrayList<MyLine> myLineArrayList = new ArrayList<>();
    private int posx;
    private int posy;
    private boolean clickedOnObject = false;
    private int clickedObjectIndex;
    public MyCanvas(MyJPanel panel){
        super();
        this.panel = panel;
        this.setFocusable(true);
        this.setVisible(true);
        addMouseListener(this);
        addMouseMotionListener(this);
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        for(MyTree tree : myTreeArrayList){
            tree.paintTree(g);
        }
        for(MyHouse house : myHouseArrayList){
            house.paintHouse(g);
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.print("MouseClicked");
        posx = e.getX();
        posy = e.getY();
        if(panel.isTreeClicked()){
            currentTree = new MyTree(posx, posy,panel.getC());
            myTreeArrayList.add(currentTree);
        }
        else if(panel.isHouseClicked()){
            currentHouse = new MyHouse(posx,posy,panel.getC());
            myHouseArrayList.add(currentHouse);

        }
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(panel.isLineClicked()){
            int counter = 0;
            for(MyTree tree : myTreeArrayList){
                if(tree.contains(e.getX(),e.getY())){
                    clickedOnObject = true;
                    clickedObjectIndex = counter;
                }
            }
        }
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
        int dx = e.getX();
        int dy = e.getY();
        if(panel.isLineClicked() && clickedOnObject){

        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
