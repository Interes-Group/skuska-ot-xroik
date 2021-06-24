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
    private MyLine currentLine;
    private int posx;
    private int posy;
    private boolean clickedOnObject = false;
    private String clickedObjectType;
    private int coordsOfClickedObjectX1 = 0;
    private int coordsOfClickedObjectY1 = 0;
    public MyCanvas(MyJPanel panel){
        super();
        this.panel = panel;
        this.setFocusable(true);
        this.setVisible(true);
        addMouseListener(this);
        addMouseMotionListener(this);
    }
    public void switchColor(){
        switch (panel.getCounter()) {
            case 0:
                panel.setC(Color.RED);
                panel.setCounter(panel.getCounter()+1);
                break;
            case 1:
                panel.setC(Color.BLUE);
                panel.setCounter(panel.getCounter()+1);
                break;
            case 2:
                panel.setC(Color.MAGENTA);
                panel.setCounter(0);
                break;
        }
        panel.getJLtext().setBackground(panel.getC());
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
        for(MyLine line : myLineArrayList){
            line.paintLine(g);
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
        switchColor();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(panel.isLineClicked()){
            for(MyTree tree : myTreeArrayList){
                if(tree.contains(e.getX(),e.getY())){
                    clickedOnObject = true;
                    clickedObjectType = "Tree";
                    coordsOfClickedObjectX1 = (int)tree.getX()+25;
                    coordsOfClickedObjectY1 = (int)tree.getY()+25;
                    currentLine = new MyLine(coordsOfClickedObjectX1,coordsOfClickedObjectY1,e.getX(),e.getY());
                    myLineArrayList.add(currentLine);
                }
            }
            for(MyHouse house : myHouseArrayList){
                if(house.contains(e.getX(),e.getY())){
                    clickedOnObject = true;
                    clickedObjectType ="House";
                    coordsOfClickedObjectX1 = (int)house.getX()+25;
                    coordsOfClickedObjectY1 = (int)house.getY()+25;
                    currentLine = new MyLine(coordsOfClickedObjectX1,coordsOfClickedObjectY1,e.getX(),e.getY());
                    myLineArrayList.add(currentLine);
                }
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(panel.isLineClicked()){
            if(clickedOnObject){
                if(clickedObjectType.equals("Tree")){
                    boolean clickedOnHouse = false;
                    for (MyHouse house : myHouseArrayList){
                        if(house.contains(e.getX(),e.getY())){
                            clickedOnHouse = true;
                            currentLine.setX2((int)house.getX()+25);
                            currentLine.setY2((int)house.getY()+25);
                        }
                    }
                    if(!clickedOnHouse){
                        myLineArrayList.remove(currentLine);
                    }
                }
                else if(clickedObjectType.equals("House")){
                    boolean clickedOnTree = false;
                    for(MyTree tree: myTreeArrayList){
                        if(tree.contains(e.getX(),e.getY())){
                            clickedOnTree = true;
                            currentLine.setX2((int)tree.getX()+25);
                            currentLine.setY2((int)tree.getY()+25);
                        }
                    }
                    if(!clickedOnTree){
                        myLineArrayList.remove(currentLine);
                    }
                }
            }
        }
        coordsOfClickedObjectX1 = 0;
        coordsOfClickedObjectY1 = 0;
        clickedOnObject = false;
        clickedObjectType = "Reset";
        repaint();
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
            currentLine.setX2(dx);
            currentLine.setY2(dy);
            repaint();
        }
        for(MyHouse house : myHouseArrayList){
            if(house.contains(e.getX(),e.getY())){
                System.out.print("On House");
            }
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
