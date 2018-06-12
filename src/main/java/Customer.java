import products.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Customer {

    private List<Product> allProducts ;
    private List<Product> cart = new ArrayList<>();

    public static void main(String args[]){
        Customer c = new Customer();
        Product p = new Product();
        p.loadProducts();

        c.getProductList(p);
        c.placeOrder();

        c.showCart();
        c.showProductMenu();
        c.deleteFomCart();
        c.showCart();
        c.showProductMenu();
        c.checkOut();



    }

    public void showProductMenu(){
     System.out.println("\n\n\t\t\t\t\t\t\tPRODUCT MENU");
     System.out.println("=====================================================================================");
     System.out.println("P.NO.\t\tNAME\t\tQUANTITY\t\tPRICE\t\tDISCOUNT\t\tDISCOUNTED PRICE");
     System.out.println("=====================================================================================");

        for(Product p:allProducts)
        {
          System.out.println(p.toStringMenuStyle());
        }

    }

    public void getProductList(Product p)
    {
        //Product pp = new Product();
        allProducts = p.getListOfProducts();
    }

    public void placeOrder()
    {
        showProductMenu();
        Scanner in = new Scanner(System.in);
        int ch;
        do{
            addToCart();

            System.out.println("\nDo You Want To Order Another Product(0 for NO 1 for Yes) ?");
            ch=in.nextInt();
        }while(ch!=0);

        System.out.println("\n\nThank You For Placing The Order");
    }

    public void addToCart()
    {  int pno,qty,f=0;
        Scanner in =new Scanner(System.in);
        System.out.println("Enter product Number: ");
        pno=in.nextInt();
        System.out.println("Enter Quantity of the Product: ");
        qty=in.nextInt();

        for(Product p : allProducts)
        { if((p.getProductNo() == pno) && (p.getQuantity() >= qty))
            {
                p.setQuantity(p.getQuantity()- qty);

                Product cartProduct = new Product(p);
                cartProduct.setQuantity(qty);
                cart.add(cartProduct);
                  System.out.println("Added to cart");
                  f=1;
                  break;
            }

        }

        if(f==0)
               System.out.println("Invalid Request\nItem not Added to Cart");
    }


        public  void showCart()
        {
           System.out.println("YOUR CART");

            for(Product p : cart)
                System.out.println(p.toString());
        }

        public void deleteFomCart()
        {   int pno;

            Scanner in =new Scanner(System.in);
            System.out.println("Enter product Number: ");
            pno=in.nextInt();

            for(Product p : cart)
            {
                if(p.getProductNo()==pno)
                {
                    System.out.println("Are you sure you want to delete this Product?(0/1)");
                    int ch = in.nextInt();

                    if(ch==1)
                    {
                     cart.remove(p);
                     for(Product allp : allProducts)
                     {
                         if(allp.getProductNo()==pno)
                         {
                             allp.setQuantity(allp.getQuantity()+p.getQuantity());
                         }
                     }
                          System.out.println("Product deleted from Cart!");
                    }
                    break;
                }
            }
        }

        public void checkOut() {
            float totalPrice = 0;
            System.out.println("YOUR CART");
            System.out.println("=====================================================================================================");
            System.out.println("P.NO.\t\tNAME\t\tQUANTITY\t\tPRICE\t\tDISCOUNT\t\tDISCOUNTED PRICE\t\tFINAL PRICE");
            System.out.println("=====================================================================================================");

            for (Product p : cart) {
                totalPrice += p.getQuantity() * p.getDiscountedPrice();
                System.out.println(p.toStringCheckout());

            }

            System.out.println("Total Price: "+totalPrice);
        }
}

