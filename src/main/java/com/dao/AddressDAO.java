package com.dao;

import com.connection.MySQLConnectionUtility;
import com.model.Address;
import com.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AddressDAO {
public List<Address> getAddress(){
    List<Address> addressList = new ArrayList<>();
    Connection connection = MySQLConnectionUtility.getConnection();
    try {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM address");
        while(resultSet.next()) {
            int id = resultSet.getInt("ID");
            String street = resultSet.getString("STREET");
            String city=resultSet.getString("CITY");
            String state=resultSet.getString("STATE");
            addressList.add(new Address(id,street,city,state));
        }
    } catch (SQLException e) {
        System.out.println("Exception found");
    }
    return addressList;
}
}
