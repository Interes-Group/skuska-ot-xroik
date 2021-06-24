package sk.stuba.fei.uim.oop;

import java.awt.*;

public class MyHouse extends Rectangle implements Shape{
    private final Color color;
    public MyHouse(int x, int y, Color c){
        super(x-25,y-25,50,50);
        color = c;
    }
    public void paintHouse(Graphics g){
        g.setColor(this.color);
        int x[] = {this.x+12,this.x+25,this.x+37};
        int y[] = {this.y+24,this.y,this.y+24};
        g.fillPolygon(x,y,3); //left-bottom : (xpos - -12,ypos)
                                     //middle-top : (xpos, ypos-24)
                                     //right-bottom : (xpos+12, ypos)
        g.fillRect(this.x+12,this.y+24,25,25);
    }
}
