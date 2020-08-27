package lop.bai16;

public class MyCircle {
    private MyPoint tam;
    private int banKinh;

    public MyCircle (int x,int y, int banKinh) {
        this.tam = new MyPoint(x,y);
        this.banKinh = banKinh;
    }

    public MyCircle (MyPoint tam, int banKinh) {
        this.tam = tam;
        this.banKinh = banKinh;
    }

    public MyPoint getTam () {
        return tam;
    }

    public void setTam (MyPoint tam) {
        this.tam = tam;
    }

    public int getBanKinh () {
        return banKinh;
    }

    public void setBanKinh (int banKinh) {
        this.banKinh = banKinh;
    }

    public String toString(){
        return "Circle @("+tam.getX()+","+tam.getY()+") radius = "+this.banKinh;
    }
     public double getArea(){
        return Math.PI*Math.pow(this.banKinh,2);
     }
}
