package admin;

import products.Product;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

public class Admin {

    private static String csvfile = "shop.csv";
    private List<Product> allProducts ;
    Product p =new Product();


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

        float dPrice = price * (1 - (discount/100));
        p1.setDiscountedPrice(dPrice);


        return (p1);
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

        System.out.println("Products added to file ");


    }

    public void displaySpecial() {
        Scanner in = new Scanner(System.in);
        System.out.println("**********************************************");
        System.out.println("Enter the Product No. of the Product which you want the details: ");
        int pno = in.nextInt();

        System.out.println("\nDisplaying Special Product");

        for (Product product : allProducts) {

            if (product.getProductNo() == pno) {
                System.out.println(product.toString());
                break;
            }
        }

    }

    public void deleteProduct() {
        Scanner in = new Scanner(System.in);
        System.out.println("**********************************************");
        System.out.println("Enter the Product No. of the Product you want to delete: ");
        int pno = in.nextInt();

        System.out.println("\nDeleting Product");
        for (Product product : allProducts) {

            if (product.getProductNo() == pno) {
                allProducts.remove(product);
                break;
            }
        }
    }

   public void modifyProduct() {
        Scanner in = new Scanner(System.in);
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
                break;
            }

        }

        allProducts.set(i, p1);
    }

    public void adminMenu()
    {
        Scanner in = new Scanner(System.in);
        int ch;
        p.loadProducts();
        getProductList(p);

        while(true) {
            System.out.println("\n\n\n\tADMIN MENU");
            System.out.println("\n\n\t1.CREATE PRODUCT");
            System.out.println("\n\n\t2.DISPLAY ALL PRODUCTS");
            System.out.println("\n\n\t3.QUERY ");
            System.out.println("\n\n\t4.MODIFY PRODUCT");
            System.out.println("\n\n\t5.DELETE PRODUCT");
            System.out.println("\n\n\t6.BACK TO MAIN MENU");
            System.out.println("\n\n\tPlease Enter Your Choice (1-6) ");
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

            }
        }
    }


}


