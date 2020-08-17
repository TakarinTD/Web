package lop.student;

import java.util.*;

public class Student {
    private char maSV[] = new char[8];
    private double diemTB;
    private int tuoi;
    private String lop;

    public Student () {
    }

    public Student (char[] maSV, double diemTB, int tuoi, String lop) {

        if (maSV.length == 8)
            this.maSV = maSV;
        else System.out.println("Mã sinh viên có 8 ký tự!");

        if (diemTB >= 0.0 && diemTB <= 10.0)
            this.diemTB = diemTB;
        else System.out.println("Điểm trung bình chỉ thuộc [0.0,10.0]!");

        if (tuoi >= 18)
            this.tuoi = tuoi;
        else System.out.println("Tuổi phải >=18!");

        if (lop.charAt(0) == 'A' || lop.charAt(0) == 'C')
            this.lop = lop;
        else System.out.println("Lớp phải bắt đầu bằng ký tự 'A' hoặc 'C'!");
    }

    public char[] getMaSV () {
        return maSV;
    }

    public void setMaSV (char[] maSV) {
        if (maSV.length == 8)
            this.maSV = maSV;
        else System.out.println("Mã sinh viên có 8 ký tự!");
    }

    public double getDiemTB () {
        return diemTB;
    }

    public void setDiemTB (double diemTB) {
        if (diemTB >= 0.0 && diemTB <= 10.0)
            this.diemTB = diemTB;
        else System.out.println("Điểm trung bình chỉ thuộc [0.0,10.0]!");
    }

    public int getTuoi () {
        return tuoi;
    }

    public void setTuoi (int tuoi) {
        if (tuoi >= 18)
            this.tuoi = tuoi;
        else System.out.println("Tuổi phải >=18!");
    }

    public String getLop () {
        return lop;
    }

    public void setLop (String lop) {
        if (lop.charAt(0) == 'A' || lop.charAt(0) == 'C')
            this.lop = lop;
        else System.out.println("Lớp phải bắt đầu bằng ký tự 'A' hoặc 'C'!");
    }

    public void inputInfo(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhập thông tin sinh viên: ");
        System.out.println("MSSV: ");

        char maSV[]=new char[8];
        for (int i=0;i<8;i++)
           maSV[i]=scanner.next().charAt(0);
        this.setMaSV(maSV);

        do {
            System.out.println("Điểm trung bình (thuộc [0.0,10.0],sai nhập lại): ");
            double diemTB = scanner.nextDouble();
        }while(diemTB<0.0||diemTB>10.0);
        this.setDiemTB(diemTB);

        do {
            System.out.println("Tuổi (>=18, sai nhập lại): ");
            int tuoi = scanner.nextInt();
        }while(tuoi<18);
        this.setTuoi(tuoi);

        do{
            System.out.println("Lớp (bắt đầu bằng 'A' hoặc 'C', sai nhập lại): ");
            String lop=scanner.nextLine();
        }while (lop.charAt(0)!='A'&&lop.charAt(0)!='C');

    }

    public void showInfo(){
        System.out.println("Thông tin sinh viên: ");
        System.out.println("MSSV: "+this.getMaSV());
        System.out.println("Điểm TB: "+this.getDiemTB());
        System.out.println("Tuổi: "+this.getTuoi());
        System.out.println("Lớp: "+this.getLop());
    }
    public void hocBong(){
        if(this.getDiemTB()>8.0) System.out.println("Được học bổng!");
        else System.out.println("Không được học bổng!");
    }
}
