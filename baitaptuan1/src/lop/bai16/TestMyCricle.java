package lop.bai16;

public class TestMyCricle {
    public static void main (String[] args) {
        MyPoint myPoint=new MyPoint(3,4);
        MyCircle myCircle1=new MyCircle(myPoint,4);
        MyCircle myCircle2=new MyCircle(1,1,2);
        System.out.println(myCircle1.toString()+" S = "+myCircle1.getArea());
        System.out.println(myCircle2.toString()+" S = "+myCircle2.getArea());
    }
}
