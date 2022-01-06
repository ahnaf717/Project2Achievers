package project2.achievers.customercontroller;

import com.google.gson.Gson;
import io.javalin.http.Handler;
import project2.achievers.Entities.Shopper;
import project2.achievers.customerexceptions.InvalidLogin;
import project2.achievers.shopperservices.ShopperServices;

import java.util.Map;

public class ShopperController {


     ShopperServices shopperServices;

    public ShopperController(ShopperServices shopperServices)
    {this.shopperServices=shopperServices;}


    public Handler createShopper = ctx ->{
        Gson gson = new Gson();
        Shopper newShopper = gson.fromJson(ctx.body(), Shopper.class);
        Shopper createdShopper = this.shopperServices.createShopper(newShopper);
        String createdShopperJson = gson.toJson(createdShopper);
        ctx.result(createdShopperJson);
        ctx.status(201);
    };


    public Handler getShopperLoginByCredentials = ctx ->{

        try{
            Gson gson = new Gson();
            Map<String, String> credentials = gson.fromJson(ctx.body(), Map.class);
            Shopper validateShopperLogin = this.shopperServices.getShopperLoginByCredentialsService(credentials.get("username"), credentials.get("password"));
            String validateLoginJson = gson.toJson(validateShopperLogin);
            ctx.result(validateLoginJson);
            ctx.status(200);

        } catch (InvalidLogin e){
            ctx.result(e.getMessage());
            ctx.status(404);
        }
    };




}
