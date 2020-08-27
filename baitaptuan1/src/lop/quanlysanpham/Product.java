package lop.quanlysanpham;

import java.util.*;

public class Product {
    private String name,description;
    private double price;//0<price<=100
    private ArrayList<Integer> rate=new ArrayList<Integer>();// đánh giá từ 1-5
    Scanner scanner=new Scanner(System.in);


    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getDescription () {
        return description;
    }

    public void setDescription (String description) {
        this.description = description;
    }

    public double getPrice () {
        return price;
    }

    public void setPrice (double price) {
        this.price = price;
    }

    public ArrayList<Integer> getRate () {
        return rate;
    }

    public void setRate (ArrayList rate) {
        this.rate = rate;
    }

    public void inputInfo(){
        System.out.println("Input Info Product:");
        System.out.print("Name product: ");
        this.setName(scanner.nextLine());
        System.out.print("Price product: ");
        this.setPrice(scanner.nextDouble());
        scanner.nextLine();
        System.out.print("Description: ");
        this.setDescription(scanner.nextLine());
    }

    public void viewInfo(){
        System.out.println("Name product: "+this.name);
        System.out.println("Price product: "+this.price);
        System.out.println("Description: "+this.description);
    }

    public void inputRate(int x){
        this.rate.add(x);
    }
}
