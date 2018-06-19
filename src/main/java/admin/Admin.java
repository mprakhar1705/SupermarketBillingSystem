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

    public Admin() {

    }

    String getUserInput(String msg)
    {
        Scanner in = new Scanner(System.in);
        System.out.println(msg);
        return in.next();
    }

    public Product enterProductDetails() {


        Scanner in = new Scanner(System.in);
        int pno,qty;
        float price,discount,discountedPrice;
        String s;

        pno = Integer.parseInt(getUserInput("Enter Product Number of the Product:"));
        s =  getUserInput("Enter Name of the Product:  ");
        qty = Integer.parseInt(getUserInput("Enter Quantity of the Product:"));
        price = Float.parseFloat(getUserInput("Enter Price of the Product:"));
        discount = Float.parseFloat(getUserInput("Enter Discount of the Product:"));
        discountedPrice = price * (1 - (discount/100));


        boolean isInputValid = validateInput(pno,s,qty,price,discount);
        if(isInputValid)
        {
            Product p1 = new Product(pno,s,qty,price,discount,discountedPrice);
            return p1;
        }

        else {
            System.out.println("Invalid Details! Please Re-enter details: ");

           return enterProductDetails();
        }

    }

    public boolean validateInput(int pno, String s, int qty, float price, float discount) {

        if(checkIfExists(pno)==false && pno>0 && qty>0 && price>0 && discount>=0)
            return true;
        else return false;
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
                System.out.println("\nProduct Modification Successful!");
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


