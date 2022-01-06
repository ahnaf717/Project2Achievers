package project2.achievers.shopperservices;

import project2.achievers.DAO.shopper.ShopperDao;
import project2.achievers.Entities.Shopper;

public class ShopperServicesImp implements ShopperServices {



    ShopperDao shopperDao;

         public ShopperServicesImp(ShopperDao shopperDao){

             this.shopperDao=shopperDao;
         }



    @Override
    public Shopper createShopper(Shopper shopper) {
        return this.shopperDao.createShopper(shopper);
    }

    @Override
    public Shopper getShopperLoginByCredentialsService(String username, String password) {
        return this.shopperDao.getShopperLoginByCredentials(username,password);
    }
}
