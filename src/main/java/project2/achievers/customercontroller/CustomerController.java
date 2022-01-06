package project2.achievers.customercontroller;

import com.google.gson.Gson;
import project2.achievers.Entities.Customer;
import project2.achievers.Entities.Items;
import project2.achievers.Entities.ShoppingList;
import project2.achievers.customerexceptions.InvalidLogin;
import project2.achievers.customerservices.CustomerServices;
import io.javalin.http.Handler;

import java.util.List;
import java.util.Map;

public class CustomerController {

    CustomerServices customerServices;

    public CustomerController(CustomerServices customerServices)
    {this.customerServices=customerServices;}


    public Handler getCompletedList = ctx -> {
        int customerId = Integer.parseInt(ctx.pathParam("customerId"));
        List<ShoppingList> completedLists = this.customerServices.getAllCompletedListsService(customerId);
        Gson gson = new Gson();
        String completedListsJSONs = gson.toJson(completedLists);
        ctx.result(completedListsJSONs);
        ctx.status(200);


    };

    public Handler deleteShoppingList = ctx -> {
        int shoppingListId = Integer.parseInt(ctx.pathParam("shoppingListId"));

            boolean shoppingList = this.customerServices.deleteShoppingListService(shoppingListId);
            ctx.status(200);

        };



    public Handler getAllList = ctx ->{

        int customerId=Integer.parseInt(ctx.pathParam("customerId"));
        List<ShoppingList> shoppingLists = this.customerServices.getAllShoppingListsService(customerId);
        Gson gson = new Gson();
        String listsJSONs= gson.toJson(shoppingLists);
        ctx.result(listsJSONs);

    };


    public Handler createItems = ctx ->{
        Gson gson = new Gson();
        Items item = gson.fromJson(ctx.body(), Items.class);
        Items createdItem = this.customerServices.createItemsService(item);
        String createdItemJson = gson.toJson(createdItem);
        ctx.result(createdItemJson);
        ctx.status(201);
    };


    public Handler deleteItems = ctx -> {
        int itemId = Integer.parseInt(ctx.pathParam("itemId"));
        boolean deletedItem = this.customerServices.deleteItemsService(itemId);
        ctx.status(200);

    };


    public Handler getIncompleteList = ctx -> {
        int customerId = Integer.parseInt(ctx.pathParam("customerId"));
        List<ShoppingList> incompleteLists = this.customerServices.getAllIncompleteListsServices(customerId);
        Gson gson = new Gson();
        String incompleteListsJSONs = gson.toJson(incompleteLists);
        ctx.result(incompleteListsJSONs);
        ctx.status(200);


    };


    public Handler createCustomer = ctx ->{
        Gson gson = new Gson();
        Customer newCustomer = gson.fromJson(ctx.body(), Customer.class);
        Customer createdCustomer = this.customerServices.createCustomer(newCustomer);
        String createdCustomerJson = gson.toJson(createdCustomer);
        ctx.result(createdCustomerJson);
        ctx.status(201);
    };


    public Handler createShoppingList = ctx ->{
        Gson gson = new Gson();
        ShoppingList newShoppingList = gson.fromJson(ctx.body(), ShoppingList.class);
        ShoppingList createdShoppingList = this.customerServices.createShoppingList(newShoppingList);
        String createdShoppingListJson = gson.toJson(createdShoppingList);
        ctx.result(createdShoppingListJson);
        ctx.status(201);
    };


    public Handler getCustomerLoginByCredentials = ctx ->{

        try{
            Gson gson = new Gson();
            Map<String, String> credentials = gson.fromJson(ctx.body(), Map.class);
            Customer validateLogin = this.customerServices.getLoginByCredentialsService(credentials.get("username"), credentials.get("password"));
            String validateLoginJson = gson.toJson(validateLogin);
            ctx.result(validateLoginJson);
            ctx.status(200);

        } catch (InvalidLogin e){
            ctx.result(e.getMessage());
            ctx.status(404);
        }
    };









    }






