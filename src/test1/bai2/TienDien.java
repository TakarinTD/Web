package test1.bai2;

import java.util.Scanner;

public class TienDien {
    public static void main(String[] args){
        Scanner scanner =new Scanner(System.in);
        int soDien,tienDien;
        do {
            System.out.println("Nhập số điện (số điện không âm): ");
            soDien = scanner.nextInt();
        }while(soDien<0);
        if(soDien<25){
            tienDien=soDien*1000;
        } else if(soDien<75){
            tienDien=25*1000+(soDien-25)*1250;
        }
        else if(soDien<150){
            tienDien=25*1000+50*1250+(soDien-75)*1800;
        }
        else {
            tienDien=25*1000+50*1250+75*1800+(soDien-150)*2500;
        }
        System.out.println("Tiền điện: "+tienDien+"vnd");
    }
}
