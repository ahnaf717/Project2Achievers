package project2.achievers.customerservices;

import project2.achievers.Entities.Customer;
import project2.achievers.Entities.Items;
import project2.achievers.Entities.ShoppingList;

import java.util.List;

public interface CustomerServices {



    List<ShoppingList> getAllCompletedListsService(int customerId);

    boolean deleteShoppingListService(int shoppingListId);

    List<ShoppingList>getAllShoppingListsService(int customerId);

    Items createItemsService(Items items);

    boolean deleteItemsService(int itemId);

    List<ShoppingList>getAllIncompleteListsServices(int customerId);

    Customer createCustomer(Customer customer);

    ShoppingList createShoppingList(ShoppingList shoppingList);

    Customer getLoginByCredentialsService(String username, String password);

}
