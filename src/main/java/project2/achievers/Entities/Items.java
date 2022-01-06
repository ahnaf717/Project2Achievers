package project2.achievers.Entities;

import java.util.Objects;

public class Items {

    private int itemId;
    private String itemName;
    private int itemQuantity;
    private int shoppingListId;


    public Items() {
    }


    public Items(int itemId, String itemName, int itemQuantity, int shoppingListId) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemQuantity = itemQuantity;
        this.shoppingListId = shoppingListId;
    }

    @Override
    public String toString() {
        return "Items{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", itemQuantity=" + itemQuantity +
                ", shoppingListId=" + shoppingListId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Items items = (Items) o;
        return itemId == items.itemId && itemQuantity == items.itemQuantity && shoppingListId == items.shoppingListId && Objects.equals(itemName, items.itemName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId, itemName, itemQuantity, shoppingListId);
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public int getShoppingListId() {
        return shoppingListId;
    }

    public void setShoppingListId(int shoppingListId) {
        this.shoppingListId = shoppingListId;
    }
}
