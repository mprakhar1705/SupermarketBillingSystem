package admin;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import products.Product;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

public class AdminTest {

    ArrayList<Product> listOfProduct = new ArrayList<>();

    @Before
   public void setUp() {

        Product p = new Product(10, "rr", 40, 70.0f, 10.5f, 62.649998f);
        listOfProduct.add(p);
        Product pp = new Product(22, "uu", 10, 50.0f, 20.0f, 40.0f);
        listOfProduct.add(pp);

    }

    @Test
    void displaySpecialTest() {
        Admin a = new Admin(listOfProduct);
        a.displaySpecial();
    }
    @Test
    public void productDetailsTest()
    {
        // Product p = new Product(111,"test",8,60f,10f,54f);
        Admin a = new Admin(listOfProduct);
        assertEquals(false,a.validateInput(99,"test1",-1,60f,10f));
        assertEquals(false,a.validateInput(99,"test2",10,0,10f));
        assertEquals(true,a.validateInput(100,"test3",86,60.4f,10.5f));

    }

    @Test

    public  void checkIfExistTest()
     {
         Admin a = new Admin(listOfProduct);
         assertEquals(true,a.checkIfExists(22));
         assertEquals(false,a.checkIfExists(55));
     }

     @Test
    public void addToListTest()
     {
         assertEquals(2,listOfProduct.size());
     }
}
