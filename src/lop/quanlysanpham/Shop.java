package lop.quanlysanpham;

import java.util.*;

public class Shop {
    Scanner scanner = new Scanner(System.in);
    private ArrayList<Product> productList = new ArrayList<Product>();

    public void addProduct () {
        Product product = new Product();
        product.inputInfo();
        productList.add(product);
    }

    public void addRate(){
        System.out.print("Name to rate: ");
        String nameSearch = scanner.nextLine();
        for (Product s : productList) {
            if (nameSearch.equals(s.getName())) {
                System.out.print("Rating level(1->5): ");
                int i=scanner.nextInt();
                s.inputRate(i);
                System.out.println("Thank for rating "+nameSearch);
            }else System.out.println(nameSearch+"is not exist");
        }
    }
    public void removeProduct () {
        System.out.print("Name to remove: ");
        String nameSearch = scanner.nextLine();
        boolean check = false;
        for (Product s : productList) {
            if (nameSearch.equals(s.getName())) {
                if (productList.size() > 1) {
                    productList.remove(s);
                } else productList = null;
                check = true;
            }
        }
        if(check)
            System.out.println("Removed "+nameSearch);
        else System.out.println(nameSearch+"is not exist");
    }

    public void iterateProductList () {
        int k = 1;
        if (productList.isEmpty()) System.out.println("Product list empty!");
        else {
            for (Product s : productList) {
                System.out.println("Product " + k);
                s.viewInfo();
                if(s.getRate().size()!=0) {
                    int tbDanhGia = 0;
                    for (int j = 0; j < s.getRate().size(); j++) {
                        tbDanhGia += s.getRate().get(j);
                    }
                    System.out.println(s.getName() + "'s rate: " + tbDanhGia / s.getRate().size());
                }
                k++;
            }
        }
    }

    public void searchProduct () {
        int x, y;
        System.out.println("Input the price range to search!");
        System.out.print("Bigger: ");
        x = scanner.nextInt();
        System.out.print("Less: ");
        y = scanner.nextInt();
        for (Product s : productList) {
            if (x <= s.getPrice() && s.getPrice() <= y) s.viewInfo();
        }
    }

    public void sortProduct () {
        Comparator<Product> product = new Comparator<Product>() {
            @Override
            public int compare (Product o1, Product o2) {
                if (o1.getPrice() > o2.getPrice()) {
                    return 1;
                } else return - 1;
            }

            @Override
            public boolean equals (Object obj) {
                return false;
            }
        };
        Collections.sort(productList, product);
    }
}
