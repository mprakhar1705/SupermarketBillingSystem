import products.Product;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Admin {

    private static String csvfile = "shop.csv";
    private List<Product> allProducts = new ArrayList<>();

    public void loadProducts() {
        try {
            Files.lines(Paths.get("shop.csv")).skip(1).forEach(s -> {
                Product p1 = new Product();
                String [] record= s.split(",");
                p1.setProductNo(Integer.parseInt(record[0]));
                p1.setProductName(record[1]);
                p1.setQuantity(Integer.parseInt(record[2]));
                p1.setPrice(Float.parseFloat(record[3]));
                p1.setDiscount(Float.parseFloat(record[4]));

                allProducts.add(p1);
            });

        } catch (IOException e) {

        }
    }

    public Product enterProductDetails() {

        Product p = new Product();
        Scanner in = new Scanner(System.in);

        System.out.println("Enter Product Number of the Product:  ");
        //int x = in.nextInt();
         p.setProductNo(in.nextInt());

        System.out.println("Enter Name of the Product:  ");
        p.setProductName(in.next());

        System.out.println("Enter Quantity of the Product:  ");
        p.setQuantity(in.nextInt());

        System.out.println("Enter Price of the Product:  ");
        p.setPrice (in.nextFloat());

        System.out.println("Enter Discount of the Product:  ");
        p.setDiscount(in.nextFloat());


        return (p);
    }

    void addToList(Product p)
    {
        allProducts.add(p);
    }

    void showProduct(Product p1) {
        System.out.println("The Product No. of The Product : " + p1.getProductNo());
        System.out.println("The Name of The Product :  " + p1.getProductName());
        System.out.println("The available Quantity of The Product : " + p1.getQuantity());
        System.out.println("The price of The Product : " + p1.getPrice());
        System.out.println("Discount : " + p1.getDiscount() + " %");

    }

   void displayAll()
   {   System.out.println("**********************************************");
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
            writer = new PrintWriter( new FileOutputStream(new File(csvfile)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        writer.write("ProductNo,Productname,Quantity,Price,Discount");
        for (Product p1 : allProducts)
        {

            writer.write(p1.toCsvString());
        }




        writer.close();

        System.out.println("Products added to file ");



    }



    void displaySpecial(int pno)
    {   System.out.println("**********************************************");
        System.out.println("Displaying Special Product");

        for (Product product : allProducts) {

            if(product.getProductNo() == pno) {
                System.out.println(product.toString());
                break;
            }
        }

    }


   void  deleteProduct(int pno)
   {  System.out.println("**********************************************");
       System.out.println("Deleting Product");
       for (Product product : allProducts) {

           if(product.getProductNo()==pno)
           {
               allProducts.remove(product);
               break;
           }
       }
   }

    void modifyProduct(int pno)
    {
        System.out.println("**********************************************");
        System.out.println("Modifying Product");
        int i ;
     Product p1 = new Product();

        for (i = 0; i < allProducts.size(); i++) {

            if(allProducts.get(i).getProductNo()==pno)
            {   p1 = enterProductDetails();
                break;
            }

        }

        allProducts.set(i, p1);
    }



    public static void main(String args[]) {
        Admin a = new Admin();
      Product p = new Product();
//        a.writeProduct();
//        a.writeProduct();
        a.loadProducts();
        a.displayAll();
        p=a.enterProductDetails();
         a.addToList(p);
      p=a.enterProductDetails();
        a.addToList(p);
        p=a.enterProductDetails();
        a.addToList(p);

        a.displayAll();
        a.displaySpecial(22);
        a.modifyProduct(44);
        a.displayAll();
        a.deleteProduct(33);
        a.displayAll();
        a.writeProduct();
       //  a.createProduct();
        //p.showProduct();

    }



}


