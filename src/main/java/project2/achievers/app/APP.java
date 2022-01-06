package project2.achievers.app;

import io.javalin.Javalin;
import project2.achievers.DAO.customer.CustomerDao;
import project2.achievers.DAO.customer.CustomerDaoImp;
import project2.achievers.DAO.shopper.ShopperDao;
import project2.achievers.DAO.shopper.ShopperDaoImp;
import project2.achievers.customercontroller.CustomerController;
import project2.achievers.customercontroller.ShopperController;
import project2.achievers.customerservices.CustomerServices;
import project2.achievers.customerservices.CustomerServicesImp;
import project2.achievers.shopperservices.ShopperServices;
import project2.achievers.shopperservices.ShopperServicesImp;

public class APP {


    public static void main(String[] args) {
        Javalin app = Javalin.create(config -> {
            config.enableDevLogging();
            config.enableCorsForAllOrigins();
        });

        CustomerDao customerDao = new CustomerDaoImp();
        CustomerServices customerServices = new CustomerServicesImp(customerDao);
        CustomerController customerController = new CustomerController(customerServices);

        ShopperDao shopperDao = new ShopperDaoImp();
        ShopperServices shopperServices = new ShopperServicesImp(shopperDao);
        ShopperController shopperController = new ShopperController(shopperServices);





         //Ahnaf Methods
        app.get("/lists/complete/{customerId}", customerController.getCompletedList);
        app.delete("/list/delete/{shoppingListId}", customerController.deleteShoppingList);
        app.get("/lists/{customerId}",customerController.getAllList);
        app.post("/item",customerController.createItems);
        app.delete("item/delete/{itemId}",customerController.deleteItems);
        app.get("lists/incomplete/{customerId}",customerController.getIncompleteList);

         //Dearce Methods
        app.post ("/customer", customerController.createCustomer);

        app.post ("/shoppingList", customerController.createShoppingList);

        app.post("/customerLogin", customerController.getCustomerLoginByCredentials);

        app.post ("/shopper", shopperController.createShopper);

        app.post("/shopperLogin", shopperController.getShopperLoginByCredentials);





        app.start();
    }
}
