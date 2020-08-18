package lop.tamgiac;

import static java.lang.Math.*;

public class TamGiacVuong extends TamGiac {
    protected void nhapTamGiac () {
        System.out.print("Nhap vi tri vuong: ");
        this.viTri = scanner.nextLine();
        System.out.println("Nhap 2 canh goc vuong: ");
        switch (viTri) {
            case "A":
                this.setB(scanner.nextInt());
                this.setC(scanner.nextInt());
                this.a=(int)sqrt(pow(this.b,2)+pow(this.c,2));
                break;
            case "B":
                this.setA(scanner.nextInt());
                this.setC(scanner.nextInt());
                this.b=(int)sqrt(pow(this.a,2)+pow(this.c,2));
                break;
            case "C":
                this.setA(scanner.nextInt());
                this.setB(scanner.nextInt());
                this.c=(int)sqrt(pow(this.b,2)+pow(this.a,2));
                break;
            default:
                System.out.println("Vi tri vuong là A,B hoac C!");
                break;
        }
    }
    protected void xuatTamGiac(){
        if(this.viTri.equals("A")) {
            System.out.println("Tam gia vuong tai A voi 2 canh goc vuong la: " + this.b + " " + this.c + ", canh day la: " + this.a);
        }
        else if(this.viTri.equals("B")){
            System.out.println("Tam gia vuong tai B voi 2 canh goc vuong la: "+this.a+" "+this.c+", canh day la: "+this.b);
        }
        else
            System.out.println("Tam gia vuong tai C voi 2 canh goc vuong la: "+this.a+" "+this.b+", canh day la: "+this.c);
    }
}
