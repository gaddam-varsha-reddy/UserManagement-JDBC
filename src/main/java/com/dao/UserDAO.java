package com.dao;

import com.connection.MySQLConnectionUtility;
import com.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
 public List<User> getUsers(){
     List<User> userList = new ArrayList<>();
     Connection connection = MySQLConnectionUtility.getConnection();
     try {
         Statement statement = connection.createStatement();
         ResultSet resultSet = statement.executeQuery("SELECT * FROM User");
         while(resultSet.next()) {

             int id = resultSet.getInt("ID");
             String name = resultSet.getString("NAME");
             String gender=resultSet.getString("GENDER");
             int addressId=resultSet.getInt("ADDRESSID");
             String dob=resultSet.getString("DOB");
             userList.add(new User(id, name,gender,addressId,dob));
         }
     } catch (SQLException e) {
         System.out.println("Exception found");
     }
     return userList;
 }
 public List<User> searchUser(String username){
     List<User> searchList=new ArrayList<>();
     Connection connection=MySQLConnectionUtility.getConnection();
     String sql="select * from user where name like ?";
     try{
         PreparedStatement statement=connection.prepareStatement(sql);
         statement.setString(1,username);
         ResultSet resultSet=statement.executeQuery();
         while(resultSet.next()){
             int id=resultSet.getInt("id");
             String name=resultSet.getString("name");
             String gender=resultSet.getString("gender");
             int addressID=resultSet.getInt("addressId");
             String dob=resultSet.getString("dob");
             searchList.add(new User(id,name,gender,addressID,dob));
         }
     }
     catch (SQLException e){
         System.out.println("Can't Execute Query");
         e.printStackTrace();
     }
     return searchList;
 }
}
