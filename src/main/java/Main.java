import com.dao.AddressDAO;
import com.dao.ManagerDAO;
import com.dao.UserDAO;
import com.model.Address;
import com.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AddressDAO addressDAO = new AddressDAO();
        ManagerDAO managerDAO = new ManagerDAO();
        UserDAO userDAO = new UserDAO();
        System.out.println("1.Add User");
        System.out.println("2.Update User");
        System.out.println("3.Delete User");
        System.out.println("4.Search User");
        System.out.println("5.Display Users");
        System.out.println("6.Add Address");
        System.out.println("7.Display Address");
        System.out.println("8.Get User Address");
        System.out.println("9.Exit");
        System.out.print("Enter Your Choice:");
        int n = sc.nextInt();
        while (n != 9) {
            switch (n) {
                case 1:
                    //System.out.println("add user");
                    System.out.print("Enter UserID:");
                    int id= sc.nextInt();
                    System.out.print("Enter User Name:");
                    String name= sc.next();
                    System.out.print("Enter User DOB:");
                    String dob= sc.next();
                    System.out.print("Enter User AddressID:");
                    int addressId= sc.nextInt();
                    System.out.print("Enter User Gender:");
                    String gender=sc.next();
                    managerDAO.addUser(new User(id,name,gender,addressId,dob));
                    System.out.print("Enter Your Choice:");
                    n = sc.nextInt();
                    break;
                case 2:
                    //System.out.println("update user");
                    System.out.println("Enter user id whose details you want to update:");
                    id=sc.nextInt();
                    System.out.println("Enter updated user name:");
                    name= sc.next();
                    System.out.println("Enter updated gender");
                    gender=sc.next();
                    System.out.println("Enter updated address Id");
                    addressId=sc.nextInt();
                    System.out.println("Enter updated dob");
                    dob=sc.next();
                    managerDAO.updateUser(new User(id,name,gender,addressId,dob));
                    System.out.print("Enter Your Choice:");
                    n = sc.nextInt();
                    break;
                case 3:
                    //System.out.println("delete user");
                    System.out.println("Enter user id whose record you want to delete");
                    id=sc.nextInt();
                    managerDAO.deleteUser(id);
                    System.out.print("Enter Your Choice:");
                    n = sc.nextInt();
                    break;
                case 4:
                    //System.out.println("search user");
                    System.out.println("Enter user name whom you want to search");
                    String username=sc.next();
                    List<User> matchUserList=userDAO.searchUser(username);
                    for(User matchedUser: matchUserList){
                        System.out.println("ID:"+matchedUser.getId()+"\tName:"+matchedUser.getName()+"\tGender:"+matchedUser.getGender()+"\tAddressID:"+matchedUser.getAddressId()+"\tDOB:"+matchedUser.getDob());
                    }
                    System.out.print("Enter Your Choice:");
                    n = sc.nextInt();
                    break;
                case 5:
                    //System.out.println("display user");
                    List<User> usersList=userDAO.getUsers();
                    for(User users:usersList){
                        System.out.println("UserID:"+users.getId()+"\tUserName:"+users.getName()+"\tUserGender"+users.getGender()+"\tUserAddressID"+users.getAddressId()+"\tUserDob"+users.getDob());
                    }
                    System.out.print("Enter Your Choice:");
                    n = sc.nextInt();
                    break;
                case 6:
                    //System.out.println("add address");
                    System.out.print("Enter Address ID:");
                    int Id= sc.nextInt();
                    System.out.print("Enter Address Street:");
                    String Street= sc.next();
                    System.out.print("Enter Address City:");
                    String City= sc.next();
                    System.out.print("Enter Address State:");
                    String State=sc.next();
                    managerDAO.addAddress(new Address(Id,Street,City,State));
                    System.out.print("Enter Your Choice:");
                    n = sc.nextInt();
                    break;
                case 7:
                    //System.out.println("display address");
                    List<Address> addressList=addressDAO.getAddress();
                    for(Address address:addressList){
                        System.out.println("ID:"+address.getId()+"\tStreet:"+address.getStreet()+"\tCity"+address.getCity()+"\tState"+address.getState());
                    }
                    System.out.print("Enter Your Choice:");
                    n = sc.nextInt();
                    break;
                case 8:
                    //System.out.println("get user address");
                    System.out.println("Enter user id whose details you want to fetch:");
                    id=sc.nextInt();
                    addressList=managerDAO.getUserAddress(id);
                    for(Address address:addressList){
                        System.out.println("ID:"+address.getId()+"\tStreet:"+address.getStreet()+"\tCity"+address.getCity()+"\tState"+address.getState());
                    }
                    System.out.print("Enter Your Choice:");
                    n = sc.nextInt();
                    break;
                default:
                    System.out.println("Enter valid choice");
                    System.out.print("Enter Your Choice:");
                    n = sc.nextInt();
                    break;
            }
        }
    }
}