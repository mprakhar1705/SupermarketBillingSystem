package admin;

import products.Product;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Admin {

    private static String csvfile = "shop.csv";
    private List<Product> allProducts ;
    Product p =new Product();

    public Admin(ArrayList<Product> listOfProduct)
    {
        allProducts = listOfProduct;
    }

    public Product enterProductDetails() {

        Product p1 = new Product();
        Scanner in = new Scanner(System.in);
        int pno,qty;
        float price,discount;
        String s;
        boolean pnoFlag,pnoPositive,qtyFlag,priceFlag,discountFlag;

        do { pnoPositive=true;
            System.out.println("Enter Product Number of the Product:  ");
             pno = in.nextInt();
            pnoFlag = checkIfExists(pno);
            if (!pnoFlag)
                p1.setProductNo(pno);
            else System.out.println("Product Id already exists!");

            if(pno<0)
            {
                System.out.println("Invalid Product Id ");
                pnoPositive=false;
            }
        }while(pnoFlag || !pnoPositive);

        System.out.println("Enter Name of the Product:  ");
         s =in.next();
        p1.setProductName(s);

       do {
           qtyFlag=true;
           System.out.println("Enter Quantity of the Product:  ");
           qty = in.nextInt();
           if(qty>0)
           p1.setQuantity(qty);

           else
           { qtyFlag=false;
               System.out.println("Invalid Quantity ");
           }
       }while (!qtyFlag);

       do { priceFlag=true;
           System.out.println("Enter Price of the Product:  ");
           price = in.nextFloat();
           if(price>0)
           p1.setPrice(price);
           else
           { priceFlag=false;
               System.out.println("Invalid Price ");
           }
       }while (!priceFlag);


       do {
           discountFlag=true;
           System.out.println("Enter Discount of the Product:  ");
           discount = in.nextFloat();
           if(discount>=0)
           p1.setDiscount(discount);
           else
           { discountFlag=false;
               System.out.println("Invalid Discount ");
           }

       }while (!discountFlag);

        float dPrice = price * (1 - (discount/100));
        p1.setDiscountedPrice(dPrice);


        return (p1);
    }

    boolean checkIfExists(int pno)
    {
        for (Product product : allProducts) {

            if (product.getProductNo() == pno) {
               return true;
            }
        }
        return false;
    }

    public void addToList(Product p1) {
        //Product pp = new Product();
        allProducts.add(p1);
    }


    public void displayAll() {
        System.out.println("**********************************************");
        System.out.println("Displaying All Products");
        System.out.println("**********************************************");
        for (Product product : allProducts) {

            System.out.println(product.toString());
        }

    }

    public void writeProduct() {
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


    }

    public void displaySpecial() {
        Scanner in = new Scanner(System.in);
        int f=0;
        System.out.println("**********************************************");
        System.out.println("Enter the Product No. of the Product which you want the details: ");
        int pno = in.nextInt();



        for (Product product : allProducts) {

            if (product.getProductNo() == pno) {
                System.out.println("\nProduct Details are as follows: ");
                System.out.println(product.toString());
                f=1;
                break;
            }
        }

         if(f==0)
             System.out.println("Sorry! Cannot find a Product with ID "+pno+"\n");

    }

    public void deleteProduct() {
        Scanner in = new Scanner(System.in);
        int f=0;
        System.out.println("**********************************************");
        System.out.println("Enter the Product No. of the Product you want to delete: ");
        int pno = in.nextInt();


        for (Product product : allProducts) {

            if (product.getProductNo() == pno) {
                allProducts.remove(product);
                f=1;
                System.out.println("\nProduct Deletion Successful!");
                break;
            }
        }
        if(f==0)
            System.out.println("Sorry! Cannot find a Product with ID "+pno+"\n");
    }

   public void modifyProduct() {
        Scanner in = new Scanner(System.in);
        int f=0;
        System.out.println("**********************************************");
        System.out.println("Enter the Product No. of the Product you want to modify: ");
        int pno = in.nextInt();

        System.out.println("Modifying Product");
        int i;
        Product p1 = new Product();

        for (i = 0; i < allProducts.size(); i++) {

            if (allProducts.get(i).getProductNo() == pno) {
                System.out.println("Please enter new details: ");
                p1 = enterProductDetails();
                allProducts.set(i, p1);
                f=1;
                System.out.println("\nProduct Deletion Successful!");
                break;
            }

        }
       if(f==0)
           System.out.println("Sorry! Cannot find a Product with ID "+pno+"\n");

    }

    public void adminMenu()
    {
        Scanner in = new Scanner(System.in);
        int ch;
//        p.loadProducts();
//        getProductList(p);

        while(true) {
            System.out.println("\n\n\n\tADMIN MENU");
            System.out.println("\t1.CREATE PRODUCT");
            System.out.println("\t2.DISPLAY ALL PRODUCTS");
            System.out.println("\t3.QUERY ");
            System.out.println("\t4.MODIFY PRODUCT");
            System.out.println("\t5.DELETE PRODUCT");
            System.out.println("\t6.BACK TO MAIN MENU");
            System.out.println("\tPlease Enter Your Choice (1-6) ");
            ch = in.nextInt();

            switch(ch)
            {
                case 1 :
                    p = enterProductDetails();
                   addToList(p);
                break;
                case 2 : displayAll();
                break;
                case 3 : displaySpecial();
                break;
                case 4 : modifyProduct();
                break;
                case 5 : deleteProduct();
                break;
                case 6 : writeProduct();
                    return;

                    default: System.out.println("Wrong Choice!");

            }
        }
    }


}


