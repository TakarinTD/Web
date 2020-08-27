package lop.retangle;

import java.util.*;

public class Retangle {
    private int cd,cr;

    public int getCd () {
        return cd;
    }

    public void setCd (int cd) {
        this.cd = cd;
    }

    public int getCr () {
        return cr;
    }

    public void setCr (int cr) {
        this.cr = cr;
    }

    public void nhapCanh(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhập chiều dài, chiều rộng hình chữ nhật: ");
        this.setCd(scanner.nextInt());
        this.setCr(scanner.nextInt());
    }

    public int chuVi(){
        return this.getCd()+this.getCr();
    }

    public int dienTich(){
        return this.getCd()*this.getCr();
    }
}
