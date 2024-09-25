package PasswordManagerClasses;

import java.sql.*;
public class Conn {

    Connection c;
    Statement s;
    public Conn(){
        try{
            c=DriverManager.getConnection("jdbc:mysql:///PasswordManager","root","Anish@100%");
            s=c.createStatement();

        }catch(Exception e){
            System.out.println(e);
        }
    }
}