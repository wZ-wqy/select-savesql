package com.itzhoujun.usercenter.controller.user;


import net.sf.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.security.MessageDigest;


public class TestPost {
    final static String url = "https://oapi.shb.ltd/service/auth/get_access_token";
    final static String jsonContent = null;



    /**
     * 发送HttpPost请求
     *
     * @param strURL
     *            服务地址
     * @param params
     *            json字符串,例如: "{ \"id\":\"12345\" }" ;其中属性名必须带双引号<br/>
     * @return 成功:返回json字符串<br/>
     */
    /**
     *
     * @param url 请求连接
     * @param jsonContent json字符串
     * @return 响应值，json字符串
     */
    public static String httpPostJson(String url, String jsonContent) {
        int time = (int) (System.currentTimeMillis() / 1000);
        String verCode = "cdb38c08e6d0d97608f7d6b5d0b0081fc86146b361f2fb8f"+"_"+time;
        JSONObject json = new JSONObject();
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(verCode.getBytes());//update处理
            byte b[] = md.digest();
            int i;//定义整型
            //声明StringBuffer对象
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];//将首个元素赋值给i
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");//前面补0
                buf.append(Integer.toHexString(i));//转换成16进制编码
            }
            verCode = buf.toString();//转换成字符串
            json = new JSONObject();
            json.put("appKey", "shbbhy925u8bpptfs7");
            json.put("timestamp", time);
            json.put("verifyCode", verCode);
            verCode = json.toString();
        }
        catch(Exception e){
            System.out.println("Wrong!");
        }
        CloseableHttpResponse response = null;
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost(url);
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(3000).setConnectTimeout(3000).build();
        httpPost.setConfig(requestConfig);
        httpPost.addHeader("Content-Type", "application/json");
        StringEntity requestEntity = new StringEntity(verCode, "utf-8");
        httpPost.setEntity(requestEntity);
        try {
            response = httpClient.execute(httpPost, new BasicHttpContext());
            if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
                return null;
            }
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                String resultStr = EntityUtils.toString(entity, "utf-8");
                return resultStr;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}