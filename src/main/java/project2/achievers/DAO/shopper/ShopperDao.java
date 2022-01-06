package project2.achievers.DAO.shopper;

import project2.achievers.Entities.Shopper;

public interface ShopperDao {

    Shopper createShopper(Shopper shopper);

    Shopper getShopperLoginByCredentials(String username, String password);



}
