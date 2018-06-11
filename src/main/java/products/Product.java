package products;

public class Product{

   private int productNo;
   private String productName;
   private int quantity;
   private float price;
   private float discount;


   @Override
   public String toString() {
      return "Product{" +
              "productNo=" + productNo +
              ", productName='" + productName + '\'' +
              ", quantity=" + quantity +
              ", price=" + price +
              ", discount=" + discount +
              '}';
   }

   public String toCsvString() {
      return "\n"+productNo + "," + productName + "," + quantity + "," + price +","+discount;
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
}
