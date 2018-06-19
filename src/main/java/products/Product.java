package products;

public class Product{

   public static final String TAB_SPACES = "\t\t\t";
   private int productNo;
   private String productName;
   private int quantity;
   private float price;
   private float discount;
   private float discountedPrice;


   public  Product () {
   }

   public Product(int productNo, String productName, int quantity, float price, float discount, float discountedPrice) {
      this.productNo = productNo;
      this.productName = productName;
      this.quantity = quantity;
      this.price = price;
      this.discount = discount;
      this.discountedPrice=discountedPrice;
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
      return productNo + TAB_SPACES + productName + TAB_SPACES +quantity+"\t\t\t\t"+ price + TAB_SPACES +discount+"%"+ TAB_SPACES
              +discountedPrice;
   }

   public String toStringCheckout()
   {
      return toStringMenuStyle() + TAB_SPACES + discountedPrice*quantity;
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
