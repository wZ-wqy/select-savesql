package com.itzhoujun.usercenter.controller.user;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import java.sql.*;


public class SelectSql {

    private static final String url = "jdbc:mysql://localhost:3306/shouhoubao?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=UTC&autoReconnect=true";
    private static final String user = "root";
    private static final String password = "123456";
    private static Connection con;
    static Connection getconnect()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return con;
    }
    public static String selectsql(Connection con,String sqlst)//插入数据进入数据库中
    {
        String res = null;
        try
        {
            Statement statement = con.createStatement();
//            执行查询语句
            PreparedStatement pst=con.prepareStatement("select taskNo from task where taskNo = ?");
            pst.setString(1,sqlst);
            ResultSet resultSet = pst.executeQuery();
            while(resultSet.next()) {
                res =resultSet.getString("taskNo");
            }


        } catch (JsonIOException e1) {
            e1.printStackTrace();
        } catch (JsonSyntaxException e1) {
            e1.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return res;


    }




}
