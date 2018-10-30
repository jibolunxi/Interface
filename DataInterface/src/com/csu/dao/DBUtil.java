package com.csu.dao;

import java.sql.*;

public class DBUtil
{
    private static String con1="com.mysql.jdbc.Driver";
    private static String con2="jdbc:mysql://localhost:3306/test";
    private static String sql_admin="root";
    private static String sql_password="********";
    //连接
    public  static Connection ConDB()
    {
        Connection connection=null;
        try {
            Class.forName(con1);
            connection = DriverManager.getConnection(con2,sql_admin,sql_password);
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public static void closeStatement(Statement statement)throws Exception
    {
        statement.close();
    }

    public static void closePreparedStatement(PreparedStatement pStatement)throws Exception
    {
        pStatement.close();
    }

    public static void closeResultSet(ResultSet resultSet)throws Exception
    {
        resultSet.close();
    }

    public static void closeConnection(Connection connection)throws Exception
    {
        connection.close();
    }

    public static void main(String[] args)throws Exception
    {
        Connection conn=DBUtil.ConDB();
        System.out.println(conn);
    }
}
