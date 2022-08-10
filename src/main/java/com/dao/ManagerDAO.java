package com.dao;

import com.connection.MySQLConnectionUtility;
import com.model.Address;
import com.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ManagerDAO {
    public void addUser(User user){
        Connection connection = MySQLConnectionUtility.getConnection();
        String sql = "insert into User values(?,?,?,?,?)";
        try{
            PreparedStatement ps =connection.prepareStatement(sql);
            ps.setInt(1,user.getId());
            ps.setString(2,user.getName());
            ps.setString(3,user.getGender());
            ps.setInt(4,user.getAddressId());
            ps.setString(5, user.getDob());
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Exception found");
        }

    }
    public void updateUser(User user){
        Connection connection = MySQLConnectionUtility.getConnection();
        String sql = "update user set name=?,gender=?,addressId=?,dob=? where id=?";
        try{
            PreparedStatement ps =connection.prepareStatement(sql);
            ps.setString(1,user.getName());
            ps.setString(2,user.getGender());
            ps.setInt(3, user.getAddressId());
            ps.setString(4, user.getDob());
            ps.setInt(5,user.getId());
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Exception found");
        }
    }
    public void addAddress(Address address){
        Connection connection = MySQLConnectionUtility.getConnection();
        String sql = "insert into Address values(?,?,?,?)";
        try{
            PreparedStatement ps =connection.prepareStatement(sql);
            ps.setInt(1,address.getId());
            ps.setString(2,address.getStreet());
            ps.setString(3,address.getCity());
            ps.setString(4,address.getState());
            ps.execute();
        }
        catch (SQLException e) {
            System.out.println("Exception found");
        }
    }
    public void deleteUser(int id){
        Connection connection = MySQLConnectionUtility.getConnection();
        String sql = "DELETE FROM user WHERE id=?";
        try{
            PreparedStatement ps =connection.prepareStatement(sql);
            ps.setInt(1,id);
            ps.execute();
        }
        catch (SQLException e) {
            System.out.println("Exception found");
        }
    }
    public List<Address> getUserAddress(int id){
        List<Address> addressList=new ArrayList<>();
        Connection connection=MySQLConnectionUtility.getConnection();
        String sql="select * from address where id in (select addressId from user where id='"+id+"')";
        try{
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(sql);
            while(resultSet.next()){
                int addressId=resultSet.getInt("id");
                String street=resultSet.getString("street");
                String city=resultSet.getString("city");
                String state=resultSet.getString("state");
                addressList.add(new Address(addressId,street,city,state));
            }
        }
        catch (SQLException e){
            System.out.println("Exception found");
        }
        return addressList;
    }
}
