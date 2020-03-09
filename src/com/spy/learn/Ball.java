package com.spy.learn;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;

public class Ball {
    private static final int XSIZE=15;
    private static final int YSIZE=15;
    private double x=0;
    private double y=0;
    private double dx=1;
    private double dy=1;
    public Ball(){

        Random r = new Random(450);
        x = r.nextInt();
        r=new Random(350);
        y = r.nextInt();
    }

    public void move(Rectangle2D bound) {
        x += dx;
        y += dy;
        if(x<bound.getMinX()){
            x=bound.getMinX();
            dx=-dx;
        }
        if(x+XSIZE>=bound.getMaxX()){
            x=bound.getMaxX()-XSIZE;
            dx=-dx;
        }
        if(y<bound.getMinY()){
            y=bound.getMinY();
            dy =-dy;
        }
        if(y+YSIZE>=bound.getMaxY()){
            y=bound.getMaxY()-YSIZE;
            dy=-dy;
        }
    }

    public Ellipse2D getShape(){
        return new Ellipse2D.Double(x,y,XSIZE,YSIZE);
    }
}
