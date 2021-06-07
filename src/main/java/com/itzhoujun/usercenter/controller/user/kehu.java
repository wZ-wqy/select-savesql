package com.itzhoujun.usercenter.controller.user;

import net.sf.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class kehu {

    final static String url = "https://oapi.shb.ltd/service/auth/get_access_token";
    final static String jsonContent = null;


    public static void selectkehu() {
        String res = TestPost.httpPostJson(url, jsonContent);
        res = res.replace("\\","");
        res = res.substring(0, res.length() -1);
        res = res.substring(1);
        JSONObject js =  JSONObject.fromObject(res);
        String token = js.getJSONObject("data").get("access_token").toString();
        String urlg = "https://oapi.shb.ltd/service/customer/get_customer_customerNo?accessToken="+token;
        urlg = urlg+"&customerNo=CUSXQ00419";
        System.out.println(urlg);
        String sr = kh(urlg);
        System.out.println(sr);


    }

    public static String kh(String urlg) {
        String result = "";
        try {
            URL url = new URL(urlg);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            //get请求
            conn.setRequestMethod("GET");
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
            conn.setUseCaches(false);
            conn.connect();
            InputStream is = conn.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String str = "";
            while ((str = br.readLine()) != null) {
                result += str;
            }

            is.close();
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }



}
