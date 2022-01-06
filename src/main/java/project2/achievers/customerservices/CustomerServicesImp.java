package project2.achievers.customerservices;

import project2.achievers.DAO.customer.CustomerDao;
import project2.achievers.Entities.Customer;
import project2.achievers.Entities.Items;
import project2.achievers.Entities.ShoppingList;


import java.util.List;

public class CustomerServicesImp implements CustomerServices{


         CustomerDao customerDao;

         public CustomerServicesImp(CustomerDao customerDao){

             this.customerDao=customerDao;
         }




    @Override
    public List<ShoppingList> getAllCompletedListsService(int customerId) {
        return this.customerDao.getAllCompletedLists(customerId);
    }

    @Override
    public boolean deleteShoppingListService(int shoppingListId) {
        return this.customerDao.deleteShoppingList(shoppingListId);
    }

    @Override
    public List<ShoppingList> getAllShoppingListsService(int customerId) {
        return this.customerDao.getAllShoppingLists(customerId);
    }

    @Override
    public Items createItemsService(Items items) {
        return this.customerDao.createItems(items);
    }

    @Override
    public boolean deleteItemsService(int itemId) {
        return this.customerDao.deleteItems(itemId);
    }

    @Override
    public List<ShoppingList> getAllIncompleteListsServices(int customerId) {
        return this.customerDao.getAllIncompleteLists(customerId);
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return this.customerDao.createCustomer(customer);
    }

    @Override
    public ShoppingList createShoppingList(ShoppingList shoppingList) {
        return this.customerDao.createShoppingList(shoppingList);
    }

    @Override
    public Customer getLoginByCredentialsService(String username, String password) {
        return this.customerDao.getLoginByCredentials(username,password);
    }


}
