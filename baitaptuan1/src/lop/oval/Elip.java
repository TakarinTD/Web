package lop.oval;

public class Elip extends Point {
    protected int a,c;

    public int getA () {
        return a;
    }

    public void setA (int a) {
        this.a = a;
    }


    public int getC () {
        return c;
    }

    public void setC (int c) {
        this.c = c;
    }

    protected void nhap(){
        System.out.print("Nhap tieu cu elip: ");
        this.setC(scanner.nextInt()/2);
        System.out.print("Nhap do dai elip: ");
        this.setA(scanner.nextInt()/2);
    }
    protected void xuat(){
        Point f1=new Point("F1",c,0);
        Point f2=new Point("F2",-c,0);
        System.out.println("Elip co do dai: "+(2*a));
        System.out.println("Elip co 2 tieu diem: ");
        f1.xuat();
        f2.xuat();
        System.out.println("Elip co tieu cu: "+2*c);
    }

}
