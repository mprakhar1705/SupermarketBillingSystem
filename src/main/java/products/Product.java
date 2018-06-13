package products;

public class Product{

   private int productNo;
   private String productName;
   private int quantity;
   private float price;
   private float discount;
   private float discountedPrice;


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

}
