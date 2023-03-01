package org.example;

import java.sql.*;
import java.util.logging.Logger;

public class Database {
    Connection con;
    private static Database t2=null;
    Logger l= Logger.getLogger("com.api.jar");

    private Database(){
    }

    public static Database getInstance()
    {
        if (t2 == null)
        {
            t2 = new Database();
        }
        return t2;
    }

    public void connect(String url, String user, String password) {
        try{
            con= DriverManager.getConnection(url,user,password);
        }
        catch(SQLException e){
            System.out.println(e);
        }

        l.info("Connection Created Successfully\n");
    }

    public void closeconnection() throws SQLException {
        con.close();
        l.info("Connection Closed Successfully\n");
    }
}
