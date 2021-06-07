package com.itzhoujun.usercenter.controller.user;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteSql {
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
    public static int deletes(Connection con, String strs)//删除一条重复数据
    {
        int i = 0;

        try
        {
            PreparedStatement stmt=con.prepareStatement("delete from gongdanlist where gdid = ?");
            stmt.setString(1,strs);
            i = stmt.executeUpdate();

        } catch (JsonIOException e1) {
            e1.printStackTrace();
        } catch (JsonSyntaxException e1) {
            e1.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }




}
