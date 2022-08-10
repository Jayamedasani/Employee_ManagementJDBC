package org.example;
import org.example.DAO.AddressDAO;
import org.example.DAO.DepartmentDAO;
import org.example.DAO.EmployeeDAO;
import org.example.models.Address;
import org.example.models.Department;
import org.example.models.Employee;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true) {
            System.out.println("1.Display Employees");
            System.out.println("2.Display Departments");
            System.out.println("3.Get Employee Address");
            System.out.println("4.Update Employee");
            System.out.println("5.Delete Employee");
            System.out.println("6.Add Employee");
            System.out.println("7.Exit");
            System.out.print("Enter Your Choice");
            Scanner sc = new Scanner(System.in);
            EmployeeDAO employeeDAO = new EmployeeDAO();
            DepartmentDAO departmentDAO = new DepartmentDAO();
            AddressDAO addressDAO = new AddressDAO();
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    List<Employee> employeeList = new ArrayList<>();
                    employeeList = employeeDAO.getEmployee();
                    for (Employee employee : employeeList) {
                        System.out.println("EmployeeID:" + employee.getId() + "\tEmployeeName:" + employee.getName() + "\tEmployeeAge:" + employee.getAge() + "\tEmployeeDeptID:" + employee.getDepartment_id());
                    }
                    break;
                case 2:
                    List<Department> deptlist = new ArrayList<>();
                    deptlist = departmentDAO.getDepartment();
                    for (Department department : deptlist) {
                        System.out.println("DepartmentID:" + department.getId() + "\tDepartmentName:" + department.getName());
                    }
                    break;
                case 3:
                    List<Address> addresslist = new ArrayList<>();
                    System.out.println("Enter Employee ID to get Address:");
                    int emp_id = sc.nextInt();
                    addresslist = addressDAO.getEmployeeAddress(emp_id);
                    System.out.println("Employee" + emp_id + " Address:");
                    for (Address address : addresslist) {
                        System.out.println("AddressID:" + address.getId() + "\tHouse NUM:" + address.getHouseno() + "\tStreet:" + address.getStreet() + "\tCity:" + address.getCity() + "\tState:" + address.getState());
                    }
                    break;
                case 4:
                    System.out.println("Enter Employee ID to Update:");
                    int id= sc.nextInt();
                    System.out.println("Enter Updated employee name:");
                    String name= sc.next();
                    System.out.println("Enter updated employee age:");
                    int age= sc.nextInt();
                    System.out.println("Enter Upadted employee departmentId:");
                    int deptID= sc.nextInt();
                    Employee employee=new Employee(id,name,age,deptID);
                    employeeDAO.updateEmployee(employee);
                    break;
                case 5:
                    System.out.println("Enter employee id to delete:");
                    int empid= sc.nextInt();
                    employeeDAO.deleteEmployee(empid);
                    break;
                case 6:
                    System.out.println("Enter EmployeeID:");
                    int eid= sc.nextInt();
                    System.out.println("Enter Employee name:");
                    String empname= sc.next();
                    System.out.println("Enter Employee Age:");
                    int empage= sc.nextInt();
                    System.out.println("Enter Employee DepartmentID");
                    int deptId= sc.nextInt();
                    Employee emp=new Employee(eid,empname,empage,deptId);
                    employeeDAO.addEmployee(emp);
                    break;
                case 7:
                    System.out.println("ThankYou!!");
                    System.exit(1);
                default:
                    System.out.println("Enter Valid Choice");
            }
        }
    }
}