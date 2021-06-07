package com.itzhoujun.usercenter.controller.user;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import net.sf.json.JSONObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertTaskProducts {

    public static int inertTaskPro(JSONObject cusAddress, Connection con){
        PreparedStatement psql = null;
        String productsId = "";
        String name = "";
        String type = "";
        String serialNumber = "";
        String taskNo = "";
        try {
            if (cusAddress.size() != 0) {
                if (cusAddress.has("productsId")) {
                    productsId = cusAddress.getString("productsId");
                }
                if (cusAddress.has("name")) {
                    name = cusAddress.getString("name");
                }
                if (cusAddress.has("type")) {
                    type = cusAddress.getString("type");
                }
                if (cusAddress.has("serialNumber")) {
                    serialNumber = cusAddress.getString("serialNumber");
                }
                if (cusAddress.has("taskNo")) {
                    taskNo = cusAddress.getString("taskNo");//获取经纬度
                }
            }
            psql = con.prepareStatement("insert into taskproducts (productsId,name,type,serialNumber,taskNo) value (?,?,?,?,?)");
            psql.setString(1, productsId);
            psql.setString(2, name);
            psql.setString(3, type);
            psql.setString(4, serialNumber);
            psql.setString(5, taskNo);
            psql.executeUpdate();


        }
        catch (JsonIOException e1) {
            e1.printStackTrace();
        } catch (JsonSyntaxException e1) {
            e1.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 1;
    }





}
