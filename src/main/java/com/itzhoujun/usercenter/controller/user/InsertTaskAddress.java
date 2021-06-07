package com.itzhoujun.usercenter.controller.user;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import net.sf.json.JSONObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertTaskAddress {

    public static int inertTaskadd(JSONObject cusAddress, Connection con){
        PreparedStatement psql = null;
        String province = "";
        String city = "";
        String dist = "";
        String address = "";
        String latitude = "";
        String longilati = "";
        String cusNo = "";
        try {
            if (cusAddress.size() != 0) {
                if (cusAddress.has("province")) {
                    province = cusAddress.getString("province");
                }
                if (cusAddress.has("city")) {
                    city = cusAddress.getString("city");
                }
                if (cusAddress.has("dist")) {
                    dist = cusAddress.getString("dist");
                }
                if (cusAddress.has("address")) {
                    address = cusAddress.getString("address");
                }
                if (cusAddress.has("latitude")) {
                    if(!cusAddress.getString("latitude").equals("")||cusAddress.getString("latitude")!=""){
                        latitude = cusAddress.getString("latitude");//获取纬度
                    }else {
                        latitude = "24.32587";
                    }

                }
                if (cusAddress.has("longitude")) {

                    if(!cusAddress.getString("longitude").equals("")||cusAddress.getString("longitude")!=""){
                        longilati = cusAddress.getString("longitude");//获取经度
                    }else {
                        longilati = "109.447233";
                    }
                }
                if (cusAddress.has("cusNo")) {
                    cusNo = cusAddress.getString("cusNo");
                }
            }
            psql = con.prepareStatement("insert into customeraddress (adProvince,adCity,adDist,adAddress,adLatitude,adLongitude,cusNo) value (?,?,?,?,?,?,?)");
            psql.setString(1, province);
            psql.setString(2, city);
            psql.setString(3, dist);
            psql.setString(4, address);
            psql.setString(5, latitude);
            psql.setString(6, longilati);
            psql.setString(7, cusNo);
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
