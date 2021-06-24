package sk.stuba.fei.uim.oop;

import java.awt.*;

public class MyTree extends Rectangle implements Shape {
    private final Color color;
    public MyTree(int x, int y, Color c){
        super(x-25,y-25,50,50);
        color = c;
    }
    public void paintTree(Graphics g){
        g.setColor(this.color);
        g.fillRect(this.x + this.width/3,this.y+this.height/3,this.width/3,2*this.height/3);
        g.fillOval(this.x,this.y,this.width,2*this.height/3);
    }
}
