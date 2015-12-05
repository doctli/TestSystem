package cn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by doctli on 2015/11/26.
 */
public class DB {
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private String classname="com.mysql.jdbc.Driver";
    private String url="jdbc:mysql://localhost/testmanage";
    public DB(){}
    public Connection getConnection(){//建立连接
        try{
            Class.forName(classname);
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        try {
            connection= DriverManager.getConnection(url,"root","1258");
        }
        catch (Exception e){
            e.printStackTrace(System.err);
            connection=null;
        }
        return connection;
    }
    public Statement getStatement(){//创建语句
        try{
            connection=getConnection();
            statement=connection.createStatement();
        }
        catch (Exception e){
            e.printStackTrace(System.err);
        }
        return statement;
    }
    public ResultSet search(String sql){//执行查询语句
        getStatement();
        try {
            resultSet=statement.executeQuery(sql);
        }
        catch (Exception e){
            e.printStackTrace(System.err);
        }
        return resultSet;
    }
    public void update(String sql){//执行更新语句
        getStatement();
        try{
            statement.executeUpdate(sql);
        }
        catch (Exception e){
            e.printStackTrace(System.err);
        }
    }
}
