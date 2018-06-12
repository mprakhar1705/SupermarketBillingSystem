import products.Product;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Admin {

    private static String csvfile = "shop.csv";
    private List<Product> allProducts ;


//    public static void main(String args[]) {
//        Admin a = new Admin();
//        Product p = new Product();
////        a.writeProduct();
////        a.writeProduct();
//
//        p.loadProducts();
//        //p.printProducts();
//        a.getProductList(p);
//
//        a.displayAll();
//        p = a.enterProductDetails();
//        a.addToList(p);
//        p = a.enterProductDetails();
//        a.addToList(p);
//        p = a.enterProductDetails();
//        a.addToList(p);
//
//        a.displayAll();
//        a.displaySpecial(22);
//        a.modifyProduct(44);
//        a.displayAll();
//        a.deleteProduct(33);
//        a.displayAll();
//        a.writeProduct();
//        //  a.createProduct();
//        //p.showProduct();
//
//    }

    public void getProductList(Product p)
    {
        //Product pp = new Product();
        allProducts = p.getListOfProducts();
    }

    public Product enterProductDetails() {

        Product p1 = new Product();
        Scanner in = new Scanner(System.in);

        System.out.println("Enter Product Number of the Product:  ");
        //int x = in.nextInt();
        p1.setProductNo(in.nextInt());

        System.out.println("Enter Name of the Product:  ");
        p1.setProductName(in.next());

        System.out.println("Enter Quantity of the Product:  ");
        p1.setQuantity(in.nextInt());

        System.out.println("Enter Price of the Product:  ");
        float price = in.nextFloat();
        p1.setPrice(price);

        System.out.println("Enter Discount of the Product:  ");
        float discount = in.nextFloat();
        p1.setDiscount(discount);

        float discountedprice = price * (1 - (discount/100));
        p1.setDiscountedPrice(discountedprice);


        return (p1);
    }

    void addToList(Product p1) {
        //Product pp = new Product();
        allProducts.add(p1);
    }


    void displayAll() {
        System.out.println("**********************************************");
        System.out.println("Displaying All Products");
        System.out.println("**********************************************");
        for (Product product : allProducts) {

            System.out.println(product.toString());
        }

    }

    void writeProduct() {
//        Product p1;
//        p1 = enterProductDetails();
//        allProducts.add(p1);

        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new FileOutputStream(new File(csvfile)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        writer.write("ProductNo,ProductName,Quantity,Price,Discount,DiscountedPrice");
        for (Product p1 : allProducts) {

            writer.write(p1.toCsvString());
        }


        writer.close();

        System.out.println("Products added to file ");


    }

    void displaySpecial(int pno) {
        System.out.println("**********************************************");
        System.out.println("Displaying Special Product");

        for (Product product : allProducts) {

            if (product.getProductNo() == pno) {
                System.out.println(product.toString());
                break;
            }
        }

    }

    void deleteProduct(int pno) {
        System.out.println("**********************************************");
        System.out.println("Deleting Product");
        for (Product product : allProducts) {

            if (product.getProductNo() == pno) {
                allProducts.remove(product);
                break;
            }
        }
    }

    void modifyProduct(int pno) {
        System.out.println("**********************************************");
        System.out.println("Modifying Product");
        int i;
        Product p1 = new Product();

        for (i = 0; i < allProducts.size(); i++) {

            if (allProducts.get(i).getProductNo() == pno) {
                p1 = enterProductDetails();
                break;
            }

        }

        allProducts.set(i, p1);
    }


}


