package project2.achievers.Entities;


    import java.util.Objects;

    public class Shopper {
        private String shopperName;
        private String shopperUsername;
        private String shopperPassword;
        private int shopperZipCode;
        private int shopperId;

        //no args constructor
        public Shopper(){}

        //constructor set all shoppers properties

        public Shopper(String shopperName, String shopperUsername, String shopperPassword, int shopperZipCode, int shopperId) {
            this.shopperName = shopperName;
            this.shopperUsername = shopperUsername;
            this.shopperPassword = shopperPassword;
            this.shopperZipCode = shopperZipCode;
            this.shopperId = shopperId;
        }

        @Override
        public String toString() {
            return "Shopper{" +
                    "shopperName='" + shopperName + '\'' +
                    ", shopperUsername='" + shopperUsername + '\'' +
                    ", shopperPassword='" + shopperPassword + '\'' +
                    ", shopperZipCode=" + shopperZipCode +
                    ", shopperId=" + shopperId +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Shopper shopper = (Shopper) o;
            return shopperZipCode == shopper.shopperZipCode && shopperId == shopper.shopperId && Objects.equals(shopperName, shopper.shopperName) && Objects.equals(shopperUsername, shopper.shopperUsername) && Objects.equals(shopperPassword, shopper.shopperPassword);
        }

        @Override
        public int hashCode() {
            return Objects.hash(shopperName, shopperUsername, shopperPassword, shopperZipCode, shopperId);
        }

        public String getShopperName() {
            return shopperName;
        }

        public void setShopperName(String shopperName) {
            this.shopperName = shopperName;
        }

        public String getShopperUsername() {
            return shopperUsername;
        }

        public void setShopperUsername(String shopperUsername) {
            this.shopperUsername = shopperUsername;
        }

        public String getShopperPassword() {
            return shopperPassword;
        }

        public void setShopperPassword(String shopperPassword) {
            this.shopperPassword = shopperPassword;
        }

        public int getShopperZipCode() {
            return shopperZipCode;
        }

        public void setShopperZipCode(int shopperZipCode) {
            this.shopperZipCode = shopperZipCode;
        }

        public int getShopperId() {
            return shopperId;
        }

        public void setShopperId(int shopperId) {
            this.shopperId = shopperId;
        }
    }

