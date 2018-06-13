import admin.Admin;
import customer.Customer;
import products.Product;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.exit;

public class Intro {
    private ArrayList<Product> listOfProducts = new ArrayList<>();

    public void loadProducts() {
        try {
            Files.lines(Paths.get("shop.csv")).skip(1).forEach(s -> {
                Product p1 = new Product();
                String[] record = s.split(",");
                p1.setProductNo(Integer.parseInt(record[0]));
                p1.setProductName(record[1]);
                p1.setQuantity(Integer.parseInt(record[2]));
                p1.setPrice(Float.parseFloat(record[3]));
                p1.setDiscount(Float.parseFloat(record[4]));
                p1.setDiscountedPrice(Float.parseFloat(record[5]));
                listOfProducts.add(p1);
            });

        } catch (IOException e) {

        }
    }

   public void introMsg()
   {
       System.out.println("WELCOME TO THE SUPERMARKET");

   }

   public void displayMenu()
   { Scanner in = new Scanner(System.in);
       Customer c = new Customer(listOfProducts);
       Admin a = new Admin(listOfProducts);
     char ch;
   do
       {

           System.out.println("\n\n\n\tMAIN MENU");
           System.out.println("\n\n\t01. CUSTOMER");
           System.out.println("\n\n\t02. ADMINISTRATOR");
           System.out.println("\n\n\t03. EXIT");
           System.out.println("\n\n\tPlease Select Your Option (1-3) ");
           ch = in.next().charAt(0);
           switch(ch)
           {
               case '1':
                  c.placeOrder();
                   break;

               case '2':
                   a.adminMenu();
                  // a.writeProduct();
                   break;

               case '3':
                   exit(0);

                   default :System.out.println("Wrong Choice");
           }
       }while(ch!='3');
   }



    public static void main(String args[])
    {
            Intro i = new Intro() ;
             i.introMsg();
             i.loadProducts();
             i.displayMenu();

    }
}
