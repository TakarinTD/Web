package lop.oval;

import java.util.*;

public class Point {
    protected int hoanhDo,tungDo;
    protected String name;
    Scanner scanner=new Scanner(System.in);

    public Point () {
    }

    public Point (String name,int hoanhDo,int tungDo) {
        this.name=name;
        this.hoanhDo=hoanhDo;
        this.tungDo = tungDo;
    }

    public int getHoanhDo () {
        return hoanhDo;
    }

    public void setHoanhDo (int hoanhDo) {
        this.hoanhDo = hoanhDo;
    }

    public int getTungDo () {
        return tungDo;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public void setTungDo (int tungDo) {
        this.tungDo = tungDo;
    }
    protected void nhap(){
        System.out.print("Nhap ten diem: ");
        this.name=scanner.nextLine();
        System.out.print("Nhap hoanh do: ");
        this.hoanhDo=scanner.nextInt();
        System.out.print("Nhap tung do: ");
        this.tungDo=scanner.nextInt();
    }
    protected void xuat(){
        System.out.println(this.name+"("+this.hoanhDo+","+this.tungDo+")");
    }
}

