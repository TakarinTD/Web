package lop.bai16;

import static java.lang.Math.*;

public class MyPoint {
    private int x, y;

    public MyPoint () {
        this.x = 0;
        this.y = 0;
    }

    public MyPoint (int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX () {
        return x;
    }

    public void setX (int x) {
        this.x = x;
    }

    public int getY () {
        return y;
    }

    public void setY (int y) {
        this.y = y;
    }

    public void setXY (int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString(){
        return "("+this.x+","+this.y+")";
    }

    public double distance(int x,int y){
        return sqrt(pow(this.x- x,2)+pow(this.y- y,2));
    }

    public double distance(MyPoint point1){
        return sqrt(pow(this.x- point1.x,2)+pow(this.y- point1.y,2));
    }
}
