package sk.stuba.fei.uim.oop;

import lombok.Getter;
import lombok.Setter;

import java.awt.*;
@Getter
@Setter
public class MyLine{
    private final Color color = Color.BLACK;
    private int x1,x2,y1,y2;
    public MyLine(int x1, int y1, int x2, int y2){
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }
    public void paintLine(Graphics g){
        g.setColor(color);
        g.drawLine(this.x1,this.y1,this.x2,this.y2);
    }
}
