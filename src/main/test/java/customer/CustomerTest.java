package customer;

import org.junit.Assert;
import org.junit.Test;
import products.Product;

import java.util.Arrays;
import java.util.List;

public class CustomerTest {


    @Test
    public void testIt() {

        List<Product> allProducts = Arrays.asList(new Product(), new Product());


        Customer customer = new Customer(allProducts);


        customer.addToCart();

//        Assert.assertEquals(expectedCart. returnCart);

    }

}
