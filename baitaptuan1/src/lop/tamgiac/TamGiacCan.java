package lop.tamgiac;

public class TamGiacCan extends TamGiac {

    protected void nhapTamGiac () {
        System.out.print("Nhap vi tri can: ");
        this.viTri = scanner.nextLine();
        System.out.println("Nhap 3 canh tam giac: ");
        switch (viTri) {
            case "A":
                this.setA(scanner.nextInt());
                this.setB(scanner.nextInt());
                this.setC(b);
                break;
            case "B":
                this.setA(scanner.nextInt());
                this.setB(scanner.nextInt());
                this.setC(a);
                break;
            case "C":
                this.setA(scanner.nextInt());
                this.setB(a);
                this.setC(scanner.nextInt());
                break;
            default:
                System.out.println("Vi tri can là A,B hoac C!");
                break;
        }
    }
    protected void xuatTamGiac(){
        if(this.b==this.c)
            System.out.println("Tam gia can tai A voi 2 canh ben dai: "+this.b+", canh day dai: "+this.a);
        else if(this.a==this.c)
            System.out.println("Tam gia can tai B voi 2 canh ben dai: "+this.c+", canh day dai: "+this.b);
        else
            System.out.println("Tam gia can tai C voi 2 canh ben dai: "+this.a+", canh day dai: "+this.c);
    }
}
