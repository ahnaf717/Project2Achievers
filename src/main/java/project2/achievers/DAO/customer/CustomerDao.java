package project2.achievers.DAO.customer;

import project2.achievers.Entities.Customer;
import project2.achievers.Entities.Items;
import project2.achievers.Entities.ShoppingList;

import java.util.List;

public interface CustomerDao {



   List<ShoppingList>getAllCompletedLists(int customerId);

   boolean deleteShoppingList(int shoppingListId);

   List<ShoppingList>getAllShoppingLists(int customerId);

   Items createItems(Items items);

   boolean deleteItems(int itemId);

   List<ShoppingList>getAllIncompleteLists(int customerId);

   Customer createCustomer(Customer customer);

   ShoppingList createShoppingList(ShoppingList shoppingList);

   Customer getLoginByCredentials(String username, String password);


}













