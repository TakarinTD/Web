package lop.oval;

public class Cricle extends Elip {
    protected Point tam=new Point();
    protected void nhap(){
        System.out.println("Nhap tam duong tron: ");
        tam.nhap();
        System.out.println(("Nhp ban kinh duong tron: "));
        this.setA(scanner.nextInt()/2);
    }
    protected void xuat(){
        System.out.print("Duong tron tam: ");
        tam.xuat();
        System.out.println("Ban kinh: "+this.a);
    }
}
