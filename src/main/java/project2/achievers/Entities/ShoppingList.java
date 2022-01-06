package project2.achievers.Entities;

import java.util.Objects;

public class ShoppingList {

    private int shoppingListId;
    private String shoppingListName;
    private String customerComments;
    private String shopperComments;
    private String listStatus;
    private int customerId;
    private int shopperId;


    public ShoppingList() {
    }

    public ShoppingList(int shoppingListId, String shoppingListName, String customerComments, String shopperComments, String listStatus, int customerId, int shopperId) {
        this.shoppingListId = shoppingListId;
        this.shoppingListName = shoppingListName;
        this.customerComments = customerComments;
        this.shopperComments = shopperComments;
        this.listStatus = listStatus;
        this.customerId = customerId;
        this.shopperId = shopperId;
    }

    @Override
    public String toString() {
        return "ShoppingList{" +
                "shoppingListId=" + shoppingListId +
                ", shoppingListName='" + shoppingListName + '\'' +
                ", customerComments='" + customerComments + '\'' +
                ", shopperComments='" + shopperComments + '\'' +
                ", listStatus='" + listStatus + '\'' +
                ", customerId=" + customerId +
                ", shopperId=" + shopperId +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingList that = (ShoppingList) o;
        return shoppingListId == that.shoppingListId && customerId == that.customerId && shopperId == that.shopperId && Objects.equals(shoppingListName, that.shoppingListName) && Objects.equals(customerComments, that.customerComments) && Objects.equals(shopperComments, that.shopperComments) && Objects.equals(listStatus, that.listStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shoppingListId, shoppingListName, customerComments, shopperComments, listStatus, customerId, shopperId);
    }


    public int getShoppingListId() {
        return shoppingListId;
    }

    public void setShoppingListId(int shoppingListId) {
        this.shoppingListId = shoppingListId;
    }

    public String getShoppingListName() {
        return shoppingListName;
    }

    public void setShoppingListName(String shoppingListName) {
        this.shoppingListName = shoppingListName;
    }

    public String getCustomerComments() {
        return customerComments;
    }

    public void setCustomerComments(String customerComments) {
        this.customerComments = customerComments;
    }

    public String getShopperComments() {
        return shopperComments;
    }

    public void setShopperComments(String shopperComments) {
        this.shopperComments = shopperComments;
    }

    public String getListStatus() {
        return listStatus;
    }

    public void setListStatus(String listStatus) {
        this.listStatus = listStatus;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getShopperId() {
        return shopperId;
    }

    public void setShopper_Id(int shopperId) {
        this.shopperId = shopperId;
    }
}





