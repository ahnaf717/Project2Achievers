package project2.achievers.shopperservices;

import project2.achievers.Entities.Shopper;

public interface ShopperServices {

    Shopper createShopper(Shopper shopper);

    Shopper getShopperLoginByCredentialsService(String username, String password);
}
