package test1.bai3;

public class Square {
    public float canh;

    public Square(){
        this.canh=5.0f;
    }

    public void doDaiCanh(){
        System.out.println("Canh hình vuông dài: "+this.canh);
    }

    public void chuVi(){
        System.out.println("Chu vi hình vuông là: "+4*this.canh);
    }

    public void dienTich(){
        System.out.println("Diện tích hình vuông là: "+this.canh*this.canh);
    }

    public void inThongTin(){
        this.doDaiCanh();
        this.chuVi();
        this.dienTich();
    }
    public static void main(String[] args){
        Square square=new Square();
        square.inThongTin();
    }
}
