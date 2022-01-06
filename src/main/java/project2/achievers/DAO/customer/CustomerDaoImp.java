package project2.achievers.DAO.customer;

import project2.achievers.Entities.Customer;
import project2.achievers.Entities.Items;
import project2.achievers.Entities.ShoppingList;

import project2.achievers.utilities.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImp implements CustomerDao {


    @Override
    public List<ShoppingList> getAllCompletedLists(int customerId) {
        try (Connection connection = DatabaseConnection.createConnection()) {
            String sql = "select * from shopping_list where list_status = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "Completed");
            ResultSet resultSet = preparedStatement.executeQuery();
            List<ShoppingList> shoppingLists = new ArrayList<>();
            while (resultSet.next()) {
                ShoppingList shoppingList = new ShoppingList(
                        resultSet.getInt("shopping_list_id"),
                        resultSet.getString("shopping_list_name"),
                        resultSet.getString("customer_comments"),
                        resultSet.getString("shopper_comments"),
                        resultSet.getString("list_status"),
                        resultSet.getInt("customer_id"),
                        resultSet.getInt("shopper_id")

                );

                shoppingLists.add(shoppingList);
            }

            return shoppingLists;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }


    }

    @Override
    public boolean deleteShoppingList(int shoppingListId) {
        try (Connection connection = DatabaseConnection.createConnection()) {
            String sql = "delete from shopping_list where shopping_list_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, shoppingListId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();

        }

        return true;
    }

    @Override
    public List<ShoppingList> getAllShoppingLists(int customerId) {
        try (Connection connection = DatabaseConnection.createConnection()) {
            String sql = "select * from shopping_list where customer_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, customerId);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<ShoppingList> shoppingLists = new ArrayList<>();
            while (resultSet.next()) {
                ShoppingList shoppingList = new ShoppingList(
                        resultSet.getInt("shopping_list_id"),
                        resultSet.getString("shopping_list_name"),
                        resultSet.getString("customer_comments"),
                        resultSet.getString("shopper_comments"),
                        resultSet.getString("list_status"),
                        resultSet.getInt("customer_id"),
                        resultSet.getInt("shopper_id")

                );

                shoppingLists.add(shoppingList);
            }

            return shoppingLists;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }


    }

    @Override
    public Items createItems(Items items) {
        try (Connection connection = DatabaseConnection.createConnection()) {
            String sql = "insert into items values(default,?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, items.getItemName());
            preparedStatement.setInt(2, items.getItemQuantity());
            preparedStatement.setInt(3, items.getShoppingListId());
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();
            items.setItemId(resultSet.getInt("item_id"));
            return items;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean deleteItems(int itemId) {
        try (Connection connection = DatabaseConnection.createConnection()) {
            String sql = "delete from items  where item_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, itemId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;

    }

    @Override
    public List<ShoppingList> getAllIncompleteLists(int customerId) {
        try (Connection connection = DatabaseConnection.createConnection()) {
            String sql = "select * from shopping_list where list_status = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "Incomplete");
            ResultSet resultSet = preparedStatement.executeQuery();
            List<ShoppingList> shoppingLists = new ArrayList<>();
            while (resultSet.next()) {
                ShoppingList shoppingList = new ShoppingList(
                        resultSet.getInt("shopping_list_id"),
                        resultSet.getString("shopping_list_name"),
                        resultSet.getString("customer_comments"),
                        resultSet.getString("shopper_comments"),
                        resultSet.getString("list_status"),
                        resultSet.getInt("customer_id"),
                        resultSet.getInt("shopper_id")

                );

                shoppingLists.add(shoppingList);
            }

            return shoppingLists;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }


    }

    @Override
    public Customer createCustomer(Customer customer) {
        try (Connection connection = DatabaseConnection.createConnection()){
            String sql = "insert into customers values(default, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, customer.getCustomerName());
            preparedStatement.setString(2, customer.getCustomerUsername());
            preparedStatement.setString(3, customer.getCustomerPassword());
            preparedStatement.setInt(4, customer.getCustomerZipCode());
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();
            customer.setCustomerId(resultSet.getInt("customer_id"));
            return customer;

        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ShoppingList createShoppingList(ShoppingList shoppingList) {
        try (Connection connection = DatabaseConnection.createConnection()){
            String sql = "insert into shopping_list values(default, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, shoppingList.getShoppingListName());
            preparedStatement.setString(2, shoppingList.getCustomerComments());
            preparedStatement.setString(3, shoppingList.getShopperComments());
            preparedStatement.setString(4, "Incomplete");
            preparedStatement.setInt(5, shoppingList.getCustomerId());
            preparedStatement.setInt(6, shoppingList.getShopperId());
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();
            shoppingList.setShoppingListId(resultSet.getInt("shopping_list_id"));
            return shoppingList;

        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Customer getLoginByCredentials(String username, String password) {
        try (Connection connection = DatabaseConnection.createConnection()){
            String sql = "select * from customers where customer_username= ? and customer_password= ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            Customer customerLogin= new Customer();
            customerLogin.setCustomerZipCode(resultSet.getInt("customer_zip_code"));
            customerLogin.setCustomerName(resultSet.getString("customer_name"));
            customerLogin.setCustomerUsername(resultSet.getString("customer_username"));
            customerLogin.setCustomerPassword(resultSet.getString("customer_password"));
            customerLogin.setCustomerId(resultSet.getInt("customer_id"));
            return customerLogin;

        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    }























