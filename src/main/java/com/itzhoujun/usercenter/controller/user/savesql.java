package com.itzhoujun.usercenter.controller.user;

import com.google.gson.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.sql.*;

public class savesql {

    private static final String url = "jdbc:mysql://localhost:3306/shouhoubao?autoReconnect=true&useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=UTC&autoReconnect=true";
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
    public static void moreinsertdata( String[] strs)//插入数据进入数据库中
    {
        System.out.println("进入存储过程");
        Connection con = savesql.getconnect();
        JSONObject js = null;
        try {
            PreparedStatement psql = null;
            for (int i = 1; i < strs.length; i++) {
                String a = "\"{\\\"";
                String db = (a + "acceptTime" + strs[i]);
                String dbst = db.substring(0, db.length() - 4);
                dbst = (dbst + "\"");
                String abcd = dbst.replace("\\", "");
                String asd = abcd.substring(0, abcd.length() - 1);
                String zxc = asd.substring(1);
                String qwe = String.valueOf(zxc.charAt(zxc.length() - 1));
                if (qwe != "}") {
                    zxc = (zxc + "}");
                }
                js = JSONObject.fromObject(zxc);


                String taskNo = js.getString("taskNo");//获取工单编号
                String product = js.getString("products");//获取产品
                String attr = js.getString("attribute");//获取列表属性

//                if(taskNo.equals("TEO0820030946")||taskNo=="TEO0820030946"){
//                    String jsrre = js.toString();
//                    gongdanliebiao.writeTXT("G:\\","jshou",jsrre);
//
//                }else{
//                    continue;
//                }
                String exename = js.getString("executorName");
                if (exename == "邓玉红" || exename == "覃雨虹"|| exename == "陈秋霖") {
                    continue;
                }
                String prd1 = String.valueOf(product.charAt(0));
                String prd2 = String.valueOf(product.charAt(product.length() - 1));
                String qkh1;
                String qkh2 = product;
                if (prd1 == "[" || prd1.equals("[") || prd2 == "]" || prd2.equals("]")) {
                    qkh1 = product.substring(0, product.length() - 1);
                    qkh2 = qkh1.substring(1);
                }
                JSONObject attrjs = JSONObject.fromObject(attr);
                if (attrjs.containsKey("field_WkPSEnpLcsvrDR5q")) {
                    String DR5q = attrjs.getString("field_WkPSEnpLcsvrDR5q");
                    if (DR5q == "网站信息发布" || DR5q.equals("网站信息发布")) {
                        continue;
                    }
                }
                if (attrjs.containsKey("field_pzxjFjDJQHRez8bg")) {
                    String ez8bg = attrjs.getString("field_pzxjFjDJQHRez8bg");
                    if (ez8bg == "网站日常信息发布" || ez8bg.equals("网站日常信息发布")) {
                        continue;
                    }
                }
                if (qkh2.length() != 0) {
                    JSONObject jsobj = JSONObject.fromObject(qkh2);
                    String name = jsobj.getString("name");
                    if (name == "网站信息发布" && name.equals("网站信息发布")) {
                        continue;
                    }
                }
                String selec = SelectSql.selectsql(con, taskNo);
                if (selec != null) {
                    System.out.println("数据已存在");
                    continue;
                }
                if (js.containsKey("completeTime") && js.getString("completeTime") != null) {
                    String acceptTime = js.getString("acceptTime");//获取创建时间
                    Long accTime = Long.parseLong(acceptTime) / 1000;
                    String allotTime = js.getString("allotTime");//获取指派时间
                    Long alloTime = Long.parseLong(allotTime) / 1000;
                    String completeTime = js.getString("completeTime");
                    Long compTime = Long.parseLong(completeTime) / 1000;
                    String createTime = js.getString("createTime");
                    Long creTime = Long.parseLong(createTime) / 1000;
                    String startTime = js.getString("startTime");
                    Long staTime = Long.parseLong(startTime) / 1000;
                    String updateTime = js.getString("updateTime");
                    Long updaTime = Long.parseLong(updateTime) / 1000;
                    Long balTime = 0L;
                    Long cloTime = 0L;
                    if(js.containsKey("closeTime")&&js.getString("closeTime") != null){
                        String balanceTime = js.getString("balanceTime");
                        balTime = Long.parseLong(balanceTime) / 1000;
                        String closeTime = js.getString("closeTime");
                        cloTime = Long.parseLong(closeTime) / 1000;
                    }

                    String createUserName = "";//创建人
                    String cusName = "";
                    String cusNo = "";
                    String executorName = "";
                    String level = "";
                    String lmName = "";
                    String lmPhone = "";
                    String planTime = "";
                    String productIds = "";
                    String serviceContent = "";
                    String state = "";
                    String synergyNames = "";
                    String templateId = "";
                    String templateName = "";
                    JSONObject add = js.getJSONObject("cusAddress");
                    add.accumulate("cusNo",js.getString("cusNo"));
                    JSONArray prod = JSONArray.fromObject(js.getJSONArray("products"));
                    JSONObject pro = new JSONObject();
                    if(prod.size()!=0){
                        pro = prod.getJSONObject(0);
                        pro.accumulate("taskNo",js.getString("taskNo"));
                    }

                    attrjs.accumulate("taskNo",js.getString("taskNo"));
                    int ta = InsertTaskAttribute.insertTA(attrjs,con);
                    int ad = InsertTaskAddress.inertTaskadd(add,con);
                    int pr = InsertTaskProducts.inertTaskPro(pro,con);
                    if (js.containsKey("createUserName")) {
                        createUserName = js.getString("createUserName");//获取创建人
                    }
                    if (js.containsKey("cusName")) {
                        cusName = js.getString("cusName");//获取客户名
                    }
                    if (js.containsKey("cusNo")) {
                        cusNo = js.getString("cusNo");//获取客户编号
                    }
                    if (js.containsKey("executorName")) {
                        executorName = js.getString("executorName");//获取负责人
                    }
                    if (js.containsKey("level")) {
                        level = js.getString("level");//获取优先级
                    }
                    if (js.containsKey("lmName")) {
                        lmName = js.getString("lmName");//获取联系人
                    }
                    if (js.containsKey("lmPhone")) {
                        lmPhone = js.getString("lmPhone");//获取电话
                    }
                    if (js.containsKey("planTime")) {
                        planTime = js.getString("planTime");//获取计划时间
                    }
                    if (js.containsKey("productIds")) {
                        productIds = js.getString("productIds");//获取产品ID
                    }
                    if (js.containsKey("serviceContent")) {
                            serviceContent = js.getString("serviceContent");//服务内容
                    }
                    if (js.containsKey("state")) {
                        state = js.getString("state");//获取工单状态
                    }
                    if (js.containsKey("synergyNames")) {
                        synergyNames = js.getString("synergyNames");//获取协同人
                    }
                    if (js.containsKey("templateId")) {
                        templateId = js.getString("templateId");//获取满意度
                    }
                    if (js.containsKey("templateName")) {
                        templateName = js.getString("templateName");//获取工单类型
                    }
                    String list = js.toString();
                    psql = con.prepareStatement("insert into task (acceptTime,allotTime,completeTime,createTime,createUserName,cusName,cusNo, executorName,level,lmName,lmPhone,planTime,productIds,serviceContent,startTime,state,synergyNames,taskNo,templateId,templateName,updateTime,balanceTime,closeTime) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                    psql.setLong(1, accTime);
                    psql.setLong(2, alloTime);
                    psql.setLong(3, compTime);
                    psql.setLong(4, creTime);
                    psql.setString(5, createUserName);
                    psql.setString(6, cusName);
                    psql.setString(7, cusNo);
                    psql.setString(8, executorName);
                    psql.setString(9, level);
                    psql.setString(10, lmName);
                    psql.setString(11, lmPhone);
                    psql.setString(12, planTime);
                    psql.setString(13, productIds);
                    psql.setString(14, serviceContent);
                    psql.setLong(15, staTime);
                    psql.setString(16, state);
                    psql.setString(17, synergyNames);
                    psql.setString(18, taskNo);
                    psql.setString(19, templateId);
                    psql.setString(20, templateName);
                    psql.setLong(21, updaTime);
                    psql.setLong(22, balTime);
                    psql.setLong(23, cloTime);
                    psql.executeUpdate();
                    System.out.println("数据已保存");
                }
            }
            System.out.println("关闭数据库");

            con.close();

        } catch(JsonIOException e1){
            e1.printStackTrace();
        } catch(JsonSyntaxException e1){
            e1.printStackTrace();
        } catch(SQLException e){
            e.printStackTrace();
        }

    }
}

