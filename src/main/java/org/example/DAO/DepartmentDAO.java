package org.example.DAO;

import org.example.connection.MySQLConnection;
import org.example.models.Department;
import org.example.models.Employee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAO {
    public List<Department> getDepartment(){
        List<Department> deptlist=new ArrayList<>();
        Connection connection= MySQLConnection.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM department");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                deptlist.add(new Department(id, name));
            }
        }
        catch (SQLException e){
            System.out.println("can't execute query");
        }
        return deptlist;
    }
}
