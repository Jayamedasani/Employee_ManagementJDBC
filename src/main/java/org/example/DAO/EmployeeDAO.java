package org.example.DAO;

import org.example.connection.MySQLConnection;
import org.example.models.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    public List<Employee> getEmployee(){
        List<Employee> employeelist=new ArrayList<>();
        Connection connection= MySQLConnection.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM employee");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                int department_id = resultSet.getInt("department_id");
                employeelist.add(new Employee(id, name, age, department_id));
            }
        }
        catch (SQLException e){
            System.out.println("can't execute query");
        }
        return employeelist;
    }
    public void updateEmployee(Employee employee){
        Connection connection= MySQLConnection.getConnection();
        String sql="update employee set name=?,age=?,department_id=? where id=?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, employee.getName());
            statement.setInt(2,employee.getAge());
            statement.setInt(3,employee.getDepartment_id());
            statement.setInt(4,employee.getId());
            int result=statement.executeUpdate();
            System.out.println(result+" records affected");
        }
        catch (SQLException e){
            System.out.println("can't execute query");
            e.printStackTrace();
        }
    }
    public void deleteEmployee(int id){
        Connection connection= MySQLConnection.getConnection();
        String sql="delete from employee where id="+id;
        //Can't delete before 5 because of foreign key constrain
        try{
            Statement statement = connection.createStatement();
            int result=statement.executeUpdate(sql);
            System.out.println(result+" records affected");
        }
        catch (SQLException e){
            System.out.println("can't execute query");
        }
    }
    public void addEmployee(Employee employee){
        Connection connection= MySQLConnection.getConnection();
        String sql="insert into employee values(?,?,?,?)";
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,employee.getId());
            statement.setString(2,employee.getName());
            statement.setInt(3,employee.getAge());
            statement.setInt(4,employee.getDepartment_id());
            int result=statement.executeUpdate();
            System.out.println(result+" records affected");
        }
        catch (SQLException e){
            System.out.println("can't execute query");
        }
    }
}
