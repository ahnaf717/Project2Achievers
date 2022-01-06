package project2.achievers.DAO.shopper;

import project2.achievers.Entities.Shopper;
import project2.achievers.utilities.DatabaseConnection;

import java.sql.Connection;
import java.sql.*;

public class ShopperDaoImp implements ShopperDao{
    @Override
    public Shopper createShopper(Shopper shopper) {
        try (Connection connection = DatabaseConnection.createConnection()){
            String sql = "insert into shoppers values(default, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, shopper.getShopperName());
            preparedStatement.setString(2, shopper.getShopperUsername());
            preparedStatement.setString(3, shopper.getShopperPassword());
            preparedStatement.setInt(4, shopper.getShopperZipCode());
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();
            shopper.setShopperId(resultSet.getInt("shopper_id"));
            return shopper;

        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public Shopper getShopperLoginByCredentials(String username, String password) {
        try(Connection connection = DatabaseConnection.createConnection()){
            String sql = "select * from shoppers where shopper_username= ? and shopper_password= ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            Shopper shopperLogin = new Shopper();
            shopperLogin.setShopperZipCode(resultSet.getInt("shopper_zip_code"));
            shopperLogin.setShopperName(resultSet.getString("shopper_name"));
            shopperLogin.setShopperUsername(resultSet.getString("shopper_username"));
            shopperLogin.setShopperPassword(resultSet.getString("shopper_password"));
            shopperLogin.setShopperId(resultSet.getInt("shopper_id"));
            return shopperLogin;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    }

