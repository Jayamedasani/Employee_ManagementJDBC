package org.example.DAO;

import org.example.connection.MySQLConnection;
import org.example.models.Address;
import org.example.models.Employee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AddressDAO {
    public List<Address> getEmployeeAddress(int id){
        List<Address> addresslist=new ArrayList<>();
        Connection connection= MySQLConnection.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM address where employee_id="+id);
            while (resultSet.next()) {
                int emp_id = resultSet.getInt("employee_id");
                int address_id=resultSet.getInt("id");
                String houseno = resultSet.getString("house_no");
                String street=resultSet.getString("street");
                String city=resultSet.getString("city");
                String state=resultSet.getString("state");
                addresslist.add(new Address(address_id,emp_id,houseno,street,city,state));
            }
        }
        catch (SQLException e){
            System.out.println("can't execute query");
        }
        return addresslist;
    }
}
