package com.itzhoujun.usercenter.controller.user;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import net.sf.json.JSONObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertTaskAttribute {

    public static int insertTA(JSONObject att, Connection con){
        PreparedStatement psql = null;

        try {
            String taskNo = "";
            String customReceipt = "";
            String field_mw14ov4M09NQ6mFu = "";
            String field_vahTMFEJgz4riJy5 = "";
            String field_BKzX3eYzndTcLhkK = "";
            String field_1aKmjxaXXlEAHLeP = "";
            String field_TTb1jR2CzHrKpBCM = "";
            String field_pTlybqN5Lf1n14OJ = "";
            String field_ucUWJ2GBCTw2sEzu = "";
            String field_id0AudS1SKPyqb6H = "";
            String field_Hb9yHzXFuSRwAD0p = "";
            String field_OUmy82mWlKmk8Oac = "";
            String field_C5uxACkZr6spdqQ5 = "";
            String field_5Rk0VwrhvpowVZ2c = "";
            String field_Kp3R9ntn6wD0YFsS = "";
            String field_SrBt93INUCMXdOnp = "";
            String field_3AKvuOidKGMs8rYa = "";
            String paymentMethod = "";
            String field_xycfmIsIi7BhT4Gs = "";
            String field_0J2DCtsLEtZ0cjZq = "";
            String field_uYbYVezdQ23Fjzis = "";
            String field_h36G3FuKVEHsGp1W = "";
            String field_iPflqZaaUHXMhN3j = "";
            String field_mdMsQ4wPHGgf1MCk = "";
            String field_slkS2xmmH5nEkQ30 = "";
            String sparepart = "";
            String receiptAttachment = "";
            String serviceIterm = "";
            if (att.size() != 0) {
                if (att.containsKey("taskNo")) {
                    taskNo = att.getString("taskNo");
                }
                if (att.containsKey("customReceipt")) {
                    customReceipt = att.getString("customReceipt");
                }
                if (att.containsKey("field_mw14ov4M09NQ6mFu")) {
                    field_mw14ov4M09NQ6mFu = att.getString("field_mw14ov4M09NQ6mFu");
                }
                if (att.containsKey("field_vahTMFEJgz4riJy5")) {
                    field_vahTMFEJgz4riJy5 = att.getString("field_vahTMFEJgz4riJy5");
                }
                if (att.containsKey("field_BKzX3eYzndTcLhkK")) {
                    field_BKzX3eYzndTcLhkK = att.getString("field_BKzX3eYzndTcLhkK");
                }
                if (att.containsKey("field_1aKmjxaXXlEAHLeP")) {
                    field_1aKmjxaXXlEAHLeP = att.getString("field_1aKmjxaXXlEAHLeP");//获取经纬度
                }
                if (att.containsKey("field_TTb1jR2CzHrKpBCM")) {
                    field_TTb1jR2CzHrKpBCM = att.getString("field_TTb1jR2CzHrKpBCM");
                }
                if (att.containsKey("field_pTlybqN5Lf1n14OJ")) {
                    field_pTlybqN5Lf1n14OJ  = att.getString("field_pTlybqN5Lf1n14OJ");
                }
                if (att.containsKey("field_ucUWJ2GBCTw2sEzu")) {
                    field_ucUWJ2GBCTw2sEzu  = att.getString("field_ucUWJ2GBCTw2sEzu");
                }
                if (att.containsKey("field_id0AudS1SKPyqb6H")) {
                    field_id0AudS1SKPyqb6H  = att.getString("field_id0AudS1SKPyqb6H");
                }
                if (att.containsKey("field_Hb9yHzXFuSRwAD0p")) {
                    field_Hb9yHzXFuSRwAD0p  = att.getString("field_Hb9yHzXFuSRwAD0p");
                }
                if (att.containsKey("field_OUmy82mWlKmk8Oac")) {
                    field_OUmy82mWlKmk8Oac  = att.getString("field_OUmy82mWlKmk8Oac");
                }
                if (att.containsKey("field_C5uxACkZr6spdqQ5")) {
                    field_C5uxACkZr6spdqQ5  = att.getString("field_C5uxACkZr6spdqQ5");
                }
                if (att.containsKey("field_5Rk0VwrhvpowVZ2c")) {
                    field_5Rk0VwrhvpowVZ2c  = att.getString("field_5Rk0VwrhvpowVZ2c");
                }
                if (att.containsKey("field_Kp3R9ntn6wD0YFsS")) {
                    field_Kp3R9ntn6wD0YFsS  = att.getString("field_Kp3R9ntn6wD0YFsS");
                }
                if (att.containsKey("field_SrBt93INUCMXdOnp")) {
                    field_SrBt93INUCMXdOnp  = att.getString("field_SrBt93INUCMXdOnp");
                }
                if (att.containsKey("field_3AKvuOidKGMs8rYa")) {
                    field_3AKvuOidKGMs8rYa  = att.getString("field_3AKvuOidKGMs8rYa");
                }
                if (att.containsKey("paymentMethod")) {
                    paymentMethod  = att.getString("paymentMethod");
                }
                if (att.containsKey("field_xycfmIsIi7BhT4Gs")) {
                    field_xycfmIsIi7BhT4Gs  = att.getString("field_xycfmIsIi7BhT4Gs");
                }
                if (att.containsKey("field_0J2DCtsLEtZ0cjZq")) {
                    field_0J2DCtsLEtZ0cjZq  = att.getString("field_0J2DCtsLEtZ0cjZq");
                }
                if (att.containsKey("field_uYbYVezdQ23Fjzis")) {
                    field_uYbYVezdQ23Fjzis  = att.getString("field_uYbYVezdQ23Fjzis");
                }
                if (att.containsKey("field_h36G3FuKVEHsGp1W")) {
                    field_h36G3FuKVEHsGp1W  = att.getString("field_h36G3FuKVEHsGp1W");
                }
                if (att.containsKey("field_iPflqZaaUHXMhN3j")) {
                    field_iPflqZaaUHXMhN3j  = att.getString("field_iPflqZaaUHXMhN3j");
                }
                if (att.containsKey("field_mdMsQ4wPHGgf1MCk")) {
                    field_mdMsQ4wPHGgf1MCk  = att.getString("field_mdMsQ4wPHGgf1MCk");
                }
                if (att.containsKey("field_slkS2xmmH5nEkQ30")) {
                    field_slkS2xmmH5nEkQ30  = att.getString("field_slkS2xmmH5nEkQ30");
                }
                if (att.containsKey("sparepart")) {
                    sparepart  = att.getString("sparepart");
                }
                if (att.containsKey("receiptAttachment")) {
                    receiptAttachment  = att.getString("receiptAttachment");
                }
                if (att.containsKey("serviceIterm")) {
                    serviceIterm  = att.getString("serviceIterm");
                }
            }
            psql = con.prepareStatement("insert into taskattribute (customReceipt,field_mw14ov4M09NQ6mFu,field_vahTMFEJgz4riJy5,field_BKzX3eYzndTcLhkK,field_1aKmjxaXXlEAHLeP,field_TTb1jR2CzHrKpBCM,field_pTlybqN5Lf1n14OJ,field_ucUWJ2GBCTw2sEzu,field_id0AudS1SKPyqb6H, field_Hb9yHzXFuSRwAD0p,field_OUmy82mWlKmk8Oac,field_C5uxACkZr6spdqQ5,field_5Rk0VwrhvpowVZ2c,field_Kp3R9ntn6wD0YFsS,field_SrBt93INUCMXdOnp,field_3AKvuOidKGMs8rYa,paymentMethod,field_xycfmIsIi7BhT4Gs,field_0J2DCtsLEtZ0cjZq,field_uYbYVezdQ23Fjzis,field_h36G3FuKVEHsGp1W,field_iPflqZaaUHXMhN3j,field_mdMsQ4wPHGgf1MCk,field_slkS2xmmH5nEkQ30,taskNo,sparepart,receiptAttachment,serviceIterm) value (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

            psql.setString(1, customReceipt);
            psql.setString(2, field_mw14ov4M09NQ6mFu);
            psql.setString(3, field_vahTMFEJgz4riJy5);
            psql.setString(4, field_BKzX3eYzndTcLhkK);
            psql.setString(5, field_1aKmjxaXXlEAHLeP);
            psql.setString(6, field_TTb1jR2CzHrKpBCM);
            psql.setString(7, field_pTlybqN5Lf1n14OJ);
            psql.setString(8, field_ucUWJ2GBCTw2sEzu);
            psql.setString(9, field_id0AudS1SKPyqb6H);
            psql.setString(10, field_Hb9yHzXFuSRwAD0p);
            psql.setString(11, field_OUmy82mWlKmk8Oac);
            psql.setString(12, field_C5uxACkZr6spdqQ5);
            psql.setString(13, field_5Rk0VwrhvpowVZ2c);
            psql.setString(14, field_Kp3R9ntn6wD0YFsS);
            psql.setString(15, field_SrBt93INUCMXdOnp);
            psql.setString(16, field_3AKvuOidKGMs8rYa);
            psql.setString(17, paymentMethod);
            psql.setString(18, field_xycfmIsIi7BhT4Gs);
            psql.setString(19, field_0J2DCtsLEtZ0cjZq);
            psql.setString(20, field_uYbYVezdQ23Fjzis);
            psql.setString(21, field_h36G3FuKVEHsGp1W);
            psql.setString(22, field_iPflqZaaUHXMhN3j);
            psql.setString(23, field_mdMsQ4wPHGgf1MCk);
            psql.setString(24, field_slkS2xmmH5nEkQ30);
            psql.setString(25, taskNo);
            psql.setString(26, sparepart);
            psql.setString(27, receiptAttachment);
            psql.setString(28, serviceIterm);
            psql.executeUpdate();


        }
        catch (JsonIOException e1) {
            e1.printStackTrace();
        } catch (JsonSyntaxException e1) {
            e1.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }











}
