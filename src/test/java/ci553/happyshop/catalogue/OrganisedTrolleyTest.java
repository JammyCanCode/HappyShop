package ci553.happyshop.catalogue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class OrganisedTrolleyTest {

    /*
    This test class allows testing of the adding a single product to the list as well as managing duplicate product IDs
    and merging them into one (Organised Trolley Logic) as well as sorting the Trolley list by ProductID.
    The final test in the class tests both merging and sorting functions to ensure that the logic behind these are correct.
    */

    private OrganisedTrolley trolley;

    @BeforeEach
    void initialize() {
        trolley = new OrganisedTrolley();
    }

    @Test
    void addSingleProduct_ToList() {
        Product p1 = new Product("0001", "TV", "0001.jpg", 269.00, 1, 50);

        trolley.addProduct(p1);

        assertEquals(1, trolley.getProducts().size());
        assertEquals("0001", trolley.getProducts().get(0).getProductId());
        assertEquals(1, trolley.getProducts().get(0).getOrderedQuantity());
    }

    @Test
    void duplicateProductIdAndMergeQuant() {

        Product p1 = new Product("0001", "TV", "0001.jpg", 269.00, 1, 50);
        Product p2 = new Product("0001", "TV", "0001.jpg", 269.00, 2, 50);

        trolley.addProduct(p1);
        trolley.addProduct(p2);

        ArrayList<Product> products = trolley.getProducts();
        assertEquals(1, products.size());
        assertEquals("0001", products.get(0).getProductId());
        assertEquals(3, products.get(0).getOrderedQuantity());
    }

    @Test
    void addProductUnorganisedOrderAndSortByProductID() {

        Product p1 = new Product("0001", "TV", "0001.jpg", 269.00, 1, 50);
        Product p2 = new Product("0002", "Radio", "0002.jpg", 29.99, 1, 40);
        Product p3 = new Product("0003", "Toaster", "0003.jpg", 19.99, 1, 30);

        trolley.addProduct(p3);
        trolley.addProduct(p1); //Add Products out of Order
        trolley.addProduct(p2);

        ArrayList<Product> products = trolley.getProducts();
        assertEquals(3, products.size());
        assertEquals("0001", products.get(0).getProductId());
        assertEquals("0002", products.get(1).getProductId());
        assertEquals("0003", products.get(2).getProductId());
    }

    @Test
    void MergeAndSortCombined() {
        Product p3 = new Product("0003", "Toaster", "0003.jpg", 19.99, 1, 30);
        Product p1 = new Product("0001", "TV", "0001.jpg", 269.00, 1, 50);
        Product p3Duplicate = new Product("0003", "Toaster", "0003.jpg", 19.99, 1, 30);

        trolley.addProduct(p3);
        trolley.addProduct(p1);
        trolley.addProduct(p3Duplicate);

        ArrayList<Product> products = trolley.getProducts();
        assertEquals(2, products.size());
        assertEquals("0001", products.get(0).getProductId());
        assertEquals(1, products.get(0).getOrderedQuantity());
        assertEquals("0003", products.get(1).getProductId());
        assertEquals(2, products.get(1).getOrderedQuantity());
    }
}