/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeemanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


/**
 *
 * @author Dilanka
 */
public class DBOperations {
    
    String url="jdbc:mysql://localhost:3306/employee";
    String username="root";
    String password="";
    Connection con=null;
    PreparedStatement pst=null;
    boolean addEmployee(EmployeeDetails em)
    {
    try{ 
    con=(Connection)DriverManager.getConnection(url, username, password);//get the connection
    String query="Insert into employeedetails Values(?,?,?,?,?,?,?,?)";
    pst = (PreparedStatement)con.prepareStatement(query);
    
    pst.setInt(1,em.getRegID());        //add values to sql query.
    pst.setString(2,em.getFirstName());
    pst.setString(3,em.getLastName());
    pst.setInt(4,em.getAge());
    pst.setString(5, em.getCountry());
    pst.setString(6, em.getEmail());
    pst.setString(7, em.getUsername());
    pst.setString(8, em.getPassword());
    
    pst.executeUpdate();  //excecute the sql query and insert the values to db table.
    
    return true;
    }
    catch(Exception e)
    {
    System.out.print(e);
    return false;
    }
    finally{
    try{
    if(pst!=null){
        pst.close();
    }
    }
    catch(Exception e){
    
    }
    }
    
    
    }
}
