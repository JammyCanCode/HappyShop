package ci553.happyshop.catalogue;

import java.util.Collections;

public class OrganisedTrolley extends Trolley{
    @Override
    public void addProduct(Product product) {
        boolean matchFound = false;


        //The logic behind this was to retrieve the item list from getProducts() and then compare the product ID of the items
        // pulled from getProducts to see if they match, if they match then increase the ordered Quantity by 1 in the view
        // Once a match has been found, use collections.sort to sort the list in ascending order.
        for (Product item : getProducts()) {
            if (item.getProductId().equals(product.getProductId())){
            int nQuantity = item.getOrderedQuantity() + product.getOrderedQuantity();
            item.setOrderedQuantity(nQuantity);

            matchFound = true;
            break; }
            }

            if (!matchFound){
            super.addProduct(product);
        }

        Collections.sort(getProducts());
    }
}
