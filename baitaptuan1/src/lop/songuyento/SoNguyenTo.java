package lop.songuyento;

import static java.lang.StrictMath.sqrt;

public class SoNguyenTo {
    private int a;

    public SoNguyenTo () {
    }

    public SoNguyenTo (int x) {
        if(isSoNguyenTo(x))
            this.a = x;
        else System.out.println(x+" không là số nguyên tố, không lưu trữ!");
    }

    public int getA () {
        return a;
    }

    public void setA (int x) {
        if(isSoNguyenTo(x))
            this.a = x;
        else System.out.println(x+" không là số nguyên tố, không set!");
    }

    public boolean isSoNguyenTo (int x) {
        if (x < 2) {
            return false;
        }
        int squareRoot = (int)sqrt(x);
        for (int i = 2; i <= squareRoot; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
    public int timSoNguyenToTiepTheo(){
        int i=this.getA()+1;
        while (!isSoNguyenTo(i)){
            i++;
        }
        return i;
    }

    public static void main (String[] args) {
        SoNguyenTo soNguyenTo=new SoNguyenTo(4);
        if(soNguyenTo.getA()!=0) {
            System.out.println("Số nguyên tố sau "+soNguyenTo.getA()+" là: "+soNguyenTo.timSoNguyenToTiepTheo());
        }
        soNguyenTo.setA(6);
        if(soNguyenTo.getA()!=0) {
            System.out.println("Số nguyên tố sau "+soNguyenTo.getA()+" là: "+soNguyenTo.timSoNguyenToTiepTheo());
        }
        soNguyenTo.setA(11);
        if(soNguyenTo.getA()!=0) {
            System.out.println("Số nguyên tố sau "+soNguyenTo.getA()+" là: "+soNguyenTo.timSoNguyenToTiepTheo());
        }
    }
}
