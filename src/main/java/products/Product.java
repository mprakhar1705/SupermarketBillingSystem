package products;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Product{

   private int productNo;
   private String productName;
   private int quantity;
   private float price;
   private float discount;
   private float discountedPrice;
   private List<Product> listOfProducts = new ArrayList<>();

   public  Product ()
   {

   }
   public Product (Product p)
   {
      productNo = p.productNo;
      productName = p.productName;
      quantity = p.quantity;
      price = p.price;
      discount = p.discount;
      discountedPrice = p.discountedPrice;
   }


   @Override
   public String toString() {
      return "Product{" +
              "productNo=" + productNo +
              ", productName='" + productName + '\'' +
              ", quantity=" + quantity +
              ", price=" + price +
              ", discount=" + discount +
              ", discountedPrice="+discountedPrice+
              '}';
   }

   public String toStringMenuStyle()
   {
      return productNo + "\t\t\t" + productName +  "\t\t\t"+quantity+"\t\t\t\t"+ price + "\t\t\t"+discount+"%"+ "\t\t\t"
              +discountedPrice;
   }

   public String toStringCheckout()
   {
      return productNo + "\t\t\t" + productName +  "\t\t\t"+quantity+"\t\t\t\t"+ price + "\t\t\t"+discount+"%"+ "\t\t\t"
              +discountedPrice+"\t\t\t"+discountedPrice*quantity;
   }

   public String toCsvString() {
      return "\n"+productNo + "," + productName + "," + quantity + "," + price +","+discount+","+discountedPrice;
   }

   public int getProductNo() {
      return productNo;
   }

   public void setProductNo(int productNo) {
      this.productNo = productNo;
   }

   public int getQuantity() {
      return quantity;
   }

   public void setQuantity(int quantity) {
      this.quantity = quantity;
   }

   public float getPrice() {
      return price;
   }

   public void setPrice(float price) {
      this.price = price;
   }

   public float getDiscount() {
      return discount;
   }

   public void setDiscount(float discount) {
      this.discount = discount;
   }

   public String getProductName() {
      return productName;
   }

   public void setProductName(String productName) {
      this.productName = productName;
   }

   public float getDiscountedPrice() { return discountedPrice; }

   public void setDiscountedPrice(float discountedPrice) {this.discountedPrice = discountedPrice;}

   public List<Product> getListOfProducts() {
      return listOfProducts;
   }

   public void setListOfProducts(List<Product> listOfProducts) {
      this.listOfProducts = listOfProducts;
   }

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
           //System.out.println("hi");
            listOfProducts.add(p1);
         });

      } catch (IOException e) {

      }
   }


}
