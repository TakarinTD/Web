package lop.quanlysanpham;

import java.util.*;

public class Menu {
    public static void main (String[] args) {
        Scanner scanner=new Scanner(System.in);
        Shop shop=new Shop();
        String choose = null;
        boolean exit=false;
        Menu();
        while (true) {
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    shop.addProduct();
                    break;
                case "2":
                    //scanner.nextLine();
                    shop.removeProduct();
                    break;
                case "3":
                    shop.iterateProductList();
                    break;
                case "4":
                    shop.searchProduct();
                    break;
                case "5":
                    shop.sortProduct();
                    shop.iterateProductList();
                    break;
                case "6":
                    shop.addRate();
                    break;
                case "7":
                    System.out.println("exited!");
                    exit = true;
                    break;
                default:
                    System.out.println("invalid! please choose action in below menu:");
                    break;
            }
            if (exit) break;
            Menu();
        }
    }

    public static void Menu () {
        System.out.println("Select an option!");
        System.out.println("1-Add new product");
        System.out.println("2-Remove product");
        System.out.println("3-Iterate product list");
        System.out.println("4-Search product");
        System.out.println("5-Sort product list by price");
        System.out.println("6-Rating");
        System.out.println("7-Exit");
    }
}
